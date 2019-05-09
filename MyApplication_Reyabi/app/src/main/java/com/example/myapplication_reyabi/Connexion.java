package com.example.myapplication_reyabi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Connexion extends SQLiteOpenHelper {
    //Déclaration
    final static String name="Societe.db";
    final static  int version=1;
    SQLiteDatabase db;
    ContentValues contentValues;
    ArrayList<Societe> Liste;
    Cursor resultat;
    Societe societe;
    //Fonctions

    public Connexion(Context context) {
        super(context, name, null,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlquery = "CREATE TABLE if NOT EXISTS societe_tanger (id Text NOT NULL PRIMARY KEY , Nom_Societe TEXT NOT NULL ,Domaine_Activite TEXT NOT NULL,Telephone TEXT NOT NULL,Zone TEXT NOT NULL,Adresse TEXT NOT NULL,Lat TEXT NOT NULL,Lng TEXT NOT NULL)";
        db.execSQL(sqlquery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop TABLE IF EXISTS societe_tanger");
        onCreate(db);
    }
    public Boolean Add_Societe(String nom,String domaine,String telephone,String adresse,String Latitude,String Longitude ,String id,String Zone, Context context){
        db = this.getWritableDatabase();
        try{
            contentValues=new ContentValues();
            contentValues.put("id",id);
            contentValues.put("Nom_Societe",nom);
            contentValues.put("Domaine_Activite",domaine);
            contentValues.put("Telephone",telephone);
            contentValues.put("Zone",Zone);
            contentValues.put("Adresse",adresse);
            contentValues.put("Lat",Latitude);
            contentValues.put("Lng",Longitude);
            db.insert("societe_tanger",null,contentValues);
        }catch (Exception E){
            Toast.makeText(context,E.getMessage(),Toast.LENGTH_LONG).show();
            Log.wtf("msg",E.getMessage());

        }
        return  false;


    }
    public void Supprimer_Societe(String id){
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete("societe_tanger ","id=?",new String[] {id});
    }
    public ArrayList<Societe> GzenayaList(){
        Liste=new ArrayList<>();
        db=this.getReadableDatabase();
        try{
            resultat = db.rawQuery("select * from societe_tanger where Zone=?", new String [] {String.valueOf("Gzenaya")});
            resultat.moveToFirst();
            while (resultat.isAfterLast()==false){
                societe=new Societe(resultat.getString(resultat.getColumnIndex("Nom_Societe")),resultat.getString(resultat.getColumnIndex("Domaine_Activite")),resultat.getString(resultat.getColumnIndex("Telephone")),resultat.getString(resultat.getColumnIndex("Adresse")),Double.parseDouble(resultat.getString(resultat.getColumnIndex("Lat"))),Double.parseDouble(resultat.getString(resultat.getColumnIndex("Lng"))),resultat.getString(resultat.getColumnIndex("id")),resultat.getString(resultat.getColumnIndex("Zone")));
                Liste.add(societe);
                resultat.moveToNext();
            }

        }catch (Exception e){

        }
        return Liste;
}
    public ArrayList<Societe> FreeZoneList(){
        Liste=new ArrayList<>();
        db=this.getReadableDatabase();
        try{
            resultat = db.rawQuery("select * from societe_tanger where Zone=?", new String [] {String.valueOf("Freezone")});
            resultat.moveToFirst();
            while (resultat.isAfterLast()==false){
                societe=new Societe(resultat.getString(resultat.getColumnIndex("Nom_Societe")),resultat.getString(resultat.getColumnIndex("Domaine_Activite")),resultat.getString(resultat.getColumnIndex("Telephone")),resultat.getString(resultat.getColumnIndex("Adresse")),resultat.getDouble(resultat.getColumnIndex("Lat")),resultat.getDouble(resultat.getColumnIndex("Lng")),resultat.getString(resultat.getColumnIndex("id")),resultat.getString(resultat.getColumnIndex("Zone")));
                Liste.add(societe);
                resultat.moveToNext();
            }

        }catch (Exception e){

        }
        return Liste;
    }
    public ArrayList<Societe> SocieteList(){
        Liste=new ArrayList<>();
        db=this.getReadableDatabase();
        try{
            resultat = db.rawQuery("select * from societe_tanger ", null);
            resultat.moveToFirst();
            while (resultat.isAfterLast()==false){
                societe=new Societe(resultat.getString(resultat.getColumnIndex("Nom_Societe")),resultat.getString(resultat.getColumnIndex("Domaine_Activite")),resultat.getString(resultat.getColumnIndex("Telephone")),resultat.getString(resultat.getColumnIndex("Adresse")),resultat.getDouble(resultat.getColumnIndex("Lat")),resultat.getDouble(resultat.getColumnIndex("Lng")),resultat.getString(resultat.getColumnIndex("id")),resultat.getString(resultat.getColumnIndex("Zone")));
                Liste.add(societe);
                resultat.moveToNext();
            }

        }catch (Exception e){

        }
        return Liste;
    }
    public boolean TesteDouble(String Lat ,String lng){
        double a,b;
        try{
            a=Double.parseDouble(Lat);
            b=Double.parseDouble(lng);
            return true;
        }catch (Exception e){

        }
        return false;
    }
    public boolean testNumeroTelephone(String Telephone){
        double test;
        if(Telephone.length()>13){
            return false;
        }else
        {
        try {
            test=Double.parseDouble(Telephone);
            return true;
        }catch (Exception E){


        }

        }
        return  false;
    }
    public  Boolean ChampsVide(String name,String adresse,String domaine,String tele,String Lat,String Lng,String id){
        if (name.isEmpty() || adresse.isEmpty()|| domaine.isEmpty()|| tele.isEmpty()||Lat.isEmpty()||Lng.isEmpty()||id.isEmpty()) {
            return  true;

        }
        return  false;
    }
    public boolean findId(ArrayList<Societe> s,String id){
        for(Societe e:s){
            if(e.getIdentifiant_Societe()==id){
                return true;
            }
        }
        return false;
    }


}
