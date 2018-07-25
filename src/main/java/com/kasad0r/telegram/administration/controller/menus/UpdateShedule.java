package com.kasad0r.telegram.administration.controller.menus;

import com.kasad0r.telegram.administration.AdministrationBot;
import com.kasad0r.telegram.administration.controller.AdminController;
import com.kasad0r.telegram.administration.entity.Trigger;
import org.json.JSONException;
import org.json.JSONObject;
import org.telegram.telegrambots.api.methods.send.SendDocument;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Document;
import org.telegram.telegrambots.api.objects.Update;

import java.io.*;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
import java.util.logging.Logger;

public class UpdateShedule {
    private static final String className = "com.kasad0r.telegram.administration.controller.menus.UpdateShedule";
    private static Logger logger = Logger.getLogger(className);

    public static SendDocument get(Update update) {
        SendDocument sendDocument = new SendDocument();
        sendDocument.setNewDocument(new File("src/main/resources/exel_group_timetable_container/shedule.xls"));
        sendDocument.setCaption("Скачайте файл, поменяйте значения и отправьте обратно");
        sendDocument.setChatId(update.getMessage().getChatId());
        AdminController.updateTriggerType(update, Trigger.DOCUMENTSENDER);
        return sendDocument;
    }

    public static void updateDocument(Update update) {
        if (update.getMessage().hasDocument()) {
            if (update.getMessage().getDocument().getFileSize() < 20000) {
                Document document = update.getMessage().getDocument();
                try {
                    JSONObject jsonObject = readJsonFromUrl(AdministrationBot.getFileLink() + document.getFileId());
                    URL website = new URL(AdministrationBot.getDocumentLink() + jsonObject.getJSONObject("result").getString("file_path"));
                    System.out.println(website.toString());
                    System.out.println(jsonObject.toString());
                    AdminController.updateTriggerType(update, Trigger.NONE);

                    ReadableByteChannel rbc = Channels.newChannel(website.openStream());
                    File file = new File("src/main/resources/exel_group_timetable_container/shedule.xls");
                    FileOutputStream fos = new FileOutputStream(file);
                    fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
                } catch (IOException e) {
                   logger.throwing(className,"updateDocument",e);
                }

            }
        }
    }
    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    private static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        try (InputStream is = new URL(url).openStream()) {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            return new JSONObject(jsonText);
        }
    }
}
