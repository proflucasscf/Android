package com.example.lucasfranco.contatos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class Insert extends AppCompatActivity {

    TextView lista;
    EditText name;
    EditText tel;
    EditText email;
    DataHelper dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contatos_insert);

        dataBase = new DataHelper(this);
        lista = (TextView) this.findViewById(R.id.lista);
        name = (EditText) this.findViewById(R.id.name);
        tel = (EditText) this.findViewById(R.id.tel);
        email = (EditText) this.findViewById(R.id.email);

        read();
    }

    public void insert(View v)
    {
        dataBase.Insert(name.getText().toString(), tel.getText().toString(), email.getText().toString());
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
