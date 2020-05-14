package com.example.lucasfranco.usuarios;

import android.content.ContentValues;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class Update extends AppCompatActivity {

    TextView lista;
    EditText id;
    EditText name;
    EditText lastname;
    DataHelper dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        dataBase = new DataHelper(this);
        lista = (TextView) this.findViewById(R.id.lista);
        id = (EditText) this.findViewById(R.id.id);
        name = (EditText) this.findViewById(R.id.name);
        lastname = (EditText) this.findViewById(R.id.lastname);

        read();
    }

    public void update(View v)
    {
        ContentValues values = new ContentValues();

        values.put("name", name.getText().toString());
        values.put("lastname", lastname.getText().toString());

        long idLong = Integer.parseInt(id.getText().toString());

        dataBase.Update(values, idLong);
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
