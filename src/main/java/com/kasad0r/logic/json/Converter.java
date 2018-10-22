package com.kasad0r.logic.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kasad0r.entity.DayOfTheWeek;
import com.kasad0r.entity.Group;
import com.kasad0r.logic.exel.Reader;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class Converter {


    @Test
    public void Test() {
        try {
            toJSON(new Reader().readXLSDoc(Reader.getExelDocsFilePaths(".xls").get(0)).get(0));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private final static String baseFile = "user.json";

    public static void toJSON(Group[] groups) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        for (Group g : groups
                ) {
            objectMapper.writeValue(new File("src/main/resources/json_data/" + g.getGroupName() + ".json"), g);

        }
    }

    public static void toJSON(List<Group> groups) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        for (Group g : groups
                ) {
            objectMapper.writeValue(new File("src/main/resources/json_data/" + g.getGroupName() + ".json"), g);

        }
    }

    public static void toJSON(Group group) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("src/main/resources/json_data/" + group.getGroupName() + ".json"), group);
        System.out.println("json created!");
    }

    @Deprecated
    private static Group toJavaObject() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(baseFile), Group.class);
    }

    public static void toJSONByDays(Group group) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        if (!group.getGroupName().equals("Эталон")) {
            for (DayOfTheWeek d : group.getDaysOfWeek()
                    ) {
                File file = new File("src/main/resources/json_data/" + group.getGroupName());
                if (!Files.exists(file.toPath())) {
                    try {
                        Files.createDirectories(file.toPath());
                    } catch (IOException e) {
                        //fail to create directory
                        e.printStackTrace();
                    }
                }
                mapper.writeValue(new File("src/main/resources/json_data/" + group.getGroupName() + "/" + d.getDayName() + ".json"), d);
            }
        }
    }

    public static void toJSONByDays(Group[] groups) throws IOException {
        for (Group g : groups
                ) {
            toJSONByDays(g);

        }
    }

    public static void toJSONByDays(List<Group> groups) throws IOException {
        for (Group g : groups
                ) {
            toJSONByDays(g);

        }
    }
}
