package com.kasad0r.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Group {
    @JsonProperty("group_name")
    private String groupName;
    @JsonProperty("group_schedule")
    private List<DayOfTheWeek> daysOfWeek;
    @JsonProperty("group_day_off")
    private boolean dayOff;
    @JsonProperty("group_events")
    private List<Event> events;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<DayOfTheWeek> getDaysOfWeek() {
        return daysOfWeek;
    }

    public void setDaysOfWeek(List<DayOfTheWeek> daysOfWeek) {
        this.daysOfWeek = daysOfWeek;
    }

    public boolean isDayOff() {
        return dayOff;
    }

    public void setDayOff(boolean dayOff) {
        this.dayOff = dayOff;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupName='" + groupName + '\'' +
                ", daysOfWeek=" + daysOfWeek +
                ", dayOff=" + dayOff +
                ", events=" + events +
                '}';
    }
}
