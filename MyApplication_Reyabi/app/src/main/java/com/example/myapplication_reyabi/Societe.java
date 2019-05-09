package com.example.myapplication_reyabi;

public class Societe {
    private  String Nom_Societe;
    private String Domaine_Activite;
    private String Telephone;
    private String Adresse;
    private Double Latitude,Longitude;
    private  String identifiant_Societe;
    private String Zone;

    public Societe(String nom_Societe, String domaine_Activite, String telephone, String adresse, Double latitude, Double longitude, String identifiant_Societe, String zone) {
        Nom_Societe = nom_Societe;
        Domaine_Activite = domaine_Activite;
        Telephone = telephone;
        Adresse = adresse;
        Latitude = latitude;
        Longitude = longitude;
        this.identifiant_Societe = identifiant_Societe;
        Zone = zone;
    }

    public String getZone() {
        return Zone;
    }

    public void setZone(String zone) {
        Zone = zone;
    }

    public String getNom_Societe() {
        return Nom_Societe;
    }

    public void setNom_Societe(String nom_Societe) {
        Nom_Societe = nom_Societe;
    }

    public String getDomaine_Activite() {
        return Domaine_Activite;
    }

    public void setDomaine_Activite(String domaine_Activite) {
        Domaine_Activite = domaine_Activite;
    }

    public String getTelephone() {
        return Telephone;
    }

    public void setTelephone(String telephone) {
        Telephone = telephone;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String adresse) {
        Adresse = adresse;
    }

    public Double getLatitude() {
        return Latitude;
    }

    public void setLatitude(Double latitude) {
        Latitude = latitude;
    }

    public Double getLongitude() {
        return Longitude;
    }

    public void setLongitude(Double longitude) {
        Longitude = longitude;
    }

    public String getIdentifiant_Societe() {
        return identifiant_Societe;
    }

    public void setIdentifiant_Societe(String identifiant_Societe) {
        this.identifiant_Societe = identifiant_Societe;
    }

    public Societe() {
    }

}
