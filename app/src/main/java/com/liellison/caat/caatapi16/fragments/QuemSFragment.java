package com.liellison.caat.caatapi16.fragments;

import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.liellison.caat.caatapi16.R;
import com.liellison.caat.caatapi16.adapter.ExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class QuemSFragment extends Fragment {
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_quem_s, container, false);
        setupToolbar(view);
        expListView = (ExpandableListView) view.findViewById(R.id.lvExp);
        prepareListData();
        listAdapter = new ExpandableListAdapter(getActivity(), listDataHeader, listDataChild);
        expListView.setAdapter(listAdapter);
        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                return false;
            }
        });
        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getActivity(), listDataHeader.get(groupPosition) + " Expanded", Toast.LENGTH_SHORT).show();
            }
        });
        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getActivity(), listDataHeader.get(groupPosition) + " Collapsed", Toast.LENGTH_SHORT).show();
            }
        });
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(
                        getActivity(), listDataHeader.get(groupPosition) + " : " + listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition), Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        return view;
    }

    private void prepareListData(){
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        listDataHeader.add("CA em 2016 - 2017");
        listDataHeader.add("CA em 2015 - 2016");
        listDataHeader.add("CA em 2014");
        listDataHeader.add("CA em 2012 - 2013");
        listDataHeader.add("CA em 2007 - 2008");

        List<String> ca2017 = new ArrayList<String>();
        ca2017.add("Liellison Menezes - Presidente");
        ca2017.add("Maxsuel Marreiro - Diretor de Comunicação");
        ca2017.add("Abner Santana - Secretario");

        List<String> ca2016 = new ArrayList<String>();
        ca2016.add("Liellison Menezes - Presidente");
        ca2016.add("Girlene Faria - Vice-Presidente");
        ca2016.add("Allyson Thales - Secretario");
        ca2016.add("Claudia Medeiros - Tesoureira");
        ca2016.add("Maxsuel Marreiro - Diretor de Comunicação");

        List<String> ca2014 = new ArrayList<String>();
        ca2014.add("Robson Oliver Lime  - Presidente");
        ca2014.add("Girlene Faria - Vice-Presidente");
        ca2014.add("Allyson Thales - 1° Secretario");
        ca2014.add("Janderson Fonseca - 2° Secretario");
        ca2014.add("Nanda Vick - 1° Tesoureira");
        ca2014.add("Leidinho Filho - 2° Tesoureiro");
        ca2014.add("João Paulo Gomes, Kássio Azevedo - Diretor de Comunicação");
        ca2014.add("Renato Campos - Diretor de Esportes");
        ca2014.add("Marcos André - Diretor de Eventos");
        ca2014.add("Althierfson Lima - Relações Públicas");
        ca2014.add("Serafim Junior, Fernandes Soares - Marketing");

        List<String> ca2013 = new ArrayList<String>();
        ca2013.add("Leila Patrícia - Presidente");
        ca2013.add("Diego Fontes - Vice-Presidente");
        ca2013.add("Matheus da Silva - 1º Secretário");
        ca2013.add("Edjackson Robson - Agente de Eventos");
        ca2013.add("Hugo Leonardo - Analista dos Assuntos");
        ca2013.add("Rafael Sales - 1º Auxiliar");
        ca2013.add("Jeanne Bulcão - Assessora de Assuntos Políticos");
        ca2013.add("Iure César - Conselheiro");
        ca2013.add("Verônica Silmara - Auxiliar da Assessoria de Assuntos Políticos");

        List<String> ca2008 = new ArrayList<String>();
        ca2008.add("Joel Gonçalves de Oliveira - Presidente");
        ca2008.add("Waldney Souza de Andrade - Vice-presidente");
        ca2008.add("José Gustavo Vieira de Morais - Secretário-Geral");
        ca2008.add("Flavio Henrique Soares Cabral - Coordenador de Eventos");
        ca2008.add("Wilton Ferreira dos Santos - Coordenador de Formação Politica");

        listDataChild.put(listDataHeader.get(0), ca2017);
        listDataChild.put(listDataHeader.get(1), ca2016);
        listDataChild.put(listDataHeader.get(2), ca2014);
        listDataChild.put(listDataHeader.get(3), ca2013);
        listDataChild.put(listDataHeader.get(4), ca2008);
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
