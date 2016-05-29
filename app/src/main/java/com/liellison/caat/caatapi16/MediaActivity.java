package com.liellison.caat.caatapi16;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MediaActivity extends AppCompatActivity {
    TextView textView2, textView9,textView10, textViewMedia;
    EditText editTextPrimeiraNota, editTextSegundaNota, editTextTerceiraNota;
    Button buttonMediaCalc;
    private double nota1, nota2, nota3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);

        editTextPrimeiraNota = (EditText) findViewById(R.id.editTextPrimeiraNota);
        editTextSegundaNota = (EditText) findViewById(R.id.editTextSegundaNota);
        editTextTerceiraNota = (EditText) findViewById(R.id.editTextTerceiraNota);
        buttonMediaCalc = (Button) findViewById(R.id.buttonMediaCalc);
        textViewMedia = (TextView) findViewById(R.id.textViewMedia);

        buttonMediaCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nota1 = Double.parseDouble(editTextPrimeiraNota.getText().toString());
                nota2 = Double.parseDouble(editTextSegundaNota.getText().toString());
                nota3 = Double.parseDouble(editTextTerceiraNota.getText().toString());

                Double media = calcularMedia(nota1, nota2, nota3);
                textViewMedia.setText(media.toString());
            }
        });
    }
    private double calcularMedia(double n1, double n2, double n3){
        double media = (n1 + n2 + n3) / 3;
        return media;
    }
}
