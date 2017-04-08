[![API](https://img.shields.io/badge/API-14%2B-blue.svg?style=flat)](https://android-arsenal.com/api?level=14)

# appCAAT
Aplicativo do CAAT 🐼

## Descrição

O aplicativo tem como objetivo ser um canal entre o aluno e a universidade.
### Funções

O aplicativo tem cinco funções principais, 
1. É a possibilidade de ver as ultimas noticias da nossa universidade. 

É feita a comunicação com o RSS do site oficial da UERN ( http://www.uern.br/rss.asp ). Para esta comunicação é utilizado o Retrofit2
junto com o okhttp3, como voces podem ver em /main/java/com/liellison/caat/caatapi16/fragments/NoticiasFragment.java. O exemplo de como é feito estar a baixo:

O okhttp3 é utilizado para criar um cliente na comunicação e define uma regra para aceitar somente o json que consta no RSS.
```java
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
```

2. Temos a nova grade do nosso curso, onde os alunos podem ver tambem as optativas ofertadas pelo departamento. E tambem opções para calcular a media do alunos em disciplinas de 90/60h e de 30h:

A grade é mostrada ao usuario por meio de Spinner, onde temos demonstrado de duas forma, na forma tradicional para API abaixo da 23 e na forma de dialog para a API acima da 23. Como podemos ver no exemplo abaixo:
```xml
<Spinner
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:id="@+id/spinnerPrimeiroP"
            android:entries="@array/primeiroPeriodo"
            android:layout_below="@+id/buttonMediaCalc60"
            android:layout_marginTop="26dp"
            android:spinnerMode="dialog" />
```        
O calculo da media é feito em outra tela, onde tem 2 buttons que fazem a troca de tela, como podemos ver abaixo no exemplo de calcula media de 90/60h:
```java
buttonMediaCalc90.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getActivity(), Media90.class);
                startActivity(intent);
            }
        });
```
        
O calculo realmente dito é feito conforme consta no regimento interno da universidade. Exemplo do calculo de 30h:
```java
String notaSe = nota230.getText().toString();
        if (!notaSe.equals("")) {
            n1 = Double.parseDouble(nota130.getText().toString());
            n2 = Double.parseDouble(nota230.getText().toString());
            resultado = ((n1 * 4) + (n2 * 5)) / 9;
            if (resultado < 7){
                text30.setText("Voce reprovou,tua nota foi "+String.valueOf(resultado));
            }else {
                text30.setText("Tua nota foi "+String.valueOf(resultado));
            }
        }else {
            n1 = Double.parseDouble(nota130.getText().toString());
            resultado = ((n1 * 4)-63) / -5;
            text30.setText("Voce precisa tirar "+String.valueOf(resultado)+" na segunda prova para passar");
        }
```
3. Contem uma opção para os alunos realizarem denuncias ao centro academico sobre qualquer fato da instituição.
4. Um calendario com as futuras informações sobre as atividades da universidade
5. O historico com os antigos membros do CAAT.
