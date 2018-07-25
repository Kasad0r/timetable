package com.kasad0r.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class DayOfTheWeek {
    @JsonProperty("day_of_the_week")
   private String dayName;
    @JsonProperty("lessons")
   private Map<Lesson, TimeOfLessons.Pair> lessons;

    public String getDayName() {
        return dayName;
    }

    public DayOfTheWeek setDayName(String dayName) {
        this.dayName = dayName;
        return this;
    }

    public Map<Lesson, TimeOfLessons.Pair> getLessons() {
        return lessons;
    }

    public DayOfTheWeek setLessons(Map<Lesson, TimeOfLessons.Pair> lessons) {
        this.lessons = lessons;
        return this;
    }

    @Override
    public String toString() {
        return "DayOfTheWeek{" +
                "dayName='" + dayName + '\'' +
                ", lessons=" + lessons +
                '}';
    }
}
