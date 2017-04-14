package com.liellison.caat.caatapi16.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;


import com.liellison.caat.caatapi16.R;
import com.liellison.caat.caatapi16.adapter.ExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class GradeFragment extends Fragment {
    ExpandableListAdapter listAdapter;
    ExpandableListView expandableListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_grade,container, false);

        expandableListView = (ExpandableListView) view.findViewById(R.id.exGrade);
        prepareListData(view);
        listAdapter = new ExpandableListAdapter(getContext(), listDataHeader, listDataChild);
        expandableListView.setAdapter(listAdapter);
        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {
                return false;
            }
        });
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getContext(), listDataHeader.get(groupPosition) + " Expanded", Toast.LENGTH_SHORT).show();
            }
        });
        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getActivity(), listDataHeader.get(groupPosition) + " Collapsed", Toast.LENGTH_SHORT).show();
            }
        });
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(getActivity(), listDataHeader.get(groupPosition) + " : " + listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition), Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        setupToolbar(view);
        return view;
    }

    private void setupToolbar(View view) {
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) view.findViewById(R.id.toolbar);

        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);

        final ActionBar bar = activity.getSupportActionBar();
        if (bar != null)
        {
            bar.setTitle(activity.getString(R.string.app_name));
        }
    }

    private void prepareListData(View view){
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        listDataHeader.add("1° Periodo");
        listDataHeader.add("2° Periodo");
        listDataHeader.add("3° Periodo");
        listDataHeader.add("4° Periodo");
        listDataHeader.add("5° Periodo");
        listDataHeader.add("6° Periodo");
        listDataHeader.add("7° Periodo");
        listDataHeader.add("8° Periodo");
        listDataHeader.add("Optativas");

        List<String> primeiroPeriodo = new ArrayList<String>();
        primeiroPeriodo.add("0805106-1 - Direito e Ética\n" +
                "\nCH:30   Aplicação: Teórica\n" +
                "\nDescrição: Fundamentos de direito cibernético; Ética e privacidade; Delitos e responsabilidades na internet; Internet e direitos autorais; Direito brasileiro e a área de TI; Ciberespaço e aspectosde territorialidade; Aspectos internacionais de crimes cometidos através do computador; Técnicas forenses; Propostas legislativas brasileiras. Direito comercial para informática. o objeto do saber ético e o direito. Moral como ojeto da ética. Direito e moral. História das idéias sobre a ética e a justiça. Ética profissional\n" +
                "\nPre-Requisito: ND Anti-Requisito: ND ");

        primeiroPeriodo.add("0805102-1 - Filosofia das Ciências Naturais\n" +
                "\nCH:60   Aplicação: Teórica\n" +
                "\nDescrição: A ciência e outras formas de conhecimento. O estatuto da ciência e da filosofia. Critérios de cientificidade. O método científico. Teorias, leis e explicação científica. A questão da objetividade científica.\n" +
                "\nPre-Requisito: ND Anti-Requisito: ");

        primeiroPeriodo.add("0805105-1 - Introdução à Programação de Computadores\n" +
                "\nCH:90   Aplicação: Teórica/Prática\n" +
                "\nDescrição: A informação e sua representação. Arquitetura básica de computador: CPU, tipos de memórias, dispositivos de E/S e barramento. Construção de algoritmos: Tipos de dados, estrutura de controle, estrutura de dados homogêneas, classificação e pesquisa, estrutura de dados heterogêneas, sub-algoritmos e recursividade.\n" +
                "\nPre-Requisito: ND Anti-Requisito: ");

        primeiroPeriodo.add("0805087-1 - Lógica Matemática Aplicada a Computação\n" +
                "\nCH:60   Aplicação: Teórica\n" +
                "\nDescrição: Lógica Proposicional. Lógica de Predicados. Tabela-Verdade. Implicação Lógica. Equivalência. Álgebra das Proposições. Método Dedutivo. Argumentos e Regras de Inferência. Programação Lógica. Lógicas Não-Clássicas.\n" +
                "\nPre-Requisito: ND Anti-Requisito: ");

        primeiroPeriodo.add("0805104-1 - Matemática Fundamental\n" +
                "\nCH:90   Aplicação: Teórica\n" +
                "\nDescrição: Polinômios e fatoração. Relações e funções. Funções elementares. Trigonometria. Funções trigonométricas. Logaritmo e exponencial. Matrizes e determinantes. Sistemas de equações lineares.\n" +
                "\nPre-Requisito: ND Anti-Requisito: ");

        primeiroPeriodo.add("0805103-1 - Produção Textual\n" +
                "\nCH:30   Aplicação: Teórica\n" +
                "\nDescrição: Leitura e produção de textos, com ênfase nos gêneros discursivos presentes bo mundo acadêmico da ciência e tecnologia. Produção de textos, artigos e trabalhos científicos.\n" +
                "\nPre-Requisito: ND Anti-Requisito: ");


        List<String> segundoPeriodo = new ArrayList<String>();
        segundoPeriodo.add("0805111-1 - Cálculo\n" +
                "\nCH:30   Aplicação: Teórica\n" +
                "\nDescrição: \n" +
                "\nPre-Requisito: ND Anti-Requisito: ");

        segundoPeriodo.add("Circuitos Digitais\n" +
                "\nCH:30   Aplicação: Teórica\n" +
                "\nDescrição: \n" +
                "\nPre-Requisito: ND Anti-Requisito: ");

        segundoPeriodo.add("Estrutura de Dados\n" +
                "\nCH:30   Aplicação: Teórica\n" +
                "\nDescrição: \n" +
                "\nPre-Requisito: ND Anti-Requisito: ");

        segundoPeriodo.add("Geometria Analítica\n" +
                "\nCH:30   Aplicação: Teórica\n" +
                "\nDescrição: \n" +
                "\nPre-Requisito: ND Anti-Requisito: ");

        segundoPeriodo.add("Metodologia Para o Trabalho Científico\n" +
                "\nCH:30   Aplicação: Teórica\n" +
                "\nDescrição: \n" +
                "\nPre-Requisito: ND Anti-Requisito: ");

        segundoPeriodo.add("Paradigmas de Programação\n" +
                "\nCH:30   Aplicação: Teórica\n" +
                "\nDescrição: \n" +
                "\nPre-Requisito: ND Anti-Requisito: ");


        List<String> terceiroPeriodo = new ArrayList<String>();
        terceiroPeriodo.add("Álgebra Linear");
        terceiroPeriodo.add("Eletricidade e Magnetismo");
        terceiroPeriodo.add("Engenharia de Software");
        terceiroPeriodo.add("Estruturas Auto-ajustáveis e Grafos");
        terceiroPeriodo.add("Linguagem Formais e Autômatos");
        terceiroPeriodo.add("Sistemas Digitais");

        List<String> quartoPeriodo = new ArrayList<String>();
        quartoPeriodo.add("Análise de Sistemas");
        quartoPeriodo.add("Arquitetura de Computadores");
        quartoPeriodo.add("Banco de Dados");
        quartoPeriodo.add("Cálculo Numérico Computacional");
        quartoPeriodo.add("Compiladores");
        quartoPeriodo.add("Probabilidade e Estatística");
        quartoPeriodo.add("Transmissão de Dados");

        List<String> quintoPeriodo = new ArrayList<String>();
        quintoPeriodo.add("Inteligência Artificial");
        quintoPeriodo.add("Métodos Formais");
        quintoPeriodo.add("Redes de Computadores");
        quintoPeriodo.add("Sistemas Operacionais");

        List<String> sextoPeriodo = new ArrayList<String>();
        sextoPeriodo.add("Computação Gráfica");
        sextoPeriodo.add("Programação Paralela");
        sextoPeriodo.add("Projeto de Graduação");
        sextoPeriodo.add("Sistemas Distribuídos");
        sextoPeriodo.add("Teoria Geral de Administração e Empreendedorismo");

        List<String> setimoPeriodo = new ArrayList<String>();
        setimoPeriodo.add("Projeto de Trabalho de Conclusão de Curso");

        List<String> oitavoPeriodo = new ArrayList<String>();
        oitavoPeriodo.add("Trabalho de Conclusão de Curso");

        List<String> optativas = new ArrayList<String>();
        optativas.add("Depois eu coloco");

        listDataChild.put(listDataHeader.get(0), primeiroPeriodo);
        listDataChild.put(listDataHeader.get(1), segundoPeriodo);
        listDataChild.put(listDataHeader.get(2), terceiroPeriodo);
        listDataChild.put(listDataHeader.get(3), quartoPeriodo);
        listDataChild.put(listDataHeader.get(4), quintoPeriodo);
        listDataChild.put(listDataHeader.get(5), sextoPeriodo);
        listDataChild.put(listDataHeader.get(6), setimoPeriodo);
        listDataChild.put(listDataHeader.get(7), oitavoPeriodo);
        listDataChild.put(listDataHeader.get(8), optativas);

    }

}