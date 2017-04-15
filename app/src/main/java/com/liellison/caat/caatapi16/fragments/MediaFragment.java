package com.liellison.caat.caatapi16.fragments;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.liellison.caat.caatapi16.activity.Media30;
import com.liellison.caat.caatapi16.activity.Media90;
import com.liellison.caat.caatapi16.R;

public class MediaFragment extends Fragment implements View.OnClickListener{
    public MediaFragment(){}
    Button buttonMediaCalc90, buttonMediaCalc60;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_materias,container,false);

        buttonMediaCalc90 = (Button) view.findViewById(R.id.buttonMediaCalc90);
        buttonMediaCalc90.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getActivity(), Media90.class);
                startActivity(intent);
            }
        });
        buttonMediaCalc60 =(Button)view.findViewById(R.id.buttonMediaCalc60);
        buttonMediaCalc60.setOnClickListener(this);

        setupToolbar(view);
        return view;
    }

    @Override
    public void onClick(View v) {
        Intent intent =new Intent(getActivity(), Media30.class);
        startActivity(intent);
    }

    private void setupToolbar(View view)
    {
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) view.findViewById(R.id.toolbar);

        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);

        final ActionBar bar = activity.getSupportActionBar();
        if (bar != null)
        {
            bar.setTitle(activity.getString(R.string.media));
        }
    }
}
