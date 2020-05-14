package com.example.lucas.android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void elements(View v)
    {
        Intent intent = new Intent(MainActivity.this, Elements.class);
        startActivity(intent);
    }

    public void layouts(View v)
    {
        Intent intent = new Intent(MainActivity.this, Layouts.class);
        startActivity(intent);
    }

    public void service(View v)
    {
        Intent intent = new Intent(MainActivity.this, Service.class);
        startActivity(intent);
    }

    public void sharedPreference(View v)
    {
        Intent intent = new Intent(MainActivity.this, SharedPreference.class);
        startActivity(intent);
    }

    public void gps(View v)
    {
        Intent intent = new Intent(MainActivity.this, Maps.class);
        startActivity(intent);
    }

    public void rest(View v)
    {
        Intent intent = new Intent(MainActivity.this, Rest.class);
        startActivity(intent);
    }

    public void webService(View v)
    {
        Intent intent = new Intent(MainActivity.this, WebService.class);
        startActivity(intent);
    }

    public void sQLite(View v)
    {
        Intent intent = new Intent(MainActivity.this, SQLite.class);
        startActivity(intent);
    }
}
