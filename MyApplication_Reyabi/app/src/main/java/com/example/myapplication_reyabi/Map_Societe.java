package com.example.myapplication_reyabi;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication_reyabi.Connexion;
import com.example.myapplication_reyabi.R;
import com.example.myapplication_reyabi.Societe;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;


public class Map_Societe extends Fragment implements OnMapReadyCallback {

    private GoogleMap mMap;
    MapView mapView;
    View mview;
    ArrayList<Societe> s1,s2;
    Geocoder geocoder;
    List<Address> listadresse;
    Address ad;
    double lat,lng;

    public Map_Societe() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mview=inflater.inflate(R.layout.fragment_map__societe, container, false);
        return  mview;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mapView = (MapView) mview.findViewById(R.id.map);
        if (mapView != null) {
            mapView.onCreate(null);
            mapView.onResume();
            mapView.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        Connexion connection=new Connexion(getContext());
        s2=connection.FreeZoneList();
        s1=connection.GzenayaList();

        LatLng wd=null;


        LatLng Tanger = new LatLng(35.720953, -5.908806);
        // mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        for(Societe s:s2){

            wd = new LatLng(s.getLatitude(),s.getLongitude());
            mMap.addMarker(new MarkerOptions().position(wd).title(s.getNom_Societe()).snippet("Latitude :"+s.getLongitude()+"Longitude :"+s.getLongitude()).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
        }
        for(Societe s:s1){
            wd = new LatLng(s.getLatitude(),s.getLongitude());
            mMap.addMarker(new MarkerOptions().position(wd).title(s.getNom_Societe()).snippet("Latitude :"+s.getLongitude()+"Longitude :"+s.getLongitude()).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        }

        CameraPosition cdep = CameraPosition.builder().target(Tanger).zoom(10).bearing(0).tilt(45).build();

        mMap.setBuildingsEnabled(true);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cdep));



    }


}
