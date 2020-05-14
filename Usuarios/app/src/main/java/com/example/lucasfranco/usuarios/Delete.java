package com.example.lucasfranco.usuarios;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
        setContentView(R.layout.activity_delete);

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
        List<String> usuarios = dataBase.SelectAll();

        StringBuilder sb = new StringBuilder();
        sb.append("Usuarios Cadastrados:\n");
        for (String usuario : usuarios) {
            sb.append(usuario + "\n");
        }
        lista.setText(sb.toString());
    }
}
