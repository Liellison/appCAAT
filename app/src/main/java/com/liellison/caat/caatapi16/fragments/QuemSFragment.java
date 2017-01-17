package com.liellison.caat.caatapi16.fragments;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.liellison.caat.caatapi16.AllysonActivity;
import com.liellison.caat.caatapi16.ClaudiaActivity;
import com.liellison.caat.caatapi16.GirleneActivity;
import com.liellison.caat.caatapi16.JPActivity;
import com.liellison.caat.caatapi16.LiellisonActivity;
import com.liellison.caat.caatapi16.R;

public class QuemSFragment extends Fragment {
    ImageButton imageButtonAllyson, imageButtonLiellison, imageButtonGirlene, imageButtonClaudia, imageButtonJP;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_quem_s, container, false);

        imageButtonAllyson = (ImageButton) view.findViewById(R.id.imageButtonAllyson);
        imageButtonLiellison = (ImageButton) view.findViewById(R.id.imageButtonLiellison);
        imageButtonGirlene = (ImageButton) view.findViewById(R.id.imageButtonGirlene);
        imageButtonClaudia = (ImageButton) view.findViewById(R.id.imageButtonClaudia);
        imageButtonJP = (ImageButton) view.findViewById(R.id.imageButtonJP);

        imageButtonAllyson.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent it = new Intent(getActivity(), AllysonActivity.class);
                startActivity(it);
            }
        });
        imageButtonLiellison.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent it = new Intent(getActivity(), LiellisonActivity.class);
                startActivity(it);
            }
        });
        imageButtonGirlene.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent it = new Intent(getActivity(), GirleneActivity.class);
                startActivity(it);
            }
        });
        imageButtonClaudia.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(getActivity(), ClaudiaActivity.class);
                startActivity(it);
            }
        });
        imageButtonJP.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(getActivity(), JPActivity.class);
                startActivity(it);
            }
        });

        setupToolbar(view);
        return view;
    }

    private void setupToolbar(View view)
    {
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) view.findViewById(R.id.toolbar);

        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);

        final ActionBar bar = activity.getSupportActionBar();
        if (bar != null)
        {
            bar.setTitle(activity.getString(R.string.app_name));
        }
    }
}
