package com.kasad0r.telegram.student_notify;

import com.kasad0r.telegram.student_notify.controller.StudentController;
import com.kasad0r.telegram.student_notify.controller.menus.init_user.InitCourse;
import com.kasad0r.telegram.student_notify.controller.menus.init_user.InitGroupNum;
import com.kasad0r.telegram.student_notify.controller.menus.init_user.InitSpecialty;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;

import java.util.logging.Logger;

import static java.lang.Math.toIntExact;

public class NotifyBot extends TelegramLongPollingBot {
    private static final String className = "com.kasad0r.telegram.student_notify.NotifyBot";
    private static final String username = "kisit_schedule_notification_bot";
    private static final String token = "676694160:AAG1txM8UYIX3-H2XJpDkG-YYjagUoBMwtQ";
    private static Logger logger = Logger.getLogger(className);

    public static void main(String[] args) {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new NotifyBot());
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
        StudentController.startFollowingList();
    }

    static {
        StudentController.Serialize.deserializeAllStudents();
        ApiContextInitializer.init();
        logger.info("Static initialization of components Done!");
    }

    @Override
    public void onUpdateReceived(Update update) {
        try {
            if (update.hasMessage()) {
                if (!StudentController.checkUser(update.getMessage().getChatId())) {
                    StudentController.registerUser(update);
                }
                System.out.println(update.getMessage().getFrom().getId() + " " + update.getMessage().getChatId());
                long chatId = update.getMessage().getChatId();
                if (update.getMessage().hasText()) {
                    String messageText = update.getMessage().getText();
                    if (messageText.equals("/start")) {
                        System.out.println("Start");
                        execute(InitCourse.get(chatId));
                    } else if (messageText.equals("/end")) {
                        System.out.println("End");
                        execute(InitSpecialty.get(chatId, update.getMessage().getFrom().getId()));
                    }
                }

            } else if (update.hasCallbackQuery()) {
                if (update.getCallbackQuery().getMessage().hasText()) {
                    String callbackText = update.getCallbackQuery().getData();
                    long chatId = update.getCallbackQuery().getMessage().getChatId();
                    long userId = update.getCallbackQuery().getFrom().getId();

                    if (callbackText.startsWith("course_")) {

                        StudentController.getStudent(userId)
                                .getGroup().setCourse(Integer.parseInt(callbackText.substring(7)));
                        EditMessageText updateInfoCourse = new EditMessageText()
                                .setChatId(chatId)
                                .setMessageId(toIntExact(update.getCallbackQuery().getMessage().getMessageId()))
                                .setParseMode("HTML")
                                .setText("<b>Вы выбрали " + callbackText.substring(7) + " курс.</b>");
                        execute(updateInfoCourse);
                        execute(InitSpecialty.get(chatId, userId));
                    } else if (callbackText.startsWith("speciality_")) {
                        StudentController.getStudent(userId)
                                .getGroup().setSpecialty(Integer.parseInt(callbackText.substring(11)));
                        EditMessageText updateInfoSpeciality = new EditMessageText()
                                .setChatId(chatId)
                                .setMessageId(toIntExact(update.getCallbackQuery().getMessage().getMessageId()))
                                .setParseMode("HTML")
                                .setText("<b>Вы выбрали " + callbackText.substring(11) + " специальность.</b>");
                        execute(updateInfoSpeciality);
                        execute(InitGroupNum.get(chatId, userId));
                    } else if (callbackText.startsWith("groupnum_")) {
                        StudentController.getStudent(userId)
                                .getGroup().setGroupNum(Integer.parseInt(callbackText.substring(9)));
                        EditMessageText updateInfoGroupNum = new EditMessageText()
                                .setChatId(chatId)
                                .setMessageId(toIntExact(update.getCallbackQuery().getMessage().getMessageId()))
                                .setParseMode("HTML")
                                .setText("<b>Вы выбрали " + callbackText.substring(9) + " группу.</b>");
                        execute(updateInfoGroupNum);
                    }
                }
            }
        } catch (TelegramApiException e) {
            logger.throwing(className, "onUpdateReceived", e);

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
