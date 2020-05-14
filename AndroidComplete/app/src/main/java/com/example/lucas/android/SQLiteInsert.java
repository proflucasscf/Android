package com.example.lucas.android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class SQLiteInsert extends AppCompatActivity {

    TextView listaUsers;
    EditText usuario;
    DataHelper dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_insert);

        dataBase = new DataHelper(this);
        listaUsers = (TextView) this.findViewById(R.id.listaUsers);
        usuario = (EditText) this.findViewById(R.id.usuario);

        read();
    }

    public void insert(View v)
    {
        dataBase.Insert(usuario.getText().toString());
        read();
    }

    public void read()
    {
        List<String> users = dataBase.SelectAll();

        StringBuilder sb = new StringBuilder();
        sb.append("Usuários Cadastrados:\n");
        for (String name : users) {
            sb.append(name + "\n");
        }
        listaUsers.setText(sb.toString());
    }
}
