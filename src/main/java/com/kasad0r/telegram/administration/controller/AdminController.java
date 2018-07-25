package com.kasad0r.telegram.administration.controller;

import com.kasad0r.telegram.administration.controller.menus.StaticMesssages;
import com.kasad0r.telegram.administration.entity.Administrator;
import com.kasad0r.telegram.administration.entity.Trigger;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminController {
    private static final String className = "com.kasad0r.telegram.administration.controller";
    private static List<Administrator> administrators = new ArrayList<>();
    private static final Logger logger =
            Logger.getLogger(className);

    public static SendMessage addAdministrator(Update update) {
        logger.entering(className, "addAdministrator",
                update);
        if (checkAdmin(update)) {
            if (update.getMessage().hasContact()) {
                logger.exiting(className, "addAdministrator");
                return createAdministrator(update);
            } else {
                logger.warning("No contact sending from " + update.getMessage().getFrom());
                return StaticMesssages.noContactSended(update.getMessage().getChatId());
            }
        } else {
            logger.warning("No premission to add,Can`t be . CHECK IT!" + update.getMessage().getFrom());
            return StaticMesssages.noPremission(update.getMessage().getChatId());
        }
    }

    public static boolean checkAdmin(Update update) {
        Administrator administrator = new Administrator(update.getMessage().getFrom().getId());
      return administrators.stream().anyMatch(elem->elem.compareTo(administrator)==0);
    }

    public static Trigger getTriggerType(Update update){
        Administrator administrator = new Administrator(update.getMessage().getFrom().getId());
        for (Administrator elem : administrators) {
            if (elem.compareTo(administrator) == 0) {
                return elem.getTrigger();

            }
        }
        logger.throwing(className,"getTriggerType",new NoSuchElementException());
        return Trigger.NONE;
    }

    public static void updateTriggerType(Update update , Trigger trigger){
        Administrator administrator = new Administrator(update.getMessage().getFrom().getId());
        for (Administrator elem : administrators) {
            if (elem.compareTo(administrator) == 0) {
              elem.setTrigger(trigger);
            }
        }
    }


    private static SendMessage createAdministrator(Update update) {
        Administrator administrator = new Administrator(update.getMessage().getContact().getUserID());
        System.out.println(update.getMessage().getContact().getUserID());
        administrators.add(administrator);
        serializeAdmin(administrator);
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId());
        sendMessage.setText("Адмистратор успешно зарегестрирован!");
        return sendMessage;
    }



    private static void serializeAdmin(Administrator administrator) {
        logger.entering("com.kasad0r.telegram.administration.controller.AdminController", "serializeAdmin",
                administrator);
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream("src/main/resources/hashcodes/admins/administration"
                             + administrator.hashCode() + ".ser"))) {
            oos.writeObject(administrator);
            logger.info("Admin write :" + administrator.hashCode() + ".ser Done!");
        } catch (Exception ex) {
            logger.log(Level.WARNING, "serializeAdmin", ex);
        }
        logger.exiting("com.kasad0r.telegram.administration.controller.AdminController", "serializeAdmin");
    }

    private static Administrator deserializeAdmin(File filename) {

        Administrator administrator = null;
        try (ObjectInputStream ois
                     = new ObjectInputStream(new FileInputStream(filename))) {

            administrator = (Administrator) ois.readObject();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return administrator;

    }

    private static List<File> getSerializeObj() {
        File path = new File("/home/kasad0r/Documents/timetable/src/main/resources/hashcodes/admins");
        return Arrays.asList(Objects.requireNonNull(path.listFiles()));
    }

    public static void deserializeAllAdmins() {
        for (File f : getSerializeObj()
                ) {
            Administrator administrator = deserializeAdmin(f);
            if (!administrators.contains(administrator)) {
                administrators.add(administrator);
            } else {
                logger.warning("Try to add same administrator : " + administrator.toString());
            }
        }
        logger.info("Deserialize admins complete!");
    }
}

