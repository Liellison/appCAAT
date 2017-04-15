package com.liellison.caat.caatapi16.fragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;


import com.liellison.caat.caatapi16.R;
import com.liellison.caat.caatapi16.adapter.ExpandableListAdapter;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class GradeFragment extends Fragment {
    ExpandableListAdapter listAdapter;
    ExpandableListView expandableListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    AlertDialog.Builder builder;

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
                //Toast.makeText(getContext(), listDataHeader.get(groupPosition) + " Expanded", Toast.LENGTH_SHORT).show();
            }
        });
        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                //Toast.makeText(getActivity(), listDataHeader.get(groupPosition) + " Collapsed", Toast.LENGTH_SHORT).show();
            }
        });
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(getActivity(), listDataHeader.get(groupPosition) + " : " + listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition), Toast.LENGTH_LONG).show();
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
            bar.setTitle(activity.getString(R.string.grade));
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
        //listDataHeader.add("Optativas");

        List<String> primeiroPeriodo = new ArrayList<String>();
        primeiroPeriodo.add("0805106-1 - Direito e Ética\n" +
                "\nCH:30h   Aplicação: Teórica\n" +
                "\nDescrição: Fundamentos de direito cibernético; Ética e privacidade; Delitos e responsabilidades na internet; Internet e direitos autorais; Direito brasileiro e a área de TI; Ciberespaço e aspectosde territorialidade; Aspectos internacionais de crimes cometidos através do computador; Técnicas forenses; Propostas legislativas brasileiras. Direito comercial para informática. o objeto do saber ético e o direito. Moral como ojeto da ética. Direito e moral. História das idéias sobre a ética e a justiça. Ética profissional\n" +
                "\nPre-Requisito: ND \nAnti-Requisito: ND ");

        primeiroPeriodo.add("0805102-1 - Filosofia das Ciências Naturais\n" +
                "\nCH:60h   Aplicação: Teórica\n" +
                "\nDescrição: A ciência e outras formas de conhecimento. O estatuto da ciência e da filosofia. Critérios de cientificidade. O método científico. Teorias, leis e explicação científica. A questão da objetividade científica.\n" +
                "\nPre-Requisito: ND \nAnti-Requisito: ND");

        primeiroPeriodo.add("0805105-1 - Introdução à Programação de Computadores\n" +
                "\nCH:90h   Aplicação: Teórica/Prática\n" +
                "\nDescrição: A informação e sua representação. Arquitetura básica de computador: CPU, tipos de memórias, dispositivos de E/S e barramento. Construção de algoritmos: Tipos de dados, estrutura de controle, estrutura de dados homogêneas, classificação e pesquisa, estrutura de dados heterogêneas, sub-algoritmos e recursividade.\n" +
                "\nPre-Requisito: ND \nAnti-Requisito: 0805088-1, 0805110-1, 0805123-1");

        primeiroPeriodo.add("0805087-1 - Lógica Matemática Aplicada a Computação\n" +
                "\nCH:60h   Aplicação: Teórica\n" +
                "\nDescrição: Lógica Proposicional. Lógica de Predicados. Tabela-Verdade. Implicação Lógica. Equivalência. Álgebra das Proposições. Método Dedutivo. Argumentos e Regras de Inferência. Programação Lógica. Lógicas Não-Clássicas.\n" +
                "\nPre-Requisito: ND \nAnti-Requisito: ND");

        primeiroPeriodo.add("0805104-1 - Matemática Fundamental\n" +
                "\nCH:90h   Aplicação: Teórica\n" +
                "\nDescrição: Polinômios e fatoração. Relações e funções. Funções elementares. Trigonometria. Funções trigonométricas. Logaritmo e exponencial. Matrizes e determinantes. Sistemas de equações lineares.\n" +
                "\nPre-Requisito: ND \nAnti-Requisito: ND");

        primeiroPeriodo.add("0805103-1 - Produção Textual\n" +
                "\nCH:30h   Aplicação: Teórica\n" +
                "\nDescrição: Leitura e produção de textos, com ênfase nos gêneros discursivos presentes bo mundo acadêmico da ciência e tecnologia. Produção de textos, artigos e trabalhos científicos.\n" +
                "\nPre-Requisito: ND \nAnti-Requisito: 0805123-1");


        List<String> segundoPeriodo = new ArrayList<String>();
        segundoPeriodo.add("0805111-1 - Cálculo\n" +
                "\nCH:90h   Aplicação: Teórica\n" +
                "\nDescrição: Funções. Limite e continuidade. Derivada. Aplicações da derivada. Integral indefinida. Integral definida. Aplicações da integral.\n" +
                "\nPre-Requisito: ND \nAnti-Requisito: ND");

        segundoPeriodo.add("0805108-1 - Circuitos Digitais\n" +
                "\nCH:60h   Aplicação: Teórica\n" +
                "\nDescrição: Introdução aos circuitos digitais. Sistemas de numeração e códigos. Portas lógicas e álgebra booleana. Circuitos combinacionais: Determinação, minimização e realização de funções booleanas. Circuitos lógicos MSI: Codificadores, decodificadores conversores, demultiplexadores, multiplexadores. Aritmética digital. Circuitos sequenciais: Latches, flip-flops, relógio e temporização, contadores, registradores, máquinas sequenciais síncronas de Mealy e Moore.\n" +
                "\nPre-Requisito: ND \nAnti-Requisito: 0805004-1, 0805123-1");

        segundoPeriodo.add("0805088-1 - Estrutura de Dados\n" +
                "\nCH:60h   Aplicação: Teórica/Prática\n" +
                "\nDescrição: Introdução, ponteiros e alocação dinâmica de memória; Lista de dados: Conceitos e motivações; Formas de representações; Listas simplesmente encadeadas; Listas duplamente encadeadas; Listas circulares. Pilhas e filas de dados conceitos; Formas de representações; Algoritmos de aplicações básicas. Árvores de dados conceitos; Árvores binárias de busca; Tabela de dispersão (Hashing).\n" +
                "\nPre-Requisito: 0805105-1 \nAnti-Requisito: 0805089-1, 0805123-1");

        segundoPeriodo.add("0805107-1 - Geometria Analítica\n" +
                "\nCH:60h   Aplicação: Teórica\n" +
                "\nDescrição: Coordenadas cartesianas no plano. A equação da reta. A equação da circunferência. Vetores. Produto interno, produto vetorial, produto misto. Equações de retas e planos. Interseção de planos. Distância de ponto à reta e de ponto à plano.\n" +
                "\nPre-Requisito: ND \nAnti-Requisito: 0805112-1");

        segundoPeriodo.add("0805109-1 - Metodologia Para o Trabalho Científico\n" +
                "\nCH:60h   Aplicação: Teórica\n" +
                "\nDescrição: Ciência e conhecimento científico. Métodos científicos. Ditetrizes metodológicas para a leitura, compreeensão e documentação de textos e elaboração de seminários, artigos científicos, resenha e monografia. Processos e técnicas de elaboração do trabalho científico. Pesquisa - Tipos; Documentação - Didática pessoal, fichamento; Projeto e relatório de pesquisa - etapas; Monografia - Elaboração.\n" +
                "\nPre-Requisito: ND \nAnti-Requisito: 0805123-1");

        segundoPeriodo.add("0805110-1 - Paradigmas de Programação\n" +
                "\nCH:60h   Aplicação: Teórica\n" +
                "\nDescrição: Paradigmas orientado a objetos: Classes, encapsulamento, Herança, polimorfismo, interfaces. Paradigma orientado a aspectos. Novos paradigmas de programação\n" +
                "\nPre-Requisito: 0805105-1 \nAnti-Requisito: 0805123-1");


        List<String> terceiroPeriodo = new ArrayList<String>();
        terceiroPeriodo.add("0805112-1 - Álgebra Linear\n" +
                "\nCH:60h   Aplicação: Teórica\n" +
                "\nDescrição: Matrizes, determinantes, sistemas de equações lineares espaços vetorias base, dimensão, transformações lineares e matriz de uma transformação Linear.\n" +
                "\nPre-Requisito: 0805107-1 \nAnti-Requisito: 0805091-1");

        terceiroPeriodo.add("0805116-1 - Eletricidade e Magnetismo\n" +
                "\nCH:90h   Aplicação: Teórica\n" +
                "\nDescrição: Fenômenos elétricos e magnéticos. Circuitos elétricos. Conceitos de campos elétricos e magnéticos.\n" +
                "\nPre-Requisito: ND \nAnti-Requisito: ND");

        terceiroPeriodo.add("0805089-1 - Engenharia de Software\n" +
                "\nCH:60h   Aplicação: Teórica\n" +
                "\nDescrição: Introdução a engenharia de software. Processos de software. Processos unificados. Métodos ágeis. Gerencia de processo de desenvolvimento de software. Engenharia de requisitos. Análise e projeto de sistemas. Arquitetura de software. Testes de software.\n" +
                "\nPre-Requisito: ND \nAnti-Requisito: 0805117-1, 0805123-1");

        terceiroPeriodo.add("0805115-1 - Estruturas Auto-ajustáveis e Grafos\n" +
                "\nCH:60h   Aplicação: Teórica/Prática\n" +
                "\nDescrição: Árvores binárias, árvores n-árias, árvores de busca, árvores AVL (Balanceadas), árvores B, B+, árvores vermelho-preto. Heap. Grafos: Definição, representação (Lista de adjacência, Matrizes, etc). Algoritmos de busca em grafos. Aplicações utilizando grafos (Caminhos mínimos e árvore geradora mínima). Algoritmos de fluxo máximo. Árvores de expansão mínima. Caminhos de Euler. Conectividade. Classes de problemas e teoria da NP-completude.\n" +
                "\nPre-Requisito: 0805088-1 \nAnti-Requisito: 0805123-1");

        terceiroPeriodo.add("0805114-1 - Linguagem Formais e Autômatos\n" +
                "\nCH:60h   Aplicação: Teórica\n" +
                "\nDescrição: Autômatos reconhecedores finitos determinísticos e não determinísticos. Expressões regulares. Gramáticas regulares. Gramáticas livres de contexto. Forma Normal de Chomsky. Autômatos a pilha determinísticos e não determinísticos. Máquina de Turing. Composição de Máquinas de Turing. Computabilidade.\n" +
                "\nPre-Requisito: ND \nAnti-Requisito: 0805126-1, 0805123-1");

        terceiroPeriodo.add("0805113-1 - Sistemas Digitais\n" +
                "\nCH:60h   Aplicação: Teórica\n" +
                "\nDescrição: Implementação física: Tecnologias de CIs manufaturados e tecnologias de CIs programáveis. Metodologia de projeto digital. Técnicas de projeto usando lógica programável. Linguagem de descrição de hardware. Projeto e implementação de lógica combinacional. Projeto e implementação de lógica seguencial.\n" +
                "\nPre-Requisito: ND \nAnti-Requisito: 0805123-1");


        List<String> quartoPeriodo = new ArrayList<String>();
        quartoPeriodo.add("0805117-1 - Análise de Sistemas\n" +
                "\nCH:60h   Aplicação: Teórica\n" +
                "\nDescrição: Teoria geral dos sistemas, sistemas computacionais e processo de software (ciclo de vida e modelos de processo). Apresentação das metodologias de desenvolvimento de sistemas, habilidades e papéis da equipe de projeto, fase de planejamento, fase de análise, fase de projeto e fase de implementação.\n" +
                "\nPre-Requisito: 0805089-1 \nAnti-Requisito: 0805123-1");

        quartoPeriodo.add("0805004-1 - Arquitetura de Computadores\n" +
                "\nCH:60h   Aplicação: Teórica\n" +
                "\nDescrição: Modelos de Sistemas Digitais: Unidade de Controle e Unidade de Processamento, Modelo de um Sistema de Computação. Conceitos Básicos de Arquitetura. Modo de Endereçamento, Tipo de Dados, Conjunto de Instruções e Chamada de Subrotina, tratamento de Interrupções, Exceções. Entrada e Saída. Memória Auxiliar. Pipeline, Paralelismo de Baixa Granularidade. Processadores Superescalares e superpipeline. Organização de Memória Aritmética para computadores.\n" +
                "\nPre-Requisito: 0805108-1 \nAnti-Requisito: 0805123-1");

        quartoPeriodo.add("0805118-1 - Banco de Dados\n" +
                "\nCH:60h   Aplicação: Teórica/Prática\n" +
                "\nDescrição: Sistemas de banco de dados. Modelo relacional. Projeto de banco de dados e modelo de entidade-relacionamento. Comandos SQL\n" +
                "\nPre-Requisito: ND \nAnti-Requisito: 0805123-1");

        quartoPeriodo.add("0805010-1 - Cálculo Numérico Computacional\n" +
                "\nCH:60h   Aplicação:  Teórica/Prática\n" +
                "\nDescrição: Noções de Erros. Resoluções de Sistemas Lineares por métodos numéricos. Equações algébricas e transcendentes (zeros de funções reais). Interpolação. Ajuste de Curvas pelo método quadrado mínimo. Integração numérica. Soluções das equações diferenciais ordinárias por métodos numéricos.\n" +
                "\nPre-Requisito: ND \nAnti-Requisito: 0805123-1");

        quartoPeriodo.add("0805126-1 - Compiladores\n" +
                "\nCH:60h   Aplicação: Teórica\n" +
                "\nDescrição: Processo de Compilação: Análise Léxica, Análise Sintática, Análise Semântica.\n" +
                "\nPre-Requisito: 0805114-1 \nAnti-Requisito: 0805123-1");

        quartoPeriodo.add("0801046-1 - Probabilidade e Estatística\n" +
                "\nCH:60h   Aplicação: Teórica\n" +
                "\nDescrição: Teoria de probabilidade.Cálculo de probabilidades,inferência estatística.Organização de dados quantitativos:séries,gráficos e distribuição de frequência,valor médio,desvio padrão,regressão.Distribuição contínua e discreta de uma variável.Distribuição multivariável.Função de uma variável aleatória,tipos de distribuição.Distribuição de amostragens,erros e propagação de erros,distribuição de amostragem associada à distribuição normal.Método dos mínimos quadrados,valor médio,desvio padrão,regressão.\n" +
                "\nPre-Requisito: ND \nAnti-Requisito: ND");

        quartoPeriodo.add("0805063-1 - Transmissão de Dados\n" +
                "\nCH:60h   Aplicação: Teórica\n" +
                "\nDescrição: Princípios de Transmissão Eletromagnética e Óptica. Modelamento de um sistema de comunicação digital. Modelamento de um sistema de comunicação óptica. Teoria da Informação. Geração e detecção de sinais modulados binários. Transmissão digital em banda-base. Códigos de linha. Elementos da Teoria da Detecção e Estimação. Teoria da Informação. Fibras ópticas. Radiotransmissão.\n" +
                "\nPre-Requisito: ND \nAnti-Requisito: 0805120-1, 0805123-1");


        List<String> quintoPeriodo = new ArrayList<String>();
        quintoPeriodo.add("0805090-1 - Inteligência Artificial\n" +
                "\nCH:60h   Aplicação: Teórica\n" +
                "\nDescrição: Fundamentos da Inteligência artificial. Agentes inteligentes. Métodos de resolução de problemas. Conhecimento e raciocínio. Representação do conhecimento. Sistemas baseados em conhecimentos. Aprendizagem de máquina.\n" +
                "\nPre-Requisito: ND \nAnti-Requisito: 0805123-1");

        quintoPeriodo.add("0805119-1 - Métodos Formais\n" +
                "\nCH:60h   Aplicação: Teórica\n" +
                "\nDescrição: Aspectos formais no desenvolvimento de software e no tratamento formal de concorrência e paralelismo. Categoria de métodos formais para especificação, refinamento e verificação de software. Modelos e ferramentas de apoio no desenvolvimento formal de software. Aplicação de métodos formais na especificação de sistemas complexos.\n" +
                "\nPre-Requisito: ND \nAnti-Requisito: 0805123-1");

        quintoPeriodo.add("0805120-1 - Redes de Computadores\n" +
                "\nCH:60h   Aplicação: Teórica\n" +
                "\nDescrição: Conceitos básicos sobre rede de computadores. Arquitetura TCP/IP e modelo de referência OSI da ISO. Topologias, protocolos e serviços de comunicação. Projeto e protocolos de redes.\n" +
                "\nPre-Requisito: 0805063-1 \nAnti-Requisito: 0805123-1");

        quintoPeriodo.add("0805055-1 - Sistemas Operacionais\n" +
                "\nCH:60h   Aplicação: Teórica\n" +
                "\nDescrição: Histórico e conceitos básicos. Tipos de Sistemas Operacionais. Histórico e conceitos básicos. Tipos de Sistemas Operacionais. Conceitos de Processo. Comunicação e sincronização de processos. Escalonamento, concorrência e deadlock. Gerência de memória, memória virtual. Sistemas de arquivos. Dispositivos de Entrada e saída e estudo de casos.\n" +
                "\nPre-Requisito: ND \nAnti-Requisito: 0805123-1");


        List<String> sextoPeriodo = new ArrayList<String>();
        sextoPeriodo.add("0805091-1 - Computação Gráfica\n" +
                "\nCH:60h   Aplicação: Teórica/Prática\n" +
                "\nDescrição: Matemática para computação gráfica. Introdução e fundamentação da computação gráfica. Entrada gráfica e dispositivos de visualização. Imagem digital, representação de cores, processamento digital de imagens. Primitivas gráficas, curvas. Transformações geométricas. Projeções geométricas. Modelagem e representação de sólidos. Realismo visual.\n" +
                "\nPre-Requisito: 0805112-1 \nAnti-Requisito: 0805124-1");

        sextoPeriodo.add("0805121-1 - Programação Paralela\n" +
                "\nCH:60h   Aplicação: Teórica/Prática\n" +
                "\nDescrição: Conceitos basicos de concorrência. Taxonomia de arquiteturas paralelas: SISD, SIMD, MIMD e SPMD. Arquitetura de hardware para comunicação entre processadores: memória compartilhada, memória distribuída e hierarquia de memórias. Programação com variáveis compartilhadas: processos, sincronização e monitores. Programação distribuída: passagem de mensagens, RPC e paradigmas de interação entre processos. Definição dos passos para a criação de um programa paralelo. Ferramentas para programação paralela: bibliotecas MPI, OpenMP e Pthreads, compiladores paralelizadores. Análise de desempenho e depuração de programas paralelos. Exemplos de programas paralelos para aplicações específicas.\n" +
                "\nPre-Requisito: ND \nAnti-Requisito: 0805124-1");

        sextoPeriodo.add("0805123-1 - Projeto de Graduação\n" +
                "\nCH:60h   Aplicação: Teórica/Prática\n" +
                "\nDescrição: Confecção de um projeto com bases na interdisciplinaridade visando mostrar ao aluno a articulação das disciplinas estudadas no curso em um projeto na área de computação; Estudo e definição do tema a ser estudado e pesquisa das bases teóricas que norteiam do tema; Definição do tema do projeto e motivação; Especificação dos objetivos do projeto; Definição de técnicas, ferramentas e metodologia para desenvolvimento do projeto. Execução do Projeto. Confecção de Relatório Final apresentando os resultados.\n" +
                "\nPre-Requisito: 0805004-1, 0805010-1, 0805055-1, 0805063-1, 0805088-1, 0805089-1, 0805090-1, 0805103-1, 0805105-1, 0805108-1, 0805109-1, 0805110-1, 0805113-1, 0805114-1, 0805115-1, 0805117-1, 0805118-1, 0805119-1, 0805120-1, 0805126-1 \nAnti-Requisito: 0805124-1");

        sextoPeriodo.add("0805052-1 - Sistemas Distribuídos\n" +
                "\nCH:60h   Aplicação: Teórica\n" +
                "\nDescrição: Conceitos fundamentais de Sistemas Distribuídos. Paradigmas de Sistemas Distribuídos. Definições de Processos e Threads. Comunicação em Sistemas Distribuídos. Sincronização em Sistemas Distribuídos. Conceitos de Middleware. Redes P2P: conceitos básicos, arquiteturas, aplicações. Introdução a Grades Computacionais. Tecnologias de Middleware Tradicionais. Middlewares de Nova Geração.\n" +
                "\nPre-Requisito: ND \nAnti-Requisito: 0805124-1");

        sextoPeriodo.add("0805122-1 - Teoria Geral de Administração e Empreendedorismo\n" +
                "\nCH:60h   Aplicação: Teórica\n" +
                "\nDescrição: Evolução da Teoria Administrativa. Funções básicas do administrador. Desenvolvimento da capacidade empreendedora na área de informática, com ênfase no estudo do perfil do empreendedor, nas técnicas de identificação e aproveitamento de oportunidades, na aquisição e gerenciamento dos recursos necessários ao negócio, fazendo uso de metodologias que priorizaram técnicas de criatividade e da aprendizagem pró-ativa.\n" +
                "\nPre-Requisito: ND \nAnti-Requisito: 0805124-1");


        List<String> setimoPeriodo = new ArrayList<String>();
        setimoPeriodo.add("0805124-1 - Projeto de Trabalho de Conclusão de Curso\n" +
                "\nCH:60h   Aplicação: Teórica/Prática\n" +
                "\nDescrição: A Pesquisa: Conceitos e Definições. Como Encaminhar uma Pesquisa: redação do projeto de Pesquisa e as Fases do Desenvolvimento da Pesquisa. Estrutura do Trabalho Acadêmico. Elaboração e defesa de um Projeto de Trabalho de Conclusão de Curso sobre um tema dentro da área do curso.\n" +
                "\nPre-Requisito: 0805052-1, 0805091-1, 0805121-1, 0805122-1, 0805123-1 \nAnti-Requisito: 0805125-1");


        List<String> oitavoPeriodo = new ArrayList<String>();
        oitavoPeriodo.add("0805125-1 - Trabalho de Conclusão de Curso\n" +
                "\nCH:210h   Aplicação:  Teórica/Prática\n" +
                "\nDescrição: Estrutura do Trabalho Acadêmico. Elaboração, conclusão e defesa do Trabalho de Conclusão de Curso, que envolve o levantamento, a análise e a difusão dos resultados obtidos na pesquisa realizada pelo discente, dentro do que é preconizado pela metodologia científica, sobre um tema dentro da área do curso.\n" +
                "\nPre-Requisito: 0805124-1 \nAnti-Requisito: ND");


        /*List<String> optativas = new ArrayList<String>();
        optativas.add("Depois eu coloco")*/;

        listDataChild.put(listDataHeader.get(0), primeiroPeriodo);
        listDataChild.put(listDataHeader.get(1), segundoPeriodo);
        listDataChild.put(listDataHeader.get(2), terceiroPeriodo);
        listDataChild.put(listDataHeader.get(3), quartoPeriodo);
        listDataChild.put(listDataHeader.get(4), quintoPeriodo);
        listDataChild.put(listDataHeader.get(5), sextoPeriodo);
        listDataChild.put(listDataHeader.get(6), setimoPeriodo);
        listDataChild.put(listDataHeader.get(7), oitavoPeriodo);
        //listDataChild.put(listDataHeader.get(8), optativas);

    }

}