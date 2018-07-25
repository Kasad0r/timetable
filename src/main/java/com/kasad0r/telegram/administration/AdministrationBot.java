package com.kasad0r.telegram.administration;

import com.kasad0r.telegram.administration.controller.menus.AddAdmin;
import com.kasad0r.telegram.administration.controller.menus.MainMenu;
import com.kasad0r.telegram.administration.controller.menus.UpdateShedule;
import com.kasad0r.telegram.administration.entity.Trigger;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;

import java.util.logging.Logger;

import static com.kasad0r.telegram.administration.controller.AdminController.*;

@SuppressWarnings("IfCanBeSwitch")
public class AdministrationBot extends TelegramLongPollingBot {
    private static final String username = "kisit_administration_bot";
    private static final String token = "652862402:AAGQFVakTwmj3dtLn-dLlh9qR3xuga8a8WQ228";
    private static final String className = "com.kasad0r.telegram.administration.AdministrationBot";
    private static Logger logger = Logger.getLogger(className);
    private static final String fileLink = "https://api.telegram.org/bot" + token + "/getFile?file_id=";
    private static final String documentLink = "https://api.telegram.org/file/bot" + token + "/";

    public static String getFileLink() {
        return fileLink;
    }

    public static String getDocumentLink() {
        return documentLink;
    }

    static {
        deserializeAllAdmins();
        ApiContextInitializer.init();
        logger.info("Static initialization of components Done!");
    }

    public static void main(String[] args) {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new AdministrationBot());
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (checkAdmin(update)) {
            try {
                long chatId = update.getMessage().getChatId();
                Trigger trigger = getTriggerType(update);
                if (trigger != null && trigger != Trigger.NONE) {
                    if (trigger == Trigger.DOCUMENTSENDER) {
                        UpdateShedule.updateDocument(update);
                    } else if (trigger == Trigger.SENDNOTICE) {

                    } else if (trigger == Trigger.CONTACTSEND) {
                        execute(AddAdmin.updateAdmin(update));
                    }

                }
                if (update.getMessage().hasText()) {

                    String messageText = update.getMessage().getText();
                    logger.info(update.getMessage().getFrom() + " Has query : " + messageText);
                    if (messageText.equals("/start")) {
                        execute(MainMenu.get(chatId));
                    } else if (messageText.equals("Обновить расписание \uD83D\uDD51")) {
                        sendDocument(UpdateShedule.get(update));
                    } else if (messageText.equals("Добавить администратора ✅")) {
                        execute(AddAdmin.get(update));
                    } else if(messageText.equals("Инфо ℹ")){

                    }

                }
            } catch (TelegramApiException e) {
                logger.throwing(className, "onUpdateReceived", e);
            }
        }
    }

    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public String getBotToken() {
        return token;
    }

}
