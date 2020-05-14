package com.example.lucasfranco.usuarios;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class Insert extends AppCompatActivity {

    TextView lista;
    EditText name;
    EditText lastname;
    DataHelper dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        dataBase = new DataHelper(this);
        lista = (TextView) this.findViewById(R.id.lista);
        name = (EditText) this.findViewById(R.id.name);
        lastname = (EditText) this.findViewById(R.id.lastname);

        read();
    }

    public void insert(View v)
    {
        dataBase.Insert(name.getText().toString(), lastname.getText().toString());
        read();
    }

    public void read()
    {
        List<String> usuarios = dataBase.SelectAll();

        StringBuilder sb = new StringBuilder();
        sb.append("Usuarios Cadastrados:\n");
        for (String usuario : usuarios) {
            sb.append(usuario + "\n");
        }
        lista.setText(sb.toString());
    }
}
