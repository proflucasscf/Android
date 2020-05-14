package com.example.lucas.android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class SQLiteRead extends AppCompatActivity {

    TextView listaUsers;
    DataHelper dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_read);

        dataBase = new DataHelper(this);
        listaUsers = (TextView) this.findViewById(R.id.listaUsers);

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
