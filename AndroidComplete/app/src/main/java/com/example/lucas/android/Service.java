package com.example.lucas.android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Service extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
    }

    public void startService(View v)
    {
        Intent intent = new Intent(Service.this, MyService.class);
        startService(intent);
    }

    public void stopService(View v)
    {
        Intent intent = new Intent(Service.this, MyService.class);
        stopService(intent);
    }

}
