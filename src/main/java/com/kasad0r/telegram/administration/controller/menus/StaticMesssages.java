package com.kasad0r.telegram.administration.controller.menus;

import org.telegram.telegrambots.api.methods.send.SendMessage;

public class StaticMesssages {

    public static SendMessage noContactSended(long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setParseMode("HTML");
        sendMessage.setText("<b>Вы не отправили контакт !</b>");
        sendMessage.setChatId(chatId);
        return sendMessage;
    }

    public static SendMessage noPremission(long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setParseMode("HTML");
        sendMessage.setText("<b>Вы не имеете права использовать эту команду !</b>");
        sendMessage.setChatId(chatId);
        return sendMessage;
    }

    public static SendMessage contactNotFound(long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("Вы не отправиди контакт , начните заново!");
        sendMessage.setChatId(chatId);
        return sendMessage;
    }

    public static SendMessage adminConfirmed(long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setParseMode("HTML");
        sendMessage.setText("Заявка одобрена , Вы можете отправить новому администратоту ссылку на бота : @kisit_administration_bot");
        return sendMessage;
    }
}
