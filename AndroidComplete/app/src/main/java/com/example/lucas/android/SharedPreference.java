package com.example.lucas.android;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SharedPreference extends AppCompatActivity {

    EditText nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference);

        nome = (EditText)findViewById(R.id.nome);

        getSharedPreference();
    }

    public void setSharedPreference(View v){
        SharedPreferences.Editor editor = getSharedPreferences("sharedPreference", MODE_PRIVATE).edit();
        editor.putString("nome", nome.getText().toString());
        editor.commit();
    }

    private void getSharedPreference(){
        SharedPreferences prefs = getSharedPreferences("sharedPreference", MODE_PRIVATE);
        nome.setText(prefs.getString("nome", ""));
    }


}
