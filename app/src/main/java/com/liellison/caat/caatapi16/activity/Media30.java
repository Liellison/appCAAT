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
public class Media30 extends AppCompatActivity implements View.OnClickListener{
    EditText nota130, nota230;
    Button btCalc30;
    TextView text30;
    double n1, n2, resultado, resultadoP4;
    DecimalFormat formato = new DecimalFormat("#.##");

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
        String notaSe = nota230.getText().toString();
        if (!notaSe.equals("")) {
            n1 = Double.parseDouble(nota130.getText().toString());
            n2 = Double.parseDouble(nota230.getText().toString());
            resultado = ((n1 * 4) + (n2 * 5)) / 9;
            if(resultado < 10){
                resultadoP4 = (resultado - 12) * (-1);
            }else{
                resultadoP4 = resultado - 12;
            }

            if (resultado <= 4){
                text30.setText("Você reprovou,tua média foi "+String.valueOf(formato.format(resultado)));
            }if (resultado >= 4 && resultado < 7) {
                text30.setText("Você esta na 4° prova, precisa tirar "+String.valueOf(formato.format(resultadoP4)));
            }if (resultado >= 7){
                text30.setText("Você foi aprovado com nota "+String.valueOf(formato.format(resultado)));
            }
        }else {
            n1 = Double.parseDouble(nota130.getText().toString());
            resultado = ((n1 * 4)-63) / -5;
            text30.setText("Voce precisa tirar "+String.valueOf(formato.format(resultado))+" na segunda prova para passar");
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
