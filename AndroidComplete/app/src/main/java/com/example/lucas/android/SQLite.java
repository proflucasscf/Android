package com.example.lucas.android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class SQLite extends AppCompatActivity {

    TextView listaUsers;
    DataHelper dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);

        dataBase = new DataHelper(this);
        listaUsers = (TextView) this.findViewById(R.id.listaUsers);

        read();
    }

    @Override
    protected void onResume() {
        super.onResume();
        read();
    }

    public void insert(View v)
    {
        Intent intent = new Intent(SQLite.this, SQLiteInsert.class);
        startActivity(intent);
    }

    public void update(View v)
    {
        Intent intent = new Intent(SQLite.this, SQLiteUpdate.class);
        startActivity(intent);
    }

    public void read(View v)
    {
        Intent intent = new Intent(SQLite.this, SQLiteRead.class);
        startActivity(intent);
    }

    public void delete(View v)
    {
        Intent intent = new Intent(SQLite.this, SQLiteDelete.class);
        startActivity(intent);
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
