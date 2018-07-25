package com.kasad0r.telegram.administration.controller.menus;

import com.kasad0r.telegram.administration.controller.AdminController;
import com.kasad0r.telegram.administration.entity.Administrator;
import com.kasad0r.telegram.administration.entity.Trigger;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;

public class AddAdmin {
    public static SendMessage get(Update update) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId());
        sendMessage.setText("Отправьте нам контакт пользователя , которого вы хотите пригласить в администрацию ," +
                "после этого он может зайти и использовать бота");
        AdminController.updateTriggerType(update, Trigger.CONTACTSEND);
        return sendMessage;
    }

    public static SendMessage updateAdmin(Update update) {
        if (update.getMessage().hasContact()) {
            return AdminController.addAdministrator(update);
        } else {
            return StaticMesssages.noContactSended(update.getMessage().getChatId());
        }
    }
}
