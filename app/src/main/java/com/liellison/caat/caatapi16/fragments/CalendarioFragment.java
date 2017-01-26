package com.liellison.caat.caatapi16.fragments;

import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.liellison.caat.caatapi16.R;

public class CalendarioFragment extends Fragment {
    public CalendarioFragment(){}

    WebView calendar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calendario, container, false);

        calendar = (WebView) view.findViewById(R.id.calendar);
        calendar.getSettings().setJavaScriptEnabled(true);
        calendar.addJavascriptInterface(new WebAppInterface(this),"Android");
        String calendarURL = "https://calendar.google.com/calendar/embed?src=momf1tt6gcmnj3k9je9rt06hcg%40group.calendar.google.com&ctz=America/Fortaleza";
        calendar.loadUrl(calendarURL);

        setupToolbar(view);
        return view;
    }
    private void setupToolbar(View view)
    {
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);

        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);

        final ActionBar bar = activity.getSupportActionBar();
        if (bar != null)
        {
            bar.setTitle(activity.getString(R.string.app_name));
        }
    }
    public class WebAppInterface{
        CalendarioFragment context;
        WebAppInterface(CalendarioFragment c){
            context = c;
        }
    }
}



