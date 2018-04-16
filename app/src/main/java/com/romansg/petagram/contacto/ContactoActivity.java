package com.romansg.petagram.contacto;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.romansg.petagram.R;

public class ContactoActivity extends AppCompatActivity implements ContactoView {
    ContactoPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        presenter = new ContactoPresenterImpl(this, this);
    }

    public void setToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void enviarMensaje(View view) {
        TextInputEditText tiNombre = findViewById(R.id.tiNombre);
        TextInputEditText tiCorreo = findViewById(R.id.tiCorreo);
        TextInputEditText tiTextoCorreo = findViewById(R.id.tiTextoCorreo);

        String nombre = tiNombre.getText().toString();
        String texto = tiTextoCorreo.getText().toString();

        String asunto = getResources().getString(R.string.correo_asunto);
        String correo = tiCorreo.getText().toString();
        String mensaje = "Hola " + nombre + "\n\n" + texto;

        presenter.enviarMensaje(asunto, correo, mensaje);

        finish();
    }
}
