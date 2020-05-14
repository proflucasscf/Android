package com.example.lucasfranco.contatos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class Delete extends AppCompatActivity {

    TextView lista;
    EditText id;
    DataHelper dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contatos_delete);

        dataBase = new DataHelper(this);
        lista = (TextView) this.findViewById(R.id.lista);
        id = (EditText) this.findViewById(R.id.id);

        read();
    }

    public void delete(View v)
    {
        long idLong = Integer.parseInt(id.getText().toString());
        dataBase.Delete(idLong);
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
