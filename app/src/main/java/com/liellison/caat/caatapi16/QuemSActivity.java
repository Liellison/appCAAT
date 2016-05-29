package com.liellison.caat.caatapi16;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class QuemSActivity extends AppCompatActivity {
    ImageButton imageButtonAllyson, imageButtonLiellison, imageButtonGirlene, imageButtonClaudia, imageButtonJP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quem_s);

        imageButtonAllyson = (ImageButton) findViewById(R.id.imageButtonAllyson);
        imageButtonLiellison = (ImageButton) findViewById(R.id.imageButtonLiellison);
        imageButtonGirlene = (ImageButton) findViewById(R.id.imageButtonGirlene);
        imageButtonClaudia = (ImageButton) findViewById(R.id.imageButtonClaudia);
        imageButtonJP = (ImageButton) findViewById(R.id.imageButtonJP);

        imageButtonAllyson.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent it = new Intent(QuemSActivity.this, AllysonActivity.class);
                startActivity(it);
            }
        });
        imageButtonLiellison.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent it = new Intent(QuemSActivity.this, LiellisonActivity.class);
                startActivity(it);
            }
        });
        imageButtonGirlene.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent it = new Intent(QuemSActivity.this, GirleneActivity.class);
                startActivity(it);
            }
        });
        imageButtonClaudia.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(QuemSActivity.this, ClaudiaActivity.class);
                startActivity(it);
            }
        });
        imageButtonJP.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(QuemSActivity.this, JPActivity.class);
                startActivity(it);
            }
        });
    }
}
