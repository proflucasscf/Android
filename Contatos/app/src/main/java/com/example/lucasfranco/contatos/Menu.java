package com.example.lucasfranco.contatos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class Menu extends AppCompatActivity {

    TextView lista;
    DataHelper dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_contatos);

        dataBase = new DataHelper(this);
        lista = (TextView) this.findViewById(R.id.lista);

        read();
    }

    @Override
    protected void onResume() {
        super.onResume();
        read();
    }

    public void insert(View v)
    {
        Intent intent = new Intent(Menu.this, Insert.class);
        startActivity(intent);
    }

    public void update(View v)
    {
        Intent intent = new Intent(Menu.this, Update.class);
        startActivity(intent);
    }

    public void read(View v)
    {
        Intent intent = new Intent(Menu.this, Read.class);
        startActivity(intent);
    }

    public void delete(View v)
    {
        Intent intent = new Intent(Menu.this, Delete.class);
        startActivity(intent);
    }

    public void read()
    {
        List<String> users = dataBase.SelectAll();

        StringBuilder sb = new StringBuilder();
        sb.append("Contatos Cadastrados:\n");
        for (String name : users) {
            sb.append(name + "\n");
        }
        lista.setText(sb.toString());
    }
}
