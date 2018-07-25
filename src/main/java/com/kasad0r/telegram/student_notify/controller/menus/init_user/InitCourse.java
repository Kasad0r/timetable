package com.kasad0r.telegram.student_notify.controller.menus.init_user;

import com.kasad0r.telegram.student_notify.controller.ArraysRefactoring;
import com.kasad0r.telegram.student_notify.controller.GroupController;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InitCourse {


    public static SendMessage get(long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setParseMode("HTML");
        sendMessage.setText("<b>Выбери ваш курс :</b>");
        sendMessage.setReplyMarkup(new InlineKeyboardMarkup().setKeyboard(getButtonList()));
        sendMessage.setChatId(chatId);
        return sendMessage;
    }


    private static List<List<InlineKeyboardButton>> getButtonList() {
        return new ArraysRefactoring<InlineKeyboardButton>().toPageArrays(
                new ArrayList<>(GroupController.groupList.stream()
                        .map(elem ->
                                new InlineKeyboardButton(String.valueOf(elem.getCourse()))
                                        .setCallbackData("course_" + elem.getCourse()))
                        .collect(Collectors.toSet())));
    }
}
