package com.liellison.caat.caatapi16.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.liellison.caat.caatapi16.R;
import com.liellison.caat.caatapi16.api.RssAPI;
import com.liellison.caat.caatapi16.domain.rss;
import com.liellison.caat.caatapi16.network.rssDeserializer;

import java.io.IOException;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NoticiasFragment extends Fragment {
    final String urlbase = "http://www.uern.br/";
    final rss.Channel eu = null;
    TextView textInnnn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_noticias,container, false);

        textInnnn = (TextView) view.findViewById(R.id.textInnnn);
        setupToolbar(view);
        pegarRSS();
        return view;
    }

    private void setupToolbar(View view) {
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
    private void pegarRSS(){
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();
                Request request = original.newBuilder()
                        .header("Accept","application/json")
                        .method(original.method(), original.body())
                        .build();
                return chain.proceed(request);
            }
        });
        final Gson gson = new GsonBuilder()
                .registerTypeAdapter(rss.class, new rssDeserializer())
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(urlbase)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client.build())
                .build();
        final RssAPI rssAPI = retrofit.create(RssAPI.class);
        Call<rss.Channel> call = rssAPI.getRSS();
        call.enqueue(new Callback<rss.Channel>() {
            @Override
            public void onResponse(Call<rss.Channel> call, retrofit2.Response<rss.Channel> response) {

                System.out.println("Deu certo");
            }

            @Override
            public void onFailure(Call<rss.Channel> call, Throwable t) {
                System.out.println("Fudeu: "+t);
            }
        });
    }
}