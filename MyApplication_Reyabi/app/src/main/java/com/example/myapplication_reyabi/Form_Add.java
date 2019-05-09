package com.example.myapplication_reyabi;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;



import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Form_Add extends Fragment {
EditText id,nom,domaine,telephone,adresse,Latitude,Longitude;
ArrayList<String> data;
Spinner spin;
Connexion connexion;
Societe societe;
Boolean test1,test2,test3;
Button btn_add;

    public Form_Add() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_form__add, container, false);
        connexion=new Connexion(getContext());
        id=(EditText)v.findViewById(R.id.id_edit);
        nom=(EditText)v.findViewById(R.id.nom_edit);
        domaine=(EditText)v.findViewById(R.id.dom_edit);
        telephone=(EditText)v.findViewById(R.id.Tel_edit);
        adresse=(EditText)v.findViewById(R.id.adr_edit);
        Latitude=(EditText)v.findViewById(R.id.Lat_edit);
        Longitude=(EditText)v.findViewById(R.id.Lng_edit);

        data=new ArrayList<>();
        data.add("Gzenaya");
        data.add("  ");
        data.add("Freezone");
        btn_add=(Button)v.findViewById(R.id.button2);
        spin=(Spinner)v.findViewById(R.id.Zone_Spinner);
        final ArrayAdapter<String> spinner=new ArrayAdapter<String>(v.getContext(),android.R.layout.simple_spinner_item,data);
        spin.setAdapter(spinner);
        test1=false;
        test2=connexion.TesteDouble(Latitude.getText().toString(),Longitude.getText().toString());
        test3=connexion.testNumeroTelephone(telephone.getText().toString());

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                         if(test2=true){
                        if(test3=true){
                            societe=new Societe(nom.getText().toString(),domaine.getText().toString(),  telephone.getText().toString(),adresse.getText().toString(), Double.parseDouble(Latitude.getText().toString()), Double.parseDouble(Longitude.getText().toString()) , id.getText().toString(),spin.getSelectedItem().toString());
                            connexion.Add_Societe(nom.getText().toString(),domaine.getText().toString(),telephone.getText().toString(),adresse.getText().toString(),Latitude.getText().toString(),Longitude.getText().toString() , id.getText().toString(),spin.getSelectedItem().toString(),getContext());
                            Toast.makeText(getContext(),"Succés",Toast.LENGTH_LONG).show();
                            Log.wtf("Societe",societe.toString());
                            id.setText("");
                            nom.setText("");
                            domaine.setText("");
                            telephone.setText("");
                            adresse.setText("");
                            Latitude.setText("");
                            Longitude.setText("");
                            Log.wtf("Societe",societe.toString());
                        }else{
                            Toast.makeText(getContext(),"Le numero  de Telophoen ne doit passer 13 chiffre et ne doit pas contenir des letrre",Toast.LENGTH_LONG).show();
                            telephone.setText("");
                        }
                    }else{
                            Toast.makeText(getContext(),"Latitude et Longitude doit Etre des Doubles",Toast.LENGTH_LONG).show();
                            Latitude.setText("");
                            Longitude.setText("");


                }}
            

        });

        return  v;
    }

}
