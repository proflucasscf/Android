package com.example.lucas.android;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Rest extends AppCompatActivity {

    String server = "https://reqres.in/";
    String url = server + "api/users?page=2";
    String parametros = "";
    ListView lista;
    ArrayAdapter<Local> adapter;
    List<Local> todosUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest);

        lista = (ListView) findViewById(R.id.Listalocal);

        ConnectivityManager connMgr = (ConnectivityManager) //Verifica a conexão
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();// Verifica o estado da rede se está conectado ou não

        if (networkInfo != null && networkInfo.isConnected()) {
            new SolicitaDados().execute(url);//Executando url e enviando para Solicita dados

        }
    }

    private class SolicitaDados extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls){

            return RestConnection.postDados(urls[0],parametros);

        }
        @Override
        protected void onPostExecute(String resultado){
            todosUsers = new ArrayList<Local>();

            try {

                JSONArray jsonArray = new JSONArray(resultado);
                Log.d("Retorno: ", "Criado a partir de string " + jsonArray.length());

                JSONObject json;

                for(int i = 0; i < jsonArray.length(); i++){

                    json = new JSONObject(jsonArray.getString(i));
                    final Local local = new Local();

                    local.setNomeLocal(json.getString("nomelocal"));
                    todosUsers.add(local);
                }

                adapter = new ArrayAdapter<Local>(Rest.this, android.R.layout.simple_list_item_1, todosUsers);
                lista.setAdapter(adapter);

            }  catch  (JSONException e){
                e.printStackTrace();}
        }
    }
}
