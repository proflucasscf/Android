package com.example.lucas.android;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service implements Runnable{

    private static final String TAG = "Servico";
    private boolean active;
    private int count;
    private static final int MAX = 50;

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {

        Toast.makeText(this, "Serviço Criado!", Toast.LENGTH_LONG).show();
        Log.d(TAG, "Método onCreate");
        active = true;
        new Thread((Runnable) this).start();
    }

    @Override
    public void onStart(Intent intent, int startId) {
        Toast.makeText(this, "Serviço Iniciado!", Toast.LENGTH_LONG).show();
        Log.d(TAG, "Método onStart");
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "Serviço Finalizado!", Toast.LENGTH_LONG).show();
        Log.d(TAG, "Método onDestroy");
        active = false;
    }

    @Override
    public void run() {
        while (active && count < MAX)
        {
            executeThread();
            Log.d(TAG, "Executando..." + count);
            count++;
        }
        Log.d(TAG, "FIM!!!");
        stopSelf();
    }

    private void executeThread() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
