package com.kasad0r.telegram.student_notify.controller;

import com.kasad0r.logic.exel.Reader;
import com.kasad0r.telegram.student_notify.enitiy.Group;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class GroupController {
    private static final String className = "com.kasad0r.telegram.student_notify.controller.GroupController";
    private static Logger logger = Logger.getLogger(className);
    private static GroupController groupController = new GroupController();
    public static final List<Group> groupList = Reader.getGroupNamesFromShedule()
            .stream().map(Group::new)
            .collect(Collectors.toList());

    private GroupController() {

    }

    public static GroupController getInstance() {
        logger.info("Take a obj GroupController");
        return groupController;
    }

    public static List<Group> sortBy(int course) {
        logger.info(course + " start search in groupList");
        return groupList.stream().filter(e -> e.getCourse() == course).collect(Collectors.toList());
    }

    public static List<Group> sortBy(int course, int specialty) {
        logger.info(course + " and " + specialty + "- course and speciality search in group List");
        return sortBy(course).stream().filter(e -> e.getSpecialty() == specialty).collect(Collectors.toList());
    }


}
