package com.example.myapplication_reyabi;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Form_Supp extends Fragment {
EditText edit;
Button bt;
Connexion db;



    public Form_Supp() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View V=inflater.inflate(R.layout.fragment_form__supp, container, false);
        db=new Connexion(getContext());
        ArrayList<Societe> data;
        data = db.SocieteList();
        ListView lv = (ListView) V.findViewById(R.id.listeSuppression);
        lv.setAdapter(new AdapteurListView(getActivity(), data));
        edit=V.findViewById(R.id.id_edited);
        bt=V.findViewById(R.id.button);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean a=db.findId(db.SocieteList(),edit.getText().toString());
                if(edit.getText().toString().equals("")){
                    Toast.makeText(getContext(),"Champs Vide",Toast.LENGTH_LONG).show();
                }else {
        if(a==false){
                    try{
                        db.Supprimer_Societe(edit.getText().toString());
                        Toast.makeText(getContext(),"Succes !!",Toast.LENGTH_LONG).show();
                        FragmentTransaction fragment= getActivity().getSupportFragmentManager().beginTransaction();
                        Form_Supp s =new Form_Supp();
                        fragment.replace(R.id.containt_main,s,s.getTag()).commit();
                    }catch (Exception E){
                        Toast.makeText(getContext(),E.getMessage(),Toast.LENGTH_LONG).show();

                    }
                }else{
    Toast.makeText(getContext(),"Cette Identifaint n'existe pas !!",Toast.LENGTH_LONG).show();
    edit.setText("");

}}
            }
        });


        return V;
    }

}
