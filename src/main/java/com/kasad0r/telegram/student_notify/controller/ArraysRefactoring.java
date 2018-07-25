package com.kasad0r.telegram.student_notify.controller;

import java.util.ArrayList;
import java.util.List;

public class ArraysRefactoring<T> {
    /**
     * divides the list into lists of 6 objects
     *
     * @param inputList list of objects
     * @return arrayLists
     */
    public List<List<T>> toPageArrays(List<T> inputList) {
        List<List<T>> arrayLists = new ArrayList<>();
        int counter = 0;
        List<T> bufferedArray = new ArrayList<>();
        for (int i = 0; i < inputList.size(); i++) {
            if (counter == 4) {
                List<T> buff = new ArrayList<>(bufferedArray);
                arrayLists.add(buff);
                bufferedArray.clear();
                counter = 0;
            }
            if (i < inputList.size() - 1) {
                bufferedArray.add(inputList.get(i));
            } else if (i == inputList.size() - 1) {
                bufferedArray.add(inputList.get(i));
                arrayLists.add(bufferedArray);
            }
            counter++;
        }
        return arrayLists;
    }
}