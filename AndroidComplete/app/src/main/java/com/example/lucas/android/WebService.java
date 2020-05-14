package com.example.lucas.android;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class WebService extends AppCompatActivity {

    static String server = "http://192.168.0.10";
    static String method = "get_locais";
    static String url = server + "/android/ws/lista.php";
    ListView lista;
    ArrayAdapter<Local> adapter;
    List<Local> todososLocais;

    private static final String SOAP_ACTION = url + "/" + method;
    private static final String METHOD_NAME = method;
    private static final String NAMESPACE = "NAMESPACE";
    private static final String URL = url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_service);

        lista = (ListView) findViewById(R.id.Listalocal);

        ConnectivityManager connMgr = (ConnectivityManager) //Verifica a conexão
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();// Verifica o estado da rede se está conectado ou não

        if (networkInfo != null && networkInfo.isConnected()) {
            //request();
        }
    }

    /*public void request()
    {
        new Thread() {
            @Override
            public void run() {
                try {
                    SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

                    SoapSerializationEnvelope envelope = new
                            SoapSerializationEnvelope(SoapEnvelope.VER11);

                    //envelope.dotNet = true;
                    envelope.setOutputSoapObject(request);

                    HttpTransportSE ht = new HttpTransportSE(URL);
                    ht.call(SOAP_ACTION, envelope);

                    // Retorno
                    Object response = envelope.getResponse();
                    final String resultado = response.toString();

                    todososLocais = new ArrayList<Local>();

                    JSONArray jsonArray = new JSONArray(resultado);

                    JSONObject json;

                    for(int i = 0; i < jsonArray.length(); i++){

                        json = new JSONObject(jsonArray.getString(i));
                        final Local local = new Local();

                        local.setNomeLocal(json.getString("nomelocal"));
                        todososLocais.add(local);
                    }

                    runOnUiThread (new Runnable(){
                        public void run() {
                                adapter = new ArrayAdapter<Local>(WebService.this, android.R.layout.simple_list_item_1, todososLocais);
                                lista.setAdapter(adapter);
                        }
                    });
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }*/
}
