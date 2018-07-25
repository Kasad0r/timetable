package com.kasad0r.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Teacher {
    @JsonProperty("teacher_name")
    private String teacherName;

    public Teacher(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherName='" + teacherName + '\'' +
                '}';
    }
}
