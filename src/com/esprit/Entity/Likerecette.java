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
public class Likerecette {
    public int id;
    public Recette recette_id;
    public User user_id;
    public int valeur;

    public Likerecette(int id, int valeur) {
        this.id = id;
        this.valeur = valeur;
    }

    public Likerecette(int id, Recette recette_id, User user_id) {
        this.id = id;
        this.recette_id = recette_id;
        this.user_id = user_id;
    }

        public Likerecette(int valeur) {
        this.valeur = valeur;
    }

    public Likerecette() {
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Recette getRecette_id() {
        return recette_id;
    }

    public void setRecette_id(Recette recette_id) {
        this.recette_id = recette_id;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

}
