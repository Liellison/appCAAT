package com.liellison.caat.caatapi16.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.liellison.caat.caatapi16.R;

import java.text.DecimalFormat;

/**
 * Created by liellison on 16/01/17.
 */
public class Media90 extends AppCompatActivity implements View.OnClickListener{
    EditText nota1, nota2, nota3;
    Button btCalc90;
    TextView text90;
    double n1, n2, n3, resultado, resultadoP4;
    DecimalFormat formato = new DecimalFormat("#.##");

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_90horas);

        nota1 = (EditText) findViewById(R.id.nota1);
        nota2 = (EditText) findViewById(R.id.nota2);
        nota3 = (EditText) findViewById(R.id.nota3);
        btCalc90 = (Button) findViewById(R.id.btCalc90);
        text90 = (TextView) findViewById(R.id.text90);
        btCalc90.setOnClickListener(this);
        setupToolbar();
    }

    private void setupToolbar()
    {
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);

        AppCompatActivity activity = Media90.this;
        activity.setSupportActionBar(toolbar);

        final ActionBar bar = activity.getSupportActionBar();
        if (bar != null)
        {
            bar.setTitle(activity.getString(R.string.app_name));
        }
    }

    @Override
    public void onClick(View view) {
        String notad3 = nota3.getText().toString();
        System.out.println("NOta 3"+ notad3);

        if (notad3.equals("")) {
            n1 = Double.parseDouble(nota1.getText().toString());
            n2 = Double.parseDouble(nota2.getText().toString());
            resultado = (((n1 * 4) + (n2 * 5))-105)/-6;
            if(resultado <= 10){
                text90.setText("Você precisa tirar " + String.valueOf(formato.format(resultado))+" na 3° prova");
            }else{
                text90.setText("Você esta na 4º");
            }

        } else {
            n1 = Double.parseDouble(nota1.getText().toString());
            n2 = Double.parseDouble(nota2.getText().toString());
            n3 = Double.parseDouble(nota3.getText().toString());
            resultado = ((n1 * 4) + (n2 * 5) + (n3 * 6)) / 15;

            if(resultado < 10){
                resultadoP4 = (resultado - 12) * (-1);
            }else{
                resultadoP4 = resultado - 12;
            }

            if (resultado <= 4){
            text90.setText("Você reprovou,tua média foi "+String.valueOf(formato.format(resultado)));
            }if (resultado >= 4 && resultado < 7) {
                text90.setText("Você esta na 4° prova, precisa tirar "+String.valueOf(formato.format(resultadoP4)));
            }if (resultado >= 7){
                text90.setText("Você foi aprovado com nota "+String.valueOf(formato.format(resultado)));
            }
        }

    }
}
