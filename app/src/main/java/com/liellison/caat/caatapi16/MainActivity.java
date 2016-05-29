package com.liellison.caat.caatapi16;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button buttonNot, buttonDen, buttonQuem, buttonCalendario, buttonMedia;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonNot = (Button) findViewById(R.id.buttonNot);
        buttonDen = (Button) findViewById(R.id.buttonDen);
        buttonQuem = (Button) findViewById(R.id.buttonQuem);
        buttonCalendario = (Button) findViewById(R.id.buttonCalendario);
        buttonMedia = (Button) findViewById(R.id.buttonMedia);


        buttonNot.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, NoticiasActivity.class);
                startActivity(it);
            }
        });
        buttonDen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, DenunciaActivity.class);
                startActivity(it);
            }
        });
        buttonQuem.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, QuemSActivity.class);
                startActivity(it);
            }
        });
        buttonCalendario.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, CalenderViewExampleActivity.class);
                startActivity(it);
            }
        });
        buttonMedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, MediaActivity.class);
                startActivity(it);
            }
        });
    }

}

