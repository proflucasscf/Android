package com.example.lucas.android;

import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class SQLiteDelete extends AppCompatActivity {

    TextView listaUsers;
    EditText codigo;
    DataHelper dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_delete);

        dataBase = new DataHelper(this);
        listaUsers = (TextView) this.findViewById(R.id.listaUsers);
        codigo = (EditText) this.findViewById(R.id.codigo);

        read();
    }

    public void delete(View v)
    {
        long id = Integer.parseInt(codigo.getText().toString());
        dataBase.Delete(id);
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
