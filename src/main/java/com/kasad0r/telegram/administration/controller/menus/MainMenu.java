package com.kasad0r.telegram.administration.controller.menus;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainMenu {
    public static SendMessage get(long chatId) {
        SendMessage sendMessage = new SendMessage();
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        KeyboardRow keyboardRow1 = new KeyboardRow();
        KeyboardRow keyboardRow2 = new KeyboardRow();
        KeyboardRow keyboardRow3 = new KeyboardRow();
        KeyboardRow keyboardRow4 = new KeyboardRow();
        keyboardRow1.add("Обновить расписание \uD83D\uDD51");
        keyboardRow2.add("Отправить уведомление \uD83D\uDCDD");
        keyboardRow3.add("Добавить администратора ✅");
        keyboardRow4.add("Инфо ℹ️");
        replyKeyboardMarkup.setKeyboard((Arrays.asList(keyboardRow1,keyboardRow2,keyboardRow3,keyboardRow4)));
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        sendMessage.setChatId(chatId);
        sendMessage.setParseMode("HTML");
        sendMessage.setText("<b>Главное Меню:</b>");
        return sendMessage;
    }
}
