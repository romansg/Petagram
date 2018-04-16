package com.romansg.petagram.contacto;

import android.content.Context;

import com.romansg.petagram.contacto.ContactoPresenter;
import com.romansg.petagram.contacto.ContactoView;
import com.romansg.petagram.pojo.SendMailTask;

/**
 * Created by roman on 15/04/18.
 */

public class ContactoPresenterImpl implements ContactoPresenter {
    private Context context;
    private ContactoView view;

    public ContactoPresenterImpl(Context context, ContactoView view) {
        this.context = context;
        this.view = view;

        view.setToolbar();
    }

    @Override
    public void enviarMensaje(String asunto, String correo, String mensaje) {
        SendMailTask task = new SendMailTask(context);
        task.execute(asunto, correo, mensaje);
    }
}
