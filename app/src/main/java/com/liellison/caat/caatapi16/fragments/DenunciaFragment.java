package com.liellison.caat.caatapi16.fragments;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.*;
import android.view.*;
import android.widget.*;
import android.content.Intent;
import android.widget.Toolbar;

import com.liellison.caat.caatapi16.R;

public class DenunciaFragment extends Fragment implements View.OnClickListener {
    public DenunciaFragment(){}

    EditText titulo;
    EditText assunto;
    Button btenviar;

    String tituloDoEvento;
    String assuntoDoEvento;

    public static View view;

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_denuncia, container, false);
        iniciarVariaveis();
        btenviar.setOnClickListener(this);
        setupToolbar(view);
        return view;
    }

    private void iniciarVariaveis() {
        titulo = (EditText) view.findViewById(R.id.titulo);
        assunto = (EditText) view.findViewById(R.id.assunto);
        btenviar = (Button) view.findViewById(R.id.btenviar);
    }

    private void setupToolbar(View view)
    {
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) view.findViewById(R.id.toolbar);

        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);

        final ActionBar bar = activity.getSupportActionBar();
        if (bar != null)
        {
            bar.setTitle(activity.getString(R.string.falar));
        }
    }

    public void onClick(View v) {
        tituloDoEvento = titulo.getText().toString();
        assuntoDoEvento = assunto.getText().toString();

        final String email = "caatnataldenuncia@gmail.com";
        String endereçoDeEmail[] = { email };

        String mensagem = assuntoDoEvento;

        Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
        emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,
                endereçoDeEmail);
        emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,
                tituloDoEvento );
        emailIntent.setType("plain/text");
        emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, mensagem);
        startActivity(emailIntent);

    }

}
