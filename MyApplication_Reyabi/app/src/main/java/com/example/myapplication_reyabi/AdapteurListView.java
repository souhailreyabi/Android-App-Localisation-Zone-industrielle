package com.example.myapplication_reyabi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapteurListView extends BaseAdapter {
    private LayoutInflater mInflater;
    private static ArrayList<Societe> societe;

    public AdapteurListView(Context context,ArrayList<Societe> societe) {
        mInflater=LayoutInflater.from(context);
        this.societe=societe;
    }

    @Override
    public int getCount() {
        return societe.size();
    }

    @Override
    public Object getItem(int position) {
        return societe.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    public String getselectId(int position){
        return  societe.get(position).getIdentifiant_Societe();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        AttributeView attributeView;
        if(convertView == null){
            convertView = mInflater.inflate(R.layout.societeadapterview, null);
            attributeView = new AttributeView();
            attributeView.nom = (TextView) convertView.findViewById(R.id.nom_txt);
            attributeView.dom = (TextView) convertView.findViewById(R.id.dom_txt);
            attributeView.adresse= (TextView) convertView.findViewById(R.id.adr_txt);
            attributeView.tel= (TextView) convertView.findViewById(R.id.Tel_txt);
            attributeView.id= (TextView) convertView.findViewById(R.id.id_txt);
            attributeView.Zone= (TextView) convertView.findViewById(R.id.Zone_txt);

            convertView.setTag(attributeView);
        } else {
            attributeView = (AttributeView) convertView.getTag();
        }
        attributeView.nom.setText(societe.get(position).getNom_Societe());
        attributeView.dom.setText(societe.get(position).getDomaine_Activite());
        attributeView.adresse.setText(societe.get(position).getAdresse());
        attributeView.tel.setText(societe.get(position).getTelephone());
        attributeView.id.setText(societe.get(position).getIdentifiant_Societe());
        attributeView.Zone.setText(societe.get(position).getZone());

        return convertView;

        
    }
}

class AttributeView{
    TextView nom,adresse,dom,tel,id,Zone;

}
