package com.example.lucasfranco.restandroid;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // Informações do seridor (API) que será requisitada
    String server = "https://reqres.in/";
    String url = server + "api/users?page=2";

    // Estruturas de lista
    ListView lista;
    ArrayAdapter adapterLista;

    // Lista de usuários
    List<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Recuperar instancia da lista
        lista = (ListView) findViewById(R.id.lista);

        //Verifica a conexão
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        // Verifica o estado da rede se está conectado ou não
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        //Executando url e enviando para Solicita dados
        if (networkInfo != null && networkInfo.isConnected()) {
            new getDados().execute(url);
        }
    }

    private class getDados extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls){
            String params = "";
            return RestConnection.get(urls[0], params);
        }

        @Override
        protected void onPostExecute(String result){

            // Instancia nova lista de Usuarios
            users = new ArrayList<User>();

            try {

                // Recebe resultado de requisição HTTP e armazena em um JSON Array
                JSONObject json = new JSONObject(result);

                // Aramazena o atributo data do JSON
                JSONArray jsonArray = new JSONArray(json.getString("data"));

                // Cria novo obeto JSON para receber cada item do array
                JSONObject itemJson;

                // Percorre pelo JSON Array do resultado
                for(int i = 0; i < jsonArray.length(); i++){

                    // Recebe cada item do array
                    itemJson = new JSONObject(jsonArray.getString(i));

                    // Cria nova instancia de Usuario
                    final User user = new User();

                    // Preenche objeto de Usuário com objetos do JSON
                    user.setFirst_name(itemJson.getString("first_name"));
                    user.setLast_name(itemJson.getString("last_name"));
                    user.setEmail(itemJson.getString("email"));
                    user.setAvatar(itemJson.getString("avatar"));

                    // Adiciona novo item de Usuário para a lista de usuários
                    users.add(user);
                }

                // Alimenta itens da lista de usuários ao ListView presente na View
                adapterLista = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_2, android.R.id.text1, users) {

                    @Override
                    public View getView(int position, View convertView, ViewGroup parent) {
                        View view = super.getView(position, convertView, parent);

                        TextView text1 = (TextView) view.findViewById(android.R.id.text1);
                        TextView text2 = (TextView) view.findViewById(android.R.id.text2);

                        text1.setText(users.get(position).getFirst_name());
                        text2.setText(users.get(position).getEmail());

                        return view;
                    }
                };
                lista.setAdapter(adapterLista);

            }  catch  (JSONException e){
                e.printStackTrace();}
        }
    }
}


