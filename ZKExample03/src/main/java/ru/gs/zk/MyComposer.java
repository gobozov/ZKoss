package ru.gs.zk;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.WrongValuesException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

/**
 * @author APronchakov <artem.pronchakov@gmail.com>
 */
public class MyComposer extends GenericForwardComposer {
    private Textbox name;
    private Textbox login;
    private Textbox email;
    private Datebox birthDate;

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);

    }

    public void onClick$ok(Event event) throws WrongValueException {
        if (!name.isValid()) {
            throw new WrongValueException(name, WrongValueException.NULL_CODE);
        } else if (!login.isValid()) {
            throw new WrongValueException(login, "Логин обязателен на заполнение");
        } else if (!email.isValid()) {
            throw new WrongValueException(email, "E-mail это e-mail. Не хитри.");
        } else if (!birthDate.isValid()) {
            throw new WrongValueException(birthDate, "Дата рождения обязательна и она должна быть в прошлом");
        } else {

            String info = "name: " + name.getValue() +
                    "\r\nlogin: " + login.getValue() +
                    "\r\nemail: " + email.getValue() +
                    "\r\nbirth: " + birthDate.getValue();
            Messagebox.show(info, "Введенная информация", Messagebox.OK, Messagebox.INFORMATION);

        }
    }

}
