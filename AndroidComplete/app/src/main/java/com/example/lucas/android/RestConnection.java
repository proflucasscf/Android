package com.example.lucas.android;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by lucas.franco on 22/06/2018.
 */

public class RestConnection {
    public static String postDados(String urlUsuario,String parametroUsuario){

        OkHttpClient client = new OkHttpClient();
        Request.Builder builder = new Request.Builder();
        builder.url(urlUsuario);
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded; charset=utf-8");
        RequestBody body = RequestBody.create(mediaType,parametroUsuario);
        builder.post(body);
        Request request = builder.build();
        try{
            Response response = client.newCall(request).execute();
            return response.body().string();
        }catch (IOException erro){
            return null;
        }
    }
}
