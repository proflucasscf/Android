package com.example.lucas.android;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Maps extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private LatLng pontoMap;

    // ---------------------------------------------------------------------------------------------
    // Método onCreate que inicia toda a aplicação!!!
    // ---------------------------------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        // Inicia GPS
        startGPS();

        // Inicia a criação do mapa
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
    // ---------------------------------------------------------------------------------------------

    // ---------------------------------------------------------------------------------------------
    // Método que inicia o GPS do dispositivo!!!
    // ---------------------------------------------------------------------------------------------
    public void startGPS(){
        LocationManager lManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        LocationListener lListener = new LocationListener() {
            public void onLocationChanged(Location locat) {
                // A cada nova alteração de coordenada geográfica detectada chama o método
                // changeLocation para alterar o ponto no mapa
                changeLocation(locat);
            }
            public void onStatusChanged(String provider, int status, Bundle extras) {}
            public void onProviderEnabled(String provider) {}
            public void onProviderDisabled(String provider) {}
        };
        if (ActivityCompat.checkSelfPermission(
                this, Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this, Manifest.permission.ACCESS_COARSE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED)
        {
            return;
        }
        lManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, lListener);
    }
    // ---------------------------------------------------------------------------------------------

    // ---------------------------------------------------------------------------------------------
    // Método que altera ponto no mapa!!!
    // ---------------------------------------------------------------------------------------------
    public void changeLocation(Location locat)
    {
        pontoMap = new LatLng(locat.getLatitude(),locat.getLongitude());
        mMap.clear();
        mMap.addMarker(new MarkerOptions().position(pontoMap).title("ESTOU AQUI"));
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(pontoMap, 18));
    }
    // ---------------------------------------------------------------------------------------------

    // ---------------------------------------------------------------------------------------------
    // Método que inicia a criação de um novo mapa!!!
    // ---------------------------------------------------------------------------------------------
    @Override
    public void onMapReady(GoogleMap googleMap)
    {
        mMap = googleMap;
        pontoMap = new LatLng(-19.9705417,-43.9647519); // unibh
        mMap.addMarker(new MarkerOptions().position(pontoMap).title("ESTOU AQUI"));
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(pontoMap, 18));
    }
}
