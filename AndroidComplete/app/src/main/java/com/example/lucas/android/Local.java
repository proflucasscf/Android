package com.example.lucas.android;

/**
 * Created by lucas.franco on 22/06/2018.
 */

public class Local {
    private String nomeLocal;
    private String latitude;
    private String longitude;

    public String getNomeLocal() {
        return nomeLocal;
    }
    public void setNomeLocal(String nomeLocal) {
        this.nomeLocal = nomeLocal;
    }

    public String getLatitude() {
        return latitude;
    }
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return nomeLocal;
    }
}
