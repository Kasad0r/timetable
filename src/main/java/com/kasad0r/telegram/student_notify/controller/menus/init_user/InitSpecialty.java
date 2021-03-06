package com.kasad0r.telegram.student_notify.controller.menus.init_user;

import com.kasad0r.telegram.student_notify.controller.ArraysRefactoring;
import com.kasad0r.telegram.student_notify.controller.GroupController;
import com.kasad0r.telegram.student_notify.controller.StudentController;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InitSpecialty {
    public static SendMessage get(long chatId, long userId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setParseMode("HTML");
        sendMessage.setText("<b>Выберите номер специальности :</b>");
        sendMessage.setReplyMarkup(new InlineKeyboardMarkup().setKeyboard(getButtonList(userId)));
        return sendMessage;
    }

    private static List<List<InlineKeyboardButton>> getButtonList(long userId) {
        return new ArraysRefactoring<InlineKeyboardButton>().toPageArrays(
                new ArrayList<>(GroupController
                        .sortBy(StudentController.getStudent(userId).getGroup().getCourse())
                        .stream()
                        .map(elem ->
                                new InlineKeyboardButton(
                                        String.valueOf(elem.getSpecialty()))
                                        .setCallbackData("speciality_" + elem.getSpecialty()))
                        .collect(Collectors.toSet())));
    }
}
