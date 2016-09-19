package com.googlemaps1;

import android.location.Geocoder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;

public class GoogleMaps1 extends AppCompatActivity {

    GoogleMap mGoogleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_maps1);

        double lat = 12.872381;
        double lon = 77.571688;

        MarkerOptions markerOptions;

        mGoogleMap = ((MapFragment)getFragmentManager().findFragmentById(R.id.map_fragment)).getMap();
        mGoogleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lat, lon),20f));

        markerOptions = new MarkerOptions().position( new LatLng(lat,lon)).title(getAddress(lat,lon));
        mGoogleMap.addMarker(markerOptions);
    }

    private String getAddress(double lat, double lon) {

        Geocoder geocoder = new Geocoder(this);

        String address = "";

        try {
            address = geocoder.getFromLocation( lat, lon, 1 ).get( 0 ).getAddressLine( 0 );
        } catch (IOException e) {
            e.printStackTrace();
        }

        return address;

    }
}
