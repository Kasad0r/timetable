package com.kasad0r.telegram.student_notify.controller;

import com.kasad0r.telegram.student_notify.enitiy.Student;
import org.apache.commons.io.FileUtils;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.telegram.telegrambots.api.objects.Update;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentController {
    private static StudentController studentController = new StudentController();
    private static final String hashCodePath = "src/main/resources/hashcodes/students/";
    private static final String classname = "com.kasad0r.telegram.student_notify.controller.StudentController";
    private static Logger logger = Logger.getLogger(classname);
    private static List<Student> students = new ArrayList<>();

    private StudentController() {

    }

    public static StudentController getInstance() {
        return studentController;
    }

    static {
        Serialize.deserializeAllStudents();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void registerUser(Update update) {
        logger.entering(classname, "registerUser");
        Student student = new Student();
        student.setId(update.getMessage().getChatId());
        students.add(student);
        logger.info("Add to serializeStudents: " + student);
        System.out.println(students);
        Serialize.student(student);
        logger.exiting(classname, "registerUser");
    }

    public static boolean checkUser(long userId) {
        return students.stream().anyMatch(elem -> elem.getId() == userId);
    }

    public static Student getStudent(long userId) {
        System.out.println(students);
        return students.stream().filter(elem -> elem.getId() == userId).findAny().orElse(null);
    }

    public static void startFollowingList() {
        try {

            JobDetail job = JobBuilder.newJob(StudentController.Serialize.class)
                    .withIdentity("saveListToSer", "group1").build();

            Trigger t = TriggerBuilder.newTrigger().withIdentity("saveTrigger", "group1")
                    .withSchedule(SimpleScheduleBuilder.repeatMinutelyForever(2))
                    .build();

            Scheduler sh = StdSchedulerFactory.getDefaultScheduler();
            sh.start();
            sh.scheduleJob(job, t);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    public static class Serialize implements Job {
        public static void serializeStudents() {
            for (Student s : students
                    ) {
                student(s);
            }
        }

        private static void student(Student student) {
            logger.entering(classname, "student", student);
            try (ObjectOutputStream oos =
                         new ObjectOutputStream(new FileOutputStream(hashCodePath
                                 + student.hashCode() + ".ser"))) {
                oos.writeObject(student);
                logger.info("Student write :" + student.hashCode() + ".ser Done!");
            } catch (Exception ex) {
                logger.log(Level.WARNING, "student", ex);
            }
            logger.exiting(classname, "student");
        }

        private static Student deserializeStudent(File filename) {
            Student student = null;
            try (ObjectInputStream ois
                         = new ObjectInputStream(new FileInputStream(filename))) {
                student = (Student) ois.readObject();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return student;
        }

        private static List<File> getSerializeObj() {
            File path = new File(hashCodePath);
            return Arrays.asList(Objects.requireNonNull(path.listFiles()));
        }

        public static void deserializeAllStudents() {
            for (File f : getSerializeObj()
                    ) {
                Student student = deserializeStudent(f);
                System.out.println(student);
                if (!students.contains(student)) {
                    students.add(student);
                } else {
                    logger.warning("Try to add same student : " + student.toString());
                }
            }
            logger.info("Deserialize Students complete!");
        }

        private static void serializeStudentTempList() {
            if (students.size() < 1) {
                deserializeAllStudents();
            } else {
                try {
                    FileUtils.cleanDirectory(new File(hashCodePath));
                    serializeStudents();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public void execute(JobExecutionContext jobExecutionContext) {
            logger.info("Start backup students");
            Serialize.serializeStudentTempList();
        }

    }

}
