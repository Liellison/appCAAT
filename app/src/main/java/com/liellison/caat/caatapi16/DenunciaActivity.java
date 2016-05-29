package com.liellison.caat.caatapi16;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.*;
import android.widget.*;
import android.content.Intent;
import android.database.*;

public class DenunciaActivity extends Activity implements View.OnClickListener {

    EditText titulo;
    EditText assunto;
    Button btenviar;

    String tituloDoEvento;
    String assuntoDoEvento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_denuncia);
        iniciarVariaveis();
        btenviar.setOnClickListener(this);
    }

    private void iniciarVariaveis() {
        titulo = (EditText) findViewById(R.id.titulo);
        assunto = (EditText) findViewById(R.id.assunto);
        btenviar = (Button) findViewById(R.id.btenviar);
    }

    public void onClick(View v) {
        tituloDoEvento = titulo.getText().toString();
        assuntoDoEvento = assunto.getText().toString();

        final String email = "caatnataldenuncia@gmail.com";
        String endereçoDeEmail[] = { email };

        String mensagem = "TÍTULO: " + tituloDoEvento + "\nASSUNTO: " + assuntoDoEvento;

        Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
        emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,
                endereçoDeEmail);
        emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,
                "blin blon ! Novo Evento");
        emailIntent.setType("plain/text");
        emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, mensagem);
        startActivity(emailIntent);

    }

    protected void onPause() {
        super.onPause();
        finish();

    }

}
