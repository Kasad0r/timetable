package com.kasad0r.telegram.student_notify.enitiy;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Objects;

public class Student implements Serializable {
    private long Id;
    private Group group = new Group();
    private boolean scheduleNotification;
    private LocalTime timeToPushSchedule;
    private Trigger trigger;

    public Student(long id) {
        Id = id;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "Id=" + Id +
                ", group=" + group +
                ", scheduleNotification=" + scheduleNotification +
                ", timeToPushSchedule=" + timeToPushSchedule +
                ", trigger=" + trigger +
                '}';
    }

    public Student(long id, Group group, boolean scheduleNotification, LocalTime timeToPushSchedule, Trigger trigger) {
        Id = id;
        this.group = group;
        this.scheduleNotification = scheduleNotification;
        this.timeToPushSchedule = timeToPushSchedule;
        this.trigger = trigger;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Id == student.Id &&
                scheduleNotification == student.scheduleNotification &&
                Objects.equals(group, student.group) &&
                Objects.equals(timeToPushSchedule, student.timeToPushSchedule) &&
                trigger == student.trigger;
    }

    @Override
    public int hashCode() {

        return Objects.hash(Id, group, scheduleNotification, timeToPushSchedule, trigger);
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public boolean isScheduleNotification() {
        return scheduleNotification;
    }

    public void setScheduleNotification(boolean scheduleNotification) {
        this.scheduleNotification = scheduleNotification;
    }

    public LocalTime getTimeToPushSchedule() {
        return timeToPushSchedule;
    }

    public void setTimeToPushSchedule(LocalTime timeToPushSchedule) {
        this.timeToPushSchedule = timeToPushSchedule;
    }

    public Trigger getTrigger() {
        return trigger;
    }

    public void setTrigger(Trigger trigger) {
        this.trigger = trigger;
    }
}
