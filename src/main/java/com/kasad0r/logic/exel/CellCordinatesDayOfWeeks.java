package com.kasad0r.logic.exel;

public class CellCordinatesDayOfWeeks {

    private final int rowPos;
    private final int cellPos;


    private CellCordinatesDayOfWeeks(int rowPos, int cellPos) {
        this.rowPos = rowPos;
        this.cellPos = cellPos;
    }

    public int getRowPos() {
        return rowPos;
    }

    public int getCellPos() {
        return cellPos;
    }

    //Координаты дней недели
    public static final CellCordinatesDayOfWeeks MONDAY = new CellCordinatesDayOfWeeks(0, 0);
    public static final CellCordinatesDayOfWeeks TUESDAY = new CellCordinatesDayOfWeeks(0, 3);
    public static final CellCordinatesDayOfWeeks WEDNESDAY = new CellCordinatesDayOfWeeks(0, 6);
    public static final CellCordinatesDayOfWeeks THURSDAY = new CellCordinatesDayOfWeeks(0, 9);
    public static final CellCordinatesDayOfWeeks FRIDAY = new CellCordinatesDayOfWeeks(0, 12);
    public static final CellCordinatesDayOfWeeks SATURDAY = new CellCordinatesDayOfWeeks(0, 15);
    public static final CellCordinatesDayOfWeeks SUNDAY = new CellCordinatesDayOfWeeks(0, 18);

    //Координаты времени пар по дням недели
    public static final CellCordinatesDayOfWeeks MON_TIME_0 = new CellCordinatesDayOfWeeks(2, 0);
    public static final CellCordinatesDayOfWeeks MON_TIME_1 = new CellCordinatesDayOfWeeks(3, 0);
    public static final CellCordinatesDayOfWeeks MON_TIME_2 = new CellCordinatesDayOfWeeks(4, 0);
    public static final CellCordinatesDayOfWeeks MON_TIME_3 = new CellCordinatesDayOfWeeks(5, 0);
    public static final CellCordinatesDayOfWeeks MON_TIME_4 = new CellCordinatesDayOfWeeks(6, 0);
    public static final CellCordinatesDayOfWeeks MON_TIME_5 = new CellCordinatesDayOfWeeks(7, 0);
    public static final CellCordinatesDayOfWeeks MON_TIME_6 = new CellCordinatesDayOfWeeks(8, 0);
    public static final CellCordinatesDayOfWeeks MON_TIME_7 = new CellCordinatesDayOfWeeks(9, 0);

    public static final CellCordinatesDayOfWeeks THU_TIME_0 = new CellCordinatesDayOfWeeks(2, 3);
    public static final CellCordinatesDayOfWeeks THU_TIME_1 = new CellCordinatesDayOfWeeks(3, 3);
    public static final CellCordinatesDayOfWeeks THU_TIME_2 = new CellCordinatesDayOfWeeks(4, 3);
    public static final CellCordinatesDayOfWeeks THU_TIME_3 = new CellCordinatesDayOfWeeks(5, 3);
    public static final CellCordinatesDayOfWeeks THU_TIME_4 = new CellCordinatesDayOfWeeks(6, 3);
    public static final CellCordinatesDayOfWeeks THU_TIME_5 = new CellCordinatesDayOfWeeks(7, 3);
    public static final CellCordinatesDayOfWeeks THU_TIME_6 = new CellCordinatesDayOfWeeks(8, 3);
    public static final CellCordinatesDayOfWeeks THU_TIME_7 = new CellCordinatesDayOfWeeks(9, 3);

    public static final CellCordinatesDayOfWeeks WED_TIME_0 = new CellCordinatesDayOfWeeks(2, 6);
    public static final CellCordinatesDayOfWeeks WED_TIME_1 = new CellCordinatesDayOfWeeks(3, 6);
    public static final CellCordinatesDayOfWeeks WED_TIME_2 = new CellCordinatesDayOfWeeks(4, 6);
    public static final CellCordinatesDayOfWeeks WED_TIME_3 = new CellCordinatesDayOfWeeks(5, 6);
    public static final CellCordinatesDayOfWeeks WED_TIME_4 = new CellCordinatesDayOfWeeks(6, 6);
    public static final CellCordinatesDayOfWeeks WED_TIME_5 = new CellCordinatesDayOfWeeks(7, 6);
    public static final CellCordinatesDayOfWeeks WED_TIME_6 = new CellCordinatesDayOfWeeks(8, 6);
    public static final CellCordinatesDayOfWeeks WED_TIME_7 = new CellCordinatesDayOfWeeks(9, 6);

    public static final CellCordinatesDayOfWeeks THR_TIME_0 = new CellCordinatesDayOfWeeks(2, 9);
    public static final CellCordinatesDayOfWeeks THR_TIME_1 = new CellCordinatesDayOfWeeks(3, 9);
    public static final CellCordinatesDayOfWeeks THR_TIME_2 = new CellCordinatesDayOfWeeks(4, 9);
    public static final CellCordinatesDayOfWeeks THR_TIME_3 = new CellCordinatesDayOfWeeks(5, 9);
    public static final CellCordinatesDayOfWeeks THR_TIME_4 = new CellCordinatesDayOfWeeks(6, 9);
    public static final CellCordinatesDayOfWeeks THR_TIME_5 = new CellCordinatesDayOfWeeks(7, 9);
    public static final CellCordinatesDayOfWeeks THR_TIME_6 = new CellCordinatesDayOfWeeks(8, 9);
    public static final CellCordinatesDayOfWeeks THR_TIME_7 = new CellCordinatesDayOfWeeks(9, 9);

    public static final CellCordinatesDayOfWeeks FRI_TIME_0 = new CellCordinatesDayOfWeeks(2, 12);
    public static final CellCordinatesDayOfWeeks FRI_TIME_1 = new CellCordinatesDayOfWeeks(3, 12);
    public static final CellCordinatesDayOfWeeks FRI_TIME_2 = new CellCordinatesDayOfWeeks(4, 12);
    public static final CellCordinatesDayOfWeeks FRI_TIME_3 = new CellCordinatesDayOfWeeks(5, 12);
    public static final CellCordinatesDayOfWeeks FRI_TIME_4 = new CellCordinatesDayOfWeeks(6, 12);
    public static final CellCordinatesDayOfWeeks FRI_TIME_5 = new CellCordinatesDayOfWeeks(7, 12);
    public static final CellCordinatesDayOfWeeks FRI_TIME_6 = new CellCordinatesDayOfWeeks(8, 12);
    public static final CellCordinatesDayOfWeeks FRI_TIME_7 = new CellCordinatesDayOfWeeks(9, 12);

    public static final CellCordinatesDayOfWeeks SAT_TIME_0 = new CellCordinatesDayOfWeeks(2, 15);
    public static final CellCordinatesDayOfWeeks SAT_TIME_1 = new CellCordinatesDayOfWeeks(3, 15);
    public static final CellCordinatesDayOfWeeks SAT_TIME_2 = new CellCordinatesDayOfWeeks(4, 15);
    public static final CellCordinatesDayOfWeeks SAT_TIME_3 = new CellCordinatesDayOfWeeks(5, 15);
    public static final CellCordinatesDayOfWeeks SAT_TIME_4 = new CellCordinatesDayOfWeeks(6, 15);
    public static final CellCordinatesDayOfWeeks SAT_TIME_5 = new CellCordinatesDayOfWeeks(7, 15);
    public static final CellCordinatesDayOfWeeks SAT_TIME_6 = new CellCordinatesDayOfWeeks(8, 15);
    public static final CellCordinatesDayOfWeeks SAT_TIME_7 = new CellCordinatesDayOfWeeks(9, 15);

    public static final CellCordinatesDayOfWeeks SUN_TIME_0 = new CellCordinatesDayOfWeeks(2, 18);
    public static final CellCordinatesDayOfWeeks SUN_TIME_1 = new CellCordinatesDayOfWeeks(3, 18);
    public static final CellCordinatesDayOfWeeks SUN_TIME_2 = new CellCordinatesDayOfWeeks(4, 18);
    public static final CellCordinatesDayOfWeeks SUN_TIME_3 = new CellCordinatesDayOfWeeks(5, 18);
    public static final CellCordinatesDayOfWeeks SUN_TIME_4 = new CellCordinatesDayOfWeeks(6, 18);
    public static final CellCordinatesDayOfWeeks SUN_TIME_5 = new CellCordinatesDayOfWeeks(7, 18);
    public static final CellCordinatesDayOfWeeks SUN_TIME_6 = new CellCordinatesDayOfWeeks(8, 18);
    public static final CellCordinatesDayOfWeeks SUN_TIME_7 = new CellCordinatesDayOfWeeks(9, 18);

    //Координаты предметов по дням недели
    public static final CellCordinatesDayOfWeeks MON_LESSON_0 = new CellCordinatesDayOfWeeks(2, 1);
    public static final CellCordinatesDayOfWeeks MON_LESSON_1 = new CellCordinatesDayOfWeeks(3, 1);
    public static final CellCordinatesDayOfWeeks MON_LESSON_2 = new CellCordinatesDayOfWeeks(4, 1);
    public static final CellCordinatesDayOfWeeks MON_LESSON_3 = new CellCordinatesDayOfWeeks(5, 1);
    public static final CellCordinatesDayOfWeeks MON_LESSON_4 = new CellCordinatesDayOfWeeks(6, 1);
    public static final CellCordinatesDayOfWeeks MON_LESSON_5 = new CellCordinatesDayOfWeeks(7, 1);
    public static final CellCordinatesDayOfWeeks MON_LESSON_6 = new CellCordinatesDayOfWeeks(8, 1);
    public static final CellCordinatesDayOfWeeks MON_LESSON_7 = new CellCordinatesDayOfWeeks(9, 1);

    public static final CellCordinatesDayOfWeeks THU_LESSON_0 = new CellCordinatesDayOfWeeks(2, 4);
    public static final CellCordinatesDayOfWeeks THU_LESSON_1 = new CellCordinatesDayOfWeeks(3, 4);
    public static final CellCordinatesDayOfWeeks THU_LESSON_2 = new CellCordinatesDayOfWeeks(4, 4);
    public static final CellCordinatesDayOfWeeks THU_LESSON_3 = new CellCordinatesDayOfWeeks(5, 4);
    public static final CellCordinatesDayOfWeeks THU_LESSON_4 = new CellCordinatesDayOfWeeks(6, 4);
    public static final CellCordinatesDayOfWeeks THU_LESSON_5 = new CellCordinatesDayOfWeeks(7, 4);
    public static final CellCordinatesDayOfWeeks THU_LESSON_6 = new CellCordinatesDayOfWeeks(8, 4);
    public static final CellCordinatesDayOfWeeks THU_LESSON_7 = new CellCordinatesDayOfWeeks(9, 4);

    public static final CellCordinatesDayOfWeeks WED_LESSON_0 = new CellCordinatesDayOfWeeks(2, 7);
    public static final CellCordinatesDayOfWeeks WED_LESSON_1 = new CellCordinatesDayOfWeeks(3, 7);
    public static final CellCordinatesDayOfWeeks WED_LESSON_2 = new CellCordinatesDayOfWeeks(4, 7);
    public static final CellCordinatesDayOfWeeks WED_LESSON_3 = new CellCordinatesDayOfWeeks(5, 7);
    public static final CellCordinatesDayOfWeeks WED_LESSON_4 = new CellCordinatesDayOfWeeks(6, 7);
    public static final CellCordinatesDayOfWeeks WED_LESSON_5 = new CellCordinatesDayOfWeeks(7, 7);
    public static final CellCordinatesDayOfWeeks WED_LESSON_6 = new CellCordinatesDayOfWeeks(8, 7);
    public static final CellCordinatesDayOfWeeks WED_LESSON_7 = new CellCordinatesDayOfWeeks(9, 7);

    public static final CellCordinatesDayOfWeeks THR_LESSON_0 = new CellCordinatesDayOfWeeks(2, 10);
    public static final CellCordinatesDayOfWeeks THR_LESSON_1 = new CellCordinatesDayOfWeeks(3, 10);
    public static final CellCordinatesDayOfWeeks THR_LESSON_2 = new CellCordinatesDayOfWeeks(4, 10);
    public static final CellCordinatesDayOfWeeks THR_LESSON_3 = new CellCordinatesDayOfWeeks(5, 10);
    public static final CellCordinatesDayOfWeeks THR_LESSON_4 = new CellCordinatesDayOfWeeks(6, 10);
    public static final CellCordinatesDayOfWeeks THR_LESSON_5 = new CellCordinatesDayOfWeeks(7, 10);
    public static final CellCordinatesDayOfWeeks THR_LESSON_6 = new CellCordinatesDayOfWeeks(8, 10);
    public static final CellCordinatesDayOfWeeks THR_LESSON_7 = new CellCordinatesDayOfWeeks(9, 10);

    public static final CellCordinatesDayOfWeeks FRI_LESSON_0 = new CellCordinatesDayOfWeeks(2, 13);
    public static final CellCordinatesDayOfWeeks FRI_LESSON_1 = new CellCordinatesDayOfWeeks(3, 13);
    public static final CellCordinatesDayOfWeeks FRI_LESSON_2 = new CellCordinatesDayOfWeeks(4, 13);
    public static final CellCordinatesDayOfWeeks FRI_LESSON_3 = new CellCordinatesDayOfWeeks(5, 13);
    public static final CellCordinatesDayOfWeeks FRI_LESSON_4 = new CellCordinatesDayOfWeeks(6, 13);
    public static final CellCordinatesDayOfWeeks FRI_LESSON_5 = new CellCordinatesDayOfWeeks(7, 13);
    public static final CellCordinatesDayOfWeeks FRI_LESSON_6 = new CellCordinatesDayOfWeeks(8, 13);
    public static final CellCordinatesDayOfWeeks FRI_LESSON_7 = new CellCordinatesDayOfWeeks(9, 13);

    public static final CellCordinatesDayOfWeeks SAT_LESSON_0 = new CellCordinatesDayOfWeeks(2, 16);
    public static final CellCordinatesDayOfWeeks SAT_LESSON_1 = new CellCordinatesDayOfWeeks(3, 16);
    public static final CellCordinatesDayOfWeeks SAT_LESSON_2 = new CellCordinatesDayOfWeeks(4, 16);
    public static final CellCordinatesDayOfWeeks SAT_LESSON_3 = new CellCordinatesDayOfWeeks(5, 16);
    public static final CellCordinatesDayOfWeeks SAT_LESSON_4 = new CellCordinatesDayOfWeeks(6, 16);
    public static final CellCordinatesDayOfWeeks SAT_LESSON_5 = new CellCordinatesDayOfWeeks(7, 16);
    public static final CellCordinatesDayOfWeeks SAT_LESSON_6 = new CellCordinatesDayOfWeeks(8, 16);
    public static final CellCordinatesDayOfWeeks SAT_LESSON_7 = new CellCordinatesDayOfWeeks(9, 16);

    public static final CellCordinatesDayOfWeeks SUN_LESSON_0 = new CellCordinatesDayOfWeeks(2, 19);
    public static final CellCordinatesDayOfWeeks SUN_LESSON_1 = new CellCordinatesDayOfWeeks(3, 19);
    public static final CellCordinatesDayOfWeeks SUN_LESSON_2 = new CellCordinatesDayOfWeeks(4, 19);
    public static final CellCordinatesDayOfWeeks SUN_LESSON_3 = new CellCordinatesDayOfWeeks(5, 19);
    public static final CellCordinatesDayOfWeeks SUN_LESSON_4 = new CellCordinatesDayOfWeeks(6, 19);
    public static final CellCordinatesDayOfWeeks SUN_LESSON_5 = new CellCordinatesDayOfWeeks(7, 19);
    public static final CellCordinatesDayOfWeeks SUN_LESSON_6 = new CellCordinatesDayOfWeeks(8, 19);
    public static final CellCordinatesDayOfWeeks SUN_LESSON_7 = new CellCordinatesDayOfWeeks(9, 19);

    //Координаты препод. по дням недели
    public static final CellCordinatesDayOfWeeks MON_TEACHER_0 = new CellCordinatesDayOfWeeks(2, 2);
    public static final CellCordinatesDayOfWeeks MON_TEACHER_1 = new CellCordinatesDayOfWeeks(3, 2);
    public static final CellCordinatesDayOfWeeks MON_TEACHER_2 = new CellCordinatesDayOfWeeks(4, 2);
    public static final CellCordinatesDayOfWeeks MON_TEACHER_3 = new CellCordinatesDayOfWeeks(5, 2);
    public static final CellCordinatesDayOfWeeks MON_TEACHER_4 = new CellCordinatesDayOfWeeks(6, 2);
    public static final CellCordinatesDayOfWeeks MON_TEACHER_5 = new CellCordinatesDayOfWeeks(7, 2);
    public static final CellCordinatesDayOfWeeks MON_TEACHER_6 = new CellCordinatesDayOfWeeks(8, 2);
    public static final CellCordinatesDayOfWeeks MON_TEACHER_7 = new CellCordinatesDayOfWeeks(9, 2);

    public static final CellCordinatesDayOfWeeks THU_TEACHER_0 = new CellCordinatesDayOfWeeks(2, 5);
    public static final CellCordinatesDayOfWeeks THU_TEACHER_1 = new CellCordinatesDayOfWeeks(3, 5);
    public static final CellCordinatesDayOfWeeks THU_TEACHER_2 = new CellCordinatesDayOfWeeks(4, 5);
    public static final CellCordinatesDayOfWeeks THU_TEACHER_3 = new CellCordinatesDayOfWeeks(5, 5);
    public static final CellCordinatesDayOfWeeks THU_TEACHER_4 = new CellCordinatesDayOfWeeks(6, 5);
    public static final CellCordinatesDayOfWeeks THU_TEACHER_5 = new CellCordinatesDayOfWeeks(7, 5);
    public static final CellCordinatesDayOfWeeks THU_TEACHER_6 = new CellCordinatesDayOfWeeks(8, 5);
    public static final CellCordinatesDayOfWeeks THU_TEACHER_7 = new CellCordinatesDayOfWeeks(9, 5);

    public static final CellCordinatesDayOfWeeks WED_TEACHER_0 = new CellCordinatesDayOfWeeks(2, 8);
    public static final CellCordinatesDayOfWeeks WED_TEACHER_1 = new CellCordinatesDayOfWeeks(3, 8);
    public static final CellCordinatesDayOfWeeks WED_TEACHER_2 = new CellCordinatesDayOfWeeks(4, 8);
    public static final CellCordinatesDayOfWeeks WED_TEACHER_3 = new CellCordinatesDayOfWeeks(5, 8);
    public static final CellCordinatesDayOfWeeks WED_TEACHER_4 = new CellCordinatesDayOfWeeks(6, 8);
    public static final CellCordinatesDayOfWeeks WED_TEACHER_5 = new CellCordinatesDayOfWeeks(7, 8);
    public static final CellCordinatesDayOfWeeks WED_TEACHER_6 = new CellCordinatesDayOfWeeks(8, 8);
    public static final CellCordinatesDayOfWeeks WED_TEACHER_7 = new CellCordinatesDayOfWeeks(9, 8);

    public static final CellCordinatesDayOfWeeks THR_TEACHER_0 = new CellCordinatesDayOfWeeks(2, 11);
    public static final CellCordinatesDayOfWeeks THR_TEACHER_1 = new CellCordinatesDayOfWeeks(3, 11);
    public static final CellCordinatesDayOfWeeks THR_TEACHER_2 = new CellCordinatesDayOfWeeks(4, 11);
    public static final CellCordinatesDayOfWeeks THR_TEACHER_3 = new CellCordinatesDayOfWeeks(5, 11);
    public static final CellCordinatesDayOfWeeks THR_TEACHER_4 = new CellCordinatesDayOfWeeks(6, 11);
    public static final CellCordinatesDayOfWeeks THR_TEACHER_5 = new CellCordinatesDayOfWeeks(7, 11);
    public static final CellCordinatesDayOfWeeks THR_TEACHER_6 = new CellCordinatesDayOfWeeks(8, 11);
    public static final CellCordinatesDayOfWeeks THR_TEACHER_7 = new CellCordinatesDayOfWeeks(9, 11);

    public static final CellCordinatesDayOfWeeks FRI_TEACHER_0 = new CellCordinatesDayOfWeeks(2, 14);
    public static final CellCordinatesDayOfWeeks FRI_TEACHER_1 = new CellCordinatesDayOfWeeks(3, 14);
    public static final CellCordinatesDayOfWeeks FRI_TEACHER_2 = new CellCordinatesDayOfWeeks(4, 14);
    public static final CellCordinatesDayOfWeeks FRI_TEACHER_3 = new CellCordinatesDayOfWeeks(5, 14);
    public static final CellCordinatesDayOfWeeks FRI_TEACHER_4 = new CellCordinatesDayOfWeeks(6, 14);
    public static final CellCordinatesDayOfWeeks FRI_TEACHER_5 = new CellCordinatesDayOfWeeks(7, 14);
    public static final CellCordinatesDayOfWeeks FRI_TEACHER_6 = new CellCordinatesDayOfWeeks(8, 14);
    public static final CellCordinatesDayOfWeeks FRI_TEACHER_7 = new CellCordinatesDayOfWeeks(9, 14);

    public static final CellCordinatesDayOfWeeks SAT_TEACHER_0 = new CellCordinatesDayOfWeeks(2, 17);
    public static final CellCordinatesDayOfWeeks SAT_TEACHER_1 = new CellCordinatesDayOfWeeks(3, 17);
    public static final CellCordinatesDayOfWeeks SAT_TEACHER_2 = new CellCordinatesDayOfWeeks(4, 17);
    public static final CellCordinatesDayOfWeeks SAT_TEACHER_3 = new CellCordinatesDayOfWeeks(5, 17);
    public static final CellCordinatesDayOfWeeks SAT_TEACHER_4 = new CellCordinatesDayOfWeeks(6, 17);
    public static final CellCordinatesDayOfWeeks SAT_TEACHER_5 = new CellCordinatesDayOfWeeks(7, 17);
    public static final CellCordinatesDayOfWeeks SAT_TEACHER_6 = new CellCordinatesDayOfWeeks(8, 17);
    public static final CellCordinatesDayOfWeeks SAT_TEACHER_7 = new CellCordinatesDayOfWeeks(9, 17);

    public static final CellCordinatesDayOfWeeks SUN_TEACHER_0 = new CellCordinatesDayOfWeeks(2, 20);
    public static final CellCordinatesDayOfWeeks SUN_TEACHER_1 = new CellCordinatesDayOfWeeks(3, 20);
    public static final CellCordinatesDayOfWeeks SUN_TEACHER_2 = new CellCordinatesDayOfWeeks(4, 20);
    public static final CellCordinatesDayOfWeeks SUN_TEACHER_3 = new CellCordinatesDayOfWeeks(5, 20);
    public static final CellCordinatesDayOfWeeks SUN_TEACHER_4 = new CellCordinatesDayOfWeeks(6, 20);
    public static final CellCordinatesDayOfWeeks SUN_TEACHER_5 = new CellCordinatesDayOfWeeks(7, 20);
    public static final CellCordinatesDayOfWeeks SUN_TEACHER_6 = new CellCordinatesDayOfWeeks(8, 20);
    public static final CellCordinatesDayOfWeeks SUN_TEACHER_7 = new CellCordinatesDayOfWeeks(9, 20);


}

