/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Entity;

/**
 *
 * @author PACKARDBELL
 */
public class demandeoffre {

    public User id ;
    public User user;
    public AppelOffre appel;
    public int statut;

    public demandeoffre(User id, int statut) {
        this.id = id;
        this.statut = statut;
    }

  
    public demandeoffre() {
this.statut = statut;    }

    public demandeoffre(User id, User user, AppelOffre appel, int statut) {
        this.id = id;
        this.user = user;
        this.appel = appel;
        this.statut = statut;
    }



    public demandeoffre(String string, int aInt, int aInt0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  

   

  

  

    public void setStatut(int statut) {
        this.statut = statut;
    }

    public User getId() {
        return id;
    }

    public void setId(User id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public AppelOffre getAppel() {
        return appel;
    }

    public void setAppel(AppelOffre appel) {
        this.appel = appel;
    }

    

  

    public int getStatut() {
        return statut;
    }

}
