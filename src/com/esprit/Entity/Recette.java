/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Entity;

/**
 *
 * @author Ahmed
 */
public class Recette {

    public int id;
    public String nom;
    public int duree;
    public String besoin;
    public String preparation;
    public String BN;
    public String nom_image;
    //public User user;
    public int likee;
    public int dislike;
        private static int idRecette;



    public Recette(int id, String nom, int duree, String besoin, String preparation, String BN, String nom_image, int likee, int dislike) {
        this.id = id;
        this.nom = nom;
        this.duree = duree;
        this.besoin = besoin;
        this.preparation = preparation;
        this.BN = BN;
        this.nom_image = nom_image;
        this.likee = likee;
        this.dislike = dislike;

    }

    public Recette(int id, String nom, int duree, String besoin, String preparation, String BN, String nom_image) {
        this.id = id;
        this.nom = nom;
        this.duree = duree;
        this.besoin = besoin;
        this.preparation = preparation;
        this.BN = BN;
        this.nom_image = nom_image;
    }

    public Recette(String nom, int duree, String besoin, String preparation, String BN, String nom_image) {
        this.nom = nom;
        this.duree = duree;
        this.besoin = besoin;
        this.preparation = preparation;
        this.BN = BN;
        this.nom_image = nom_image;
    }

    public Recette(String nom) {
        this.nom = nom;
    }

    public Recette(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static int getIdRecette() {
        return idRecette;
    }

    public static void setIdRecette(int idRecette) {
        Recette.idRecette = idRecette;
    }

    public Recette(int id, String text, int parseInt, String text0, String text1, String text2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public String getBesoin() {
        return besoin;
    }

    public void setBesoin(String besoin) {
        this.besoin = besoin;
    }

    public String getPreparation() {
        return preparation;
    }

    public void setPreparation(String preparation) {
        this.preparation = preparation;
    }

    public String getBN() {
        return BN;
    }

    public void setBN(String BN) {
        this.BN = BN;
    }

    public String getNom_image() {
        return nom_image;
    }

    public void setNom_image(String nom_image) {
        this.nom_image = nom_image;
    }

    public int getLikee() {
        return likee;
    }

    public void setLikee(int likee) {
        this.likee = likee;
    }

    public int getDislike() {
        return dislike;
    }

    public void setDislike(int dislike) {
        this.dislike = dislike;
    }

    @Override
    public String toString() {
        return id + " " + nom + " " + duree + " " + besoin + " " + preparation + " " + BN + " " + nom_image
                + " " + likee + " " + dislike;
    }

    public String toStringName() {
        return nom;
    }

}
