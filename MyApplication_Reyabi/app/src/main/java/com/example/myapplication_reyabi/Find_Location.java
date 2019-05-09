package com.example.myapplication_reyabi;


import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

import java.io.IOException;
import java.util.List;
import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 */
public class Find_Location extends Fragment implements OnMapReadyCallback {
    SupportMapFragment mapFragment;
    GoogleMap map;
    LatLng center;
    MapView cardView;
    View c;
    private static final int PLACE_AUTOCOMPLETE_REQUEST_CODE = 1;
    EditText adresse;

    public Find_Location() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         c= inflater.inflate(R.layout.fragment_find__location, container, false);


        return c;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        cardView=c.findViewById(R.id.map2);

        adresse =c.findViewById(R.id.editText);
        adresse.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        adresse.setSingleLine(true);
        adresse.setMarqueeRepeatLimit(-1);
        adresse.setSelected(true);
        if (cardView != null) {
            cardView.onCreate(null);
            cardView.onResume();
            cardView.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        map.getUiSettings().setZoomControlsEnabled(true);
        LatLng latLng = new LatLng(20.5937, 78.9629);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 14));


    }

}
