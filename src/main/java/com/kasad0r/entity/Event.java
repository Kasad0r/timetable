package com.kasad0r.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Event {
    @JsonProperty("event_name")
    String name;
}
