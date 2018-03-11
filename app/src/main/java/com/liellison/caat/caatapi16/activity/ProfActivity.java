package com.liellison.caat.caatapi16.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.liellison.caat.caatapi16.R;
import com.liellison.caat.caatapi16.adapter.ExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProfActivity extends AppCompatActivity {
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prof);

        expListView = (ExpandableListView) findViewById(R.id.exProf);
        prepareListData();
        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);
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
                Toast.makeText(ProfActivity.this, listDataHeader.get(groupPosition) + " Expanded", Toast.LENGTH_SHORT).show();
            }
        });
        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(ProfActivity.this, listDataHeader.get(groupPosition) + " Collapsed", Toast.LENGTH_SHORT).show();
            }
        });
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(ProfActivity.this, listDataHeader.get(groupPosition) + " : " + listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition), Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    private void prepareListData(){
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        listDataHeader.add("Doutorado");
        listDataHeader.add("Mestrado");


        List<String> doutores = new ArrayList<String>();
        doutores.add("Adriana Takahashi ");
        doutores.add("Alberto Signoretti");
        doutores.add("Anderson Abner de Santana Souza");
        doutores.add("Carlos Andre Guerra Fonseca");
        doutores.add("Felipe Denis Mendonça de Oliveira");
        doutores.add("Francisco Dantas de Medeiros Neto");
        doutores.add("Isaac de Lima Oliveira Filho");
        doutores.add("Karla Darlene Nepomuceno Ramos");
        doutores.add("Rosiery da Silva Maia");
        doutores.add("Wilfredo Blanco Figuerola");

        List<String> mestrandos = new ArrayList<String>();
        mestrandos.add("André Gustavo Pereira da Silva");
        mestrandos.add("Bartira Paraguaçu Falcão Dantas Rocha");
        mestrandos.add("Bruno Cruz de Oliveira");
        mestrandos.add("Camila de Araújo Sena");
        mestrandos.add("Glaucia Melissa Medeiros Campos");
        mestrandos.add("Raul Benites Paradeda");

        listDataChild.put(listDataHeader.get(0), doutores);
        listDataChild.put(listDataHeader.get(1), mestrandos);
    }
}
