package com.example.lucasfranco.contatos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class Read extends AppCompatActivity {

    TextView lista;
    DataHelper dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contatos_read);

        dataBase = new DataHelper(this);
        lista = (TextView) this.findViewById(R.id.lista);

        read();
    }

    public void read()
    {
        List<String> contatos = dataBase.SelectAll();

        StringBuilder sb = new StringBuilder();
        sb.append("Contatos Cadastrados:\n");
        for (String contato : contatos) {
            sb.append(contato + "\n");
        }
        lista.setText(sb.toString());
    }
}
