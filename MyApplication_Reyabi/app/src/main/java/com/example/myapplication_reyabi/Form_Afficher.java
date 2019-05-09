package com.example.myapplication_reyabi;

import android.app.AlertDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class Form_Afficher extends Fragment {



    public Form_Afficher() {
        // Required empty public constructor
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=  inflater.inflate(R.layout.fragment_form__afficher, container, false);

        Connexion db=new Connexion(getContext());
        db=new Connexion(getContext());
        ArrayList<Societe> data;
        data = db.SocieteList();
        ListView lv = (ListView) v.findViewById(R.id.listeSociete);
        lv.setAdapter(new AdapteurListView(getActivity(), data));

        return v;
    }

}
