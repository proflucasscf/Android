package com.example.lucasfranco.usuarios;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.List;

public class Read extends AppCompatActivity {

    TextView lista;
    DataHelper dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);

        dataBase = new DataHelper(this);
        lista = (TextView) this.findViewById(R.id.lista);

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
