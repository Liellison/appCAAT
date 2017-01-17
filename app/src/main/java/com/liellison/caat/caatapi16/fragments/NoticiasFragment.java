package com.liellison.caat.caatapi16.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.liellison.caat.caatapi16.R;

public class NoticiasFragment extends Fragment {
    TextView textInnnn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_noticias,container, false);

        textInnnn = (TextView) view.findViewById(R.id.textInnnn);

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
           // bar.setTitle(activity.getString(R.string.app_name));
            bar.setWindowTitle(activity.getString(R.string.app_name));
        }
    }
}