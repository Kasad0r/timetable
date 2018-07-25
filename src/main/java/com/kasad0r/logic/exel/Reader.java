package com.kasad0r.logic.exel;

import com.kasad0r.entity.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Reader {
    /**
     * @param param
     * @return
     */
    public static List<File> getExelDocsFilePaths(String param) {
        File exelDocsFolder = new File("/home/kasad0r/Documents/timetable/src/main/resources/exel_group_timetable_container");
        return Arrays.asList(Objects.requireNonNull(exelDocsFolder.listFiles((dir, name)
                -> name.endsWith(param))));
    }

    //To initialize
    public static List<String> getGroupNamesFromShedule() {
        List<String> groups = new ArrayList<>();
        try (FileInputStream inputStream = new FileInputStream(getExelDocsFilePaths(".xls").get(0))) {
            HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
            for (Sheet aWorkbook : workbook) {
                groups.add(aWorkbook.getSheetName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return groups;
    }

    /**
     * @param file
     * @return
     */
    public List<Group> readXLSDoc(File file) {
        List<Group> groupList = new ArrayList<>();

        if (file != null) {

            StringBuilder result = new StringBuilder();
            FileInputStream inputStream;
            try {
                inputStream = new FileInputStream(file);
                HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
                for (Sheet aWorkbook : workbook) {
                    groupList.add(getInfoFromSheet(aWorkbook));
                }
                System.out.println(result);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return groupList;
    }

    /**
     * @param sheet
     * @return
     */
    private static Group getInfoFromSheet(Sheet sheet) {
        Group group = new Group();
        group.setGroupName(sheet.getSheetName());
        List<DayOfTheWeek> dayOfTheWeeks = new ArrayList<>();
        Map<Lesson, TimeOfLessons.Pair> lessonTimeOfLessonsMap = new LinkedHashMap<>();

        List<LessonAndTime> dayLessons = new ArrayList<>();
        dayLessons.add(createPare(sheet, CellCordinatesDayOfWeeks.MON_TIME_0, CellCordinatesDayOfWeeks.MON_LESSON_0, CellCordinatesDayOfWeeks.MON_TEACHER_0));
        dayLessons.add(createPare(sheet, CellCordinatesDayOfWeeks.MON_TIME_1, CellCordinatesDayOfWeeks.MON_LESSON_1, CellCordinatesDayOfWeeks.MON_TEACHER_1));
        dayLessons.add(createPare(sheet, CellCordinatesDayOfWeeks.MON_TIME_2, CellCordinatesDayOfWeeks.MON_LESSON_2, CellCordinatesDayOfWeeks.MON_TEACHER_2));
        dayLessons.add(createPare(sheet, CellCordinatesDayOfWeeks.MON_TIME_3, CellCordinatesDayOfWeeks.MON_LESSON_3, CellCordinatesDayOfWeeks.MON_TEACHER_3));
        dayLessons.add(createPare(sheet, CellCordinatesDayOfWeeks.MON_TIME_4, CellCordinatesDayOfWeeks.MON_LESSON_4, CellCordinatesDayOfWeeks.MON_TEACHER_4));
        dayLessons.add(createPare(sheet, CellCordinatesDayOfWeeks.MON_TIME_5, CellCordinatesDayOfWeeks.MON_LESSON_5, CellCordinatesDayOfWeeks.MON_TEACHER_5));
        dayLessons.add(createPare(sheet, CellCordinatesDayOfWeeks.MON_TIME_6, CellCordinatesDayOfWeeks.MON_LESSON_6, CellCordinatesDayOfWeeks.MON_TEACHER_6));
        dayLessons.add(createPare(sheet, CellCordinatesDayOfWeeks.MON_TIME_7, CellCordinatesDayOfWeeks.MON_LESSON_7, CellCordinatesDayOfWeeks.MON_TEACHER_7));
        dayLessons.forEach(elem -> lessonTimeOfLessonsMap.put(elem.getLesson(),
                TimeOfLessons.getPairTimeByPairId(elem.getInteger())));
        dayOfTheWeeks.add(new DayOfTheWeek().setLessons(lessonTimeOfLessonsMap).setDayName(sheet
                .getRow(CellCordinatesDayOfWeeks.MONDAY.getRowPos()).getCell(CellCordinatesDayOfWeeks.MONDAY.getCellPos()).getStringCellValue()));
        dayLessons.clear();

        dayLessons.add(createPare(sheet, CellCordinatesDayOfWeeks.THU_TIME_0, CellCordinatesDayOfWeeks.THU_LESSON_0, CellCordinatesDayOfWeeks.THU_TEACHER_0));
        dayLessons.add(createPare(sheet, CellCordinatesDayOfWeeks.THU_TIME_1, CellCordinatesDayOfWeeks.THU_LESSON_1, CellCordinatesDayOfWeeks.THU_TEACHER_1));
        dayLessons.add(createPare(sheet, CellCordinatesDayOfWeeks.THU_TIME_2, CellCordinatesDayOfWeeks.THU_LESSON_2, CellCordinatesDayOfWeeks.THU_TEACHER_2));
        dayLessons.add(createPare(sheet, CellCordinatesDayOfWeeks.THU_TIME_3, CellCordinatesDayOfWeeks.THU_LESSON_3, CellCordinatesDayOfWeeks.THU_TEACHER_3));
        dayLessons.add(createPare(sheet, CellCordinatesDayOfWeeks.THU_TIME_4, CellCordinatesDayOfWeeks.THU_LESSON_4, CellCordinatesDayOfWeeks.THU_TEACHER_4));
        dayLessons.add(createPare(sheet, CellCordinatesDayOfWeeks.THU_TIME_5, CellCordinatesDayOfWeeks.THU_LESSON_5, CellCordinatesDayOfWeeks.THU_TEACHER_5));
        dayLessons.add(createPare(sheet, CellCordinatesDayOfWeeks.THU_TIME_6, CellCordinatesDayOfWeeks.THU_LESSON_6, CellCordinatesDayOfWeeks.THU_TEACHER_6));
        dayLessons.add(createPare(sheet, CellCordinatesDayOfWeeks.THU_TIME_7, CellCordinatesDayOfWeeks.THU_LESSON_7, CellCordinatesDayOfWeeks.THU_TEACHER_7));
        dayLessons.forEach(elem -> lessonTimeOfLessonsMap.put(elem.getLesson(),
                TimeOfLessons.getPairTimeByPairId(elem.getInteger())));
        dayOfTheWeeks.add(new DayOfTheWeek().setLessons(lessonTimeOfLessonsMap).setDayName(sheet
                .getRow(CellCordinatesDayOfWeeks.TUESDAY.getRowPos()).getCell(CellCordinatesDayOfWeeks.TUESDAY.getCellPos()).getStringCellValue()));
        dayLessons.clear();

        dayLessons.add(createPare(sheet, CellCordinatesDayOfWeeks.WED_TIME_0, CellCordinatesDayOfWeeks.WED_LESSON_0, CellCordinatesDayOfWeeks.WED_TEACHER_0));
        dayLessons.add(createPare(sheet, CellCordinatesDayOfWeeks.WED_TIME_1, CellCordinatesDayOfWeeks.WED_LESSON_1, CellCordinatesDayOfWeeks.WED_TEACHER_1));
        dayLessons.add(createPare(sheet, CellCordinatesDayOfWeeks.WED_TIME_2, CellCordinatesDayOfWeeks.WED_LESSON_2, CellCordinatesDayOfWeeks.WED_TEACHER_2));
        dayLessons.add(createPare(sheet, CellCordinatesDayOfWeeks.WED_TIME_3, CellCordinatesDayOfWeeks.WED_LESSON_3, CellCordinatesDayOfWeeks.WED_TEACHER_3));
        dayLessons.add(createPare(sheet, CellCordinatesDayOfWeeks.WED_TIME_4, CellCordinatesDayOfWeeks.WED_LESSON_4, CellCordinatesDayOfWeeks.WED_TEACHER_4));
        dayLessons.add(createPare(sheet, CellCordinatesDayOfWeeks.WED_TIME_5, CellCordinatesDayOfWeeks.WED_LESSON_5, CellCordinatesDayOfWeeks.WED_TEACHER_5));
        dayLessons.add(createPare(sheet, CellCordinatesDayOfWeeks.WED_TIME_6, CellCordinatesDayOfWeeks.WED_LESSON_6, CellCordinatesDayOfWeeks.WED_TEACHER_6));
        dayLessons.add(createPare(sheet, CellCordinatesDayOfWeeks.WED_TIME_7, CellCordinatesDayOfWeeks.WED_LESSON_7, CellCordinatesDayOfWeeks.WED_TEACHER_7));
        dayLessons.forEach(elem -> lessonTimeOfLessonsMap.put(elem.getLesson(),
                TimeOfLessons.getPairTimeByPairId(elem.getInteger())));
        dayOfTheWeeks.add(new DayOfTheWeek().setLessons(lessonTimeOfLessonsMap).setDayName(sheet
                .getRow(CellCordinatesDayOfWeeks.WEDNESDAY.getRowPos()).getCell(CellCordinatesDayOfWeeks.WEDNESDAY.getCellPos()).getStringCellValue()));
        dayLessons.clear();

        dayLessons.add(createPare(sheet, CellCordinatesDayOfWeeks.THR_TIME_0, CellCordinatesDayOfWeeks.THR_LESSON_0, CellCordinatesDayOfWeeks.THR_TEACHER_0));
        dayLessons.add(createPare(sheet, CellCordinatesDayOfWeeks.THR_TIME_1, CellCordinatesDayOfWeeks.THR_LESSON_1, CellCordinatesDayOfWeeks.THR_TEACHER_1));
        dayLessons.add(createPare(sheet, CellCordinatesDayOfWeeks.THR_TIME_2, CellCordinatesDayOfWeeks.THR_LESSON_2, CellCordinatesDayOfWeeks.THR_TEACHER_2));
        dayLessons.add(createPare(sheet, CellCordinatesDayOfWeeks.THR_TIME_3, CellCordinatesDayOfWeeks.THR_LESSON_3, CellCordinatesDayOfWeeks.THR_TEACHER_3));
        dayLessons.add(createPare(sheet, CellCordinatesDayOfWeeks.THR_TIME_4, CellCordinatesDayOfWeeks.THR_LESSON_4, CellCordinatesDayOfWeeks.THR_TEACHER_4));
        dayLessons.add(createPare(sheet, CellCordinatesDayOfWeeks.THR_TIME_5, CellCordinatesDayOfWeeks.THR_LESSON_5, CellCordinatesDayOfWeeks.THR_TEACHER_5));
        dayLessons.add(createPare(sheet, CellCordinatesDayOfWeeks.THR_TIME_6, CellCordinatesDayOfWeeks.THR_LESSON_6, CellCordinatesDayOfWeeks.THR_TEACHER_6));
        dayLessons.add(createPare(sheet, CellCordinatesDayOfWeeks.THR_TIME_7, CellCordinatesDayOfWeeks.THR_LESSON_7, CellCordinatesDayOfWeeks.THR_TEACHER_7));
        dayLessons.forEach(elem -> lessonTimeOfLessonsMap.put(elem.getLesson(),
                TimeOfLessons.getPairTimeByPairId(elem.getInteger())));
        dayOfTheWeeks.add(new DayOfTheWeek().setLessons(lessonTimeOfLessonsMap).setDayName(sheet
                .getRow(CellCordinatesDayOfWeeks.THURSDAY.getRowPos()).getCell(CellCordinatesDayOfWeeks.THURSDAY.getCellPos()).getStringCellValue()));
        dayLessons.clear();

        dayLessons.add(createPare(sheet, CellCordinatesDayOfWeeks.FRI_TIME_0, CellCordinatesDayOfWeeks.FRI_LESSON_0, CellCordinatesDayOfWeeks.FRI_TEACHER_0));
        dayLessons.add(createPare(sheet, CellCordinatesDayOfWeeks.FRI_TIME_1, CellCordinatesDayOfWeeks.FRI_LESSON_1, CellCordinatesDayOfWeeks.FRI_TEACHER_1));
        dayLessons.add(createPare(sheet, CellCordinatesDayOfWeeks.FRI_TIME_2, CellCordinatesDayOfWeeks.FRI_LESSON_2, CellCordinatesDayOfWeeks.FRI_TEACHER_2));
        dayLessons.add(createPare(sheet, CellCordinatesDayOfWeeks.FRI_TIME_3, CellCordinatesDayOfWeeks.FRI_LESSON_3, CellCordinatesDayOfWeeks.FRI_TEACHER_3));
        dayLessons.add(createPare(sheet, CellCordinatesDayOfWeeks.FRI_TIME_4, CellCordinatesDayOfWeeks.FRI_LESSON_4, CellCordinatesDayOfWeeks.FRI_TEACHER_4));
        dayLessons.add(createPare(sheet, CellCordinatesDayOfWeeks.FRI_TIME_5, CellCordinatesDayOfWeeks.FRI_LESSON_5, CellCordinatesDayOfWeeks.FRI_TEACHER_5));
        dayLessons.add(createPare(sheet, CellCordinatesDayOfWeeks.FRI_TIME_6, CellCordinatesDayOfWeeks.FRI_LESSON_6, CellCordinatesDayOfWeeks.FRI_TEACHER_6));
        dayLessons.add(createPare(sheet, CellCordinatesDayOfWeeks.FRI_TIME_7, CellCordinatesDayOfWeeks.FRI_LESSON_7, CellCordinatesDayOfWeeks.FRI_TEACHER_7));
        dayLessons.forEach(elem -> lessonTimeOfLessonsMap.put(elem.getLesson(),
                TimeOfLessons.getPairTimeByPairId(elem.getInteger())));
        dayOfTheWeeks.add(new DayOfTheWeek().setLessons(lessonTimeOfLessonsMap).setDayName(sheet
                .getRow(CellCordinatesDayOfWeeks.FRIDAY.getRowPos()).getCell(CellCordinatesDayOfWeeks.FRIDAY.getCellPos()).getStringCellValue()));
        dayLessons.clear();

        dayLessons.add(createPare(sheet, CellCordinatesDayOfWeeks.SAT_TIME_0, CellCordinatesDayOfWeeks.SAT_LESSON_0, CellCordinatesDayOfWeeks.SAT_TEACHER_0));
        dayLessons.add(createPare(sheet, CellCordinatesDayOfWeeks.SAT_TIME_1, CellCordinatesDayOfWeeks.SAT_LESSON_1, CellCordinatesDayOfWeeks.SAT_TEACHER_1));
        dayLessons.add(createPare(sheet, CellCordinatesDayOfWeeks.SAT_TIME_2, CellCordinatesDayOfWeeks.SAT_LESSON_2, CellCordinatesDayOfWeeks.SAT_TEACHER_2));
        dayLessons.add(createPare(sheet, CellCordinatesDayOfWeeks.SAT_TIME_3, CellCordinatesDayOfWeeks.SAT_LESSON_3, CellCordinatesDayOfWeeks.SAT_TEACHER_3));
        dayLessons.add(createPare(sheet, CellCordinatesDayOfWeeks.SAT_TIME_4, CellCordinatesDayOfWeeks.SAT_LESSON_4, CellCordinatesDayOfWeeks.SAT_TEACHER_4));
        dayLessons.add(createPare(sheet, CellCordinatesDayOfWeeks.SAT_TIME_5, CellCordinatesDayOfWeeks.SAT_LESSON_5, CellCordinatesDayOfWeeks.SAT_TEACHER_5));
        dayLessons.add(createPare(sheet, CellCordinatesDayOfWeeks.SAT_TIME_6, CellCordinatesDayOfWeeks.SAT_LESSON_6, CellCordinatesDayOfWeeks.SAT_TEACHER_6));
        dayLessons.add(createPare(sheet, CellCordinatesDayOfWeeks.SAT_TIME_7, CellCordinatesDayOfWeeks.SAT_LESSON_7, CellCordinatesDayOfWeeks.SAT_TEACHER_7));
        dayLessons.forEach(elem -> lessonTimeOfLessonsMap.put(elem.getLesson(),
                TimeOfLessons.getPairTimeByPairId(elem.getInteger())));
        dayOfTheWeeks.add(new DayOfTheWeek().setLessons(lessonTimeOfLessonsMap).setDayName(sheet
                .getRow(CellCordinatesDayOfWeeks.SATURDAY.getRowPos()).getCell(CellCordinatesDayOfWeeks.SATURDAY.getCellPos()).getStringCellValue()));
        dayLessons.clear();
        dayLessons.add(createPare(sheet, CellCordinatesDayOfWeeks.SUN_TIME_0, CellCordinatesDayOfWeeks.SUN_LESSON_0, CellCordinatesDayOfWeeks.SUN_TEACHER_0));
        dayLessons.add(createPare(sheet, CellCordinatesDayOfWeeks.SUN_TIME_1, CellCordinatesDayOfWeeks.SUN_LESSON_1, CellCordinatesDayOfWeeks.SUN_TEACHER_1));
        dayLessons.add(createPare(sheet, CellCordinatesDayOfWeeks.SUN_TIME_2, CellCordinatesDayOfWeeks.SUN_LESSON_2, CellCordinatesDayOfWeeks.SUN_TEACHER_2));
        dayLessons.add(createPare(sheet, CellCordinatesDayOfWeeks.SUN_TIME_3, CellCordinatesDayOfWeeks.SUN_LESSON_3, CellCordinatesDayOfWeeks.SUN_TEACHER_3));
        dayLessons.add(createPare(sheet, CellCordinatesDayOfWeeks.SUN_TIME_4, CellCordinatesDayOfWeeks.SUN_LESSON_4, CellCordinatesDayOfWeeks.SUN_TEACHER_4));
        dayLessons.add(createPare(sheet, CellCordinatesDayOfWeeks.SUN_TIME_5, CellCordinatesDayOfWeeks.SUN_LESSON_5, CellCordinatesDayOfWeeks.SUN_TEACHER_5));
        dayLessons.add(createPare(sheet, CellCordinatesDayOfWeeks.SUN_TIME_6, CellCordinatesDayOfWeeks.SUN_LESSON_6, CellCordinatesDayOfWeeks.SUN_TEACHER_6));
        dayLessons.add(createPare(sheet, CellCordinatesDayOfWeeks.SUN_TIME_7, CellCordinatesDayOfWeeks.SUN_LESSON_7, CellCordinatesDayOfWeeks.SUN_TEACHER_7));
        dayLessons.forEach(elem -> lessonTimeOfLessonsMap.put(elem.getLesson(),
                TimeOfLessons.getPairTimeByPairId(elem.getInteger())));
        dayOfTheWeeks.add(new DayOfTheWeek().setLessons(lessonTimeOfLessonsMap).setDayName(sheet
                .getRow(CellCordinatesDayOfWeeks.SUNDAY.getRowPos()).getCell(CellCordinatesDayOfWeeks.SUNDAY.getCellPos()).getStringCellValue()));
        dayLessons.clear();
        group.setDaysOfWeek(dayOfTheWeeks);
        return group;
    }

    private static LessonAndTime createPare(Sheet sheet, CellCordinatesDayOfWeeks time, CellCordinatesDayOfWeeks lesson, CellCordinatesDayOfWeeks teacher) {
        return new LessonAndTime((int) sheet.getRow(time.getRowPos())
                .getCell(time.getCellPos()).getNumericCellValue(),
                new Lesson(sheet.getRow(lesson.getRowPos())
                        .getCell(lesson.getCellPos()).getStringCellValue())
                        .setTeacher(new Teacher(sheet.getRow(teacher.getRowPos())
                                .getCell(teacher.getCellPos()).getStringCellValue())));
    }


    private static final class LessonAndTime {
        final Integer integer;
        final Lesson lesson;

        LessonAndTime(Integer integer, Lesson lesson) {
            this.integer = integer;
            this.lesson = lesson;
        }

        Integer getInteger() {
            return integer;
        }

        @Override
        public String toString() {
            return "LessonAndTime{" +
                    "integer=" + integer +
                    ", lesson=" + lesson +
                    '}';
        }

        Lesson getLesson() {
            return lesson;
        }
    }

}
