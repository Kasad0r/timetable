package com.kasad0r.telegram.student_notify.enitiy;

import java.io.Serializable;
import java.util.Objects;

public class Group implements Serializable {
    private int course;
    private int specialty;
    private int groupNum;

    public Group() {
    }

    public Group(String group) {
        course = Character.getNumericValue(group.charAt(0));
        specialty = Character.getNumericValue(group.charAt(1));
        groupNum = Character.getNumericValue(group.charAt(2));
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public int getSpecialty() {
        return specialty;
    }

    public void setSpecialty(int specialty) {
        this.specialty = specialty;
    }

    public int getGroupNum() {
        return groupNum;
    }

    public void setGroupNum(int groupNum) {
        this.groupNum = groupNum;
    }

    public String getGroupName() {
        return "" + course + specialty + groupNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return course == group.course &&
                specialty == group.specialty &&
                groupNum == group.groupNum;
    }

    @Override
    public int hashCode() {

        return Objects.hash(course, specialty, groupNum);
    }

    @Override
    public String toString() {
        return "Group{" +
                "course=" + course +
                ", specialty=" + specialty +
                ", groupNum=" + groupNum +
                '}';
    }
}
