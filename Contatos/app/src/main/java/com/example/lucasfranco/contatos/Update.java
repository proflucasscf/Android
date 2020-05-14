package com.example.lucasfranco.contatos;

import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class Update extends AppCompatActivity {

    TextView lista;
    EditText id;
    EditText name;
    EditText tel;
    EditText email;
    DataHelper dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contatos_update);

        dataBase = new DataHelper(this);
        lista = (TextView) this.findViewById(R.id.lista);
        id = (EditText) this.findViewById(R.id.id);
        name = (EditText) this.findViewById(R.id.name);
        tel = (EditText) this.findViewById(R.id.tel);
        email = (EditText) this.findViewById(R.id.email);


        read();
    }

    public void update(View v)
    {
        ContentValues values = new ContentValues();

        values.put("name", name.getText().toString());
        values.put("tel", tel.getText().toString());
        values.put("email", email.getText().toString());

        long idLong = Integer.parseInt(id.getText().toString());

        dataBase.Update(values, idLong);
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
