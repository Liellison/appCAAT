package com.liellison.caat.caatapi16;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by liellison on 16/01/17.
 */
public class Media30 extends AppCompatActivity implements View.OnClickListener{
    EditText nota130, nota230;
    Button btCalc30;
    TextView text30;
    double n1, n2, resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_30horas);

        nota130 = (EditText) findViewById(R.id.nota130);
        nota230 = (EditText) findViewById(R.id.nota230);
        btCalc30 = (Button) findViewById(R.id.btCalc30);
        btCalc30.setOnClickListener(this);
        text30 = (TextView) findViewById(R.id.text30);
        setupToolbar();
    }

    @Override
    public void onClick(View view) {
        if (nota230.getText().toString().equals(null)) {
            n1 = Double.parseDouble(nota130.getText().toString());
            n2 = Double.parseDouble(nota230.getText().toString());
            resultado = ((n1 * 4) + (n2 * 5)) / 9;
            text30.setText("Sua media ficou " + String.valueOf(resultado));
        }
        if (!nota230.getText().toString().equals(null)){
            n1 = Double.parseDouble(nota130.getText().toString());
            resultado = ((n1 * 4)-63) / -5;
            text30.setText("Voce precisa tirar "+String.valueOf(resultado)+" na segunda prova para passar");
        }
    }

    private void setupToolbar()
    {
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);

        AppCompatActivity activity = Media30.this;
        activity.setSupportActionBar(toolbar);

        final ActionBar bar = activity.getSupportActionBar();
        if (bar != null)
        {
            bar.setTitle(activity.getString(R.string.app_name));
        }
    }

}
