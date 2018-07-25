package com.kasad0r.entity;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public final class TimeOfLessons {


    private static final HalfPair sevenThirtyToEightTwenty = new HalfPair(LocalTime.of(7, 30),
            LocalTime.of(8, 20));
    private static final Pair TIME_7_30_TO_8_20 = new Pair(sevenThirtyToEightTwenty, null);


    private static final HalfPair eightThirtyToNineFifteen = new HalfPair(LocalTime.of(8, 30),
            LocalTime.of(9, 15));
    private static final HalfPair nineTwentyToTenZeroFive = new HalfPair(LocalTime.of(9, 20),
            LocalTime.of(10, 5));
    private static final Pair TIME_8_30_TO_10_05 = new Pair(eightThirtyToNineFifteen, nineTwentyToTenZeroFive);


    private static final HalfPair tenFifteenToEleven = new HalfPair(LocalTime.of(10, 15),
            LocalTime.of(11, 0));
    private static final HalfPair elevenZeroFiveToElevenFifty = new HalfPair(LocalTime.of(11, 5),
            LocalTime.of(11, 50));
    private static final Pair TIME_10_15_TO_11_50 = new Pair(tenFifteenToEleven, elevenZeroFiveToElevenFifty);


    private static final HalfPair twelveFifteenToThirteenZero = new HalfPair(LocalTime.of(12, 15),
            LocalTime.of(13, 0));
    private static final HalfPair thirteenZeroFiveToThirteenFifty = new HalfPair(LocalTime.of(13, 5),
            LocalTime.of(13, 50));
    private static final Pair TIME_12_15_TO_13_50 = new Pair(twelveFifteenToThirteenZero, thirteenZeroFiveToThirteenFifty);


    private static final HalfPair fourteenZeroToFourteenFortyFive = new HalfPair(LocalTime.of(14, 0),
            LocalTime.of(14, 45));
    private static final HalfPair forteenFiftyToFifteenThirtyFive = new HalfPair(LocalTime.of(14, 50),
            LocalTime.of(15, 35));
    private static final Pair TIME_14_00_TO_15_35 = new Pair(fourteenZeroToFourteenFortyFive, forteenFiftyToFifteenThirtyFive);


    private static final HalfPair fifteenFortyFiveToSixteenThirty = new HalfPair(LocalTime.of(15, 45),
            LocalTime.of(16, 30));
    private static final HalfPair sixteenThirtyFiveToSeventeenTwenty = new HalfPair(LocalTime.of(16, 35),
            LocalTime.of(17, 20));
    private static final Pair TIME_15_45_TO_17_20 = new Pair(fifteenFortyFiveToSixteenThirty, sixteenThirtyFiveToSeventeenTwenty);


    private static final HalfPair seventeenThirtyToEighteenFifteen = new HalfPair(LocalTime.of(17, 30),
            LocalTime.of(18, 15));
    private static final HalfPair eighteenTwentyToNineteenZeroFive = new HalfPair(LocalTime.of(18, 20),
            LocalTime.of(19, 5));
    private static final Pair TIME_17_30_TO_19_05 = new Pair(seventeenThirtyToEighteenFifteen, eighteenTwentyToNineteenZeroFive);


    private static final HalfPair nineteenFifteenToTwentyZero = new HalfPair(LocalTime.of(19, 15),
            LocalTime.of(20, 0));
    private static final HalfPair twentyZeroFiveToTwentyFifteen = new HalfPair(LocalTime.of(20, 5),
            LocalTime.of(20, 50));
    private static final Pair TIME_19_15_TO_20_50 = new Pair(nineteenFifteenToTwentyZero, twentyZeroFiveToTwentyFifteen);

    private static final Map<Integer, Pair> lessonsTimeMap = new HashMap<>();

    static {
        lessonsTimeMap.put(0, TIME_7_30_TO_8_20);
        lessonsTimeMap.put(1, TIME_8_30_TO_10_05);
        lessonsTimeMap.put(2, TIME_10_15_TO_11_50);
        lessonsTimeMap.put(3, TIME_12_15_TO_13_50);
        lessonsTimeMap.put(4, TIME_14_00_TO_15_35);
        lessonsTimeMap.put(5, TIME_15_45_TO_17_20);
        lessonsTimeMap.put(6, TIME_17_30_TO_19_05);
        lessonsTimeMap.put(7, TIME_19_15_TO_20_50);
    }

    public Map<Integer, Pair> getLessonsTimeMap() {
        return lessonsTimeMap;
    }
    public static TimeOfLessons.Pair getPairTimeByPairId(int id){
        return lessonsTimeMap.get(id);
    }
    public static class HalfPair {
        final private LocalTime start;
        final private LocalTime end;

        HalfPair(LocalTime start, LocalTime end) {
            this.start = start;
            this.end = end;
        }

        public LocalTime getStart() {
            return start;
        }

        public LocalTime getEnd() {
            return end;
        }

        @Override
        public String toString() {
            return "HalfPair{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    public static class Pair {
        final private HalfPair first;
        final private HalfPair second;

        Pair(HalfPair first, HalfPair second) {
            this.first = first;
            this.second = second;
        }

        public HalfPair getFirst() {
            return first;
        }

        public HalfPair getSecond() {
            return second;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "first=" + first +
                    ", second=" + second +
                    '}';
        }
    }
}
