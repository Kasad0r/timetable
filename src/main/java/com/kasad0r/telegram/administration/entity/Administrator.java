package com.kasad0r.telegram.administration.entity;

import org.apache.commons.codec.digest.DigestUtils;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class Administrator implements Serializable, Comparable<Administrator> {

    private final byte[] userId;
    private Trigger trigger = Trigger.NONE;

    public Administrator(long userId) {
        this.userId = DigestUtils.md5(String.valueOf(userId));

    }

    public Trigger getTrigger() {
        return trigger;
    }

    public void setTrigger(Trigger trigger) {
        this.trigger = trigger;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Administrator that = (Administrator) o;
        return userId == that.userId &&
                Arrays.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {

        return Arrays.hashCode(userId);
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "userId=" + Arrays.toString(userId) +
                '}';
    }

    @Override
    public int compareTo(@NotNull Administrator o) {
        return Arrays.hashCode(this.userId) - Arrays.hashCode(o.userId);
    }
}
