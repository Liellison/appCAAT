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

import com.liellison.caat.caatapi16.activity.ProfActivity;
import com.liellison.caat.caatapi16.activity.ExMembrosActivity;
import com.liellison.caat.caatapi16.R;


public class QuemSFragment extends Fragment implements View.OnClickListener{
    Button IrB, IrP;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_quem_s, container, false);
        IrB = (Button) view.findViewById(R.id.IrB);
        IrB.setOnClickListener(this);
        IrP = (Button) view.findViewById(R.id.IrP);
        IrP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), ProfActivity.class);
                startActivity(i);
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
            bar.setTitle(activity.getString(R.string.nos));
        }
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getActivity(), ExMembrosActivity.class);
        startActivity(intent);
    }
}
