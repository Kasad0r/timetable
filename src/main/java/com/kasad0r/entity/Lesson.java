package com.kasad0r.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Lesson {
    @JsonProperty("lesson_name")
    private String name;
    @JsonProperty("lesson_teacher_name")
    private Teacher teacher;

    @Override
    public String toString() {
        return "Lesson{" +
                "name='" + name + '\'' +
                ", teacher=" + teacher +
                '}';
    }

    public String getName() {
        return name;
    }

    public Lesson(String name){
        this.name = name;
    }

    public Lesson(){

    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }


    public Lesson setTeacher(Teacher teacher) {
        this.teacher = teacher;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lesson lesson = (Lesson) o;
        return Objects.equals(name, lesson.name) &&
                Objects.equals(teacher, lesson.teacher);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, teacher);
    }
}
