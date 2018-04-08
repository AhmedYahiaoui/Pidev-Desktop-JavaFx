package com.esprit.Entity;

public class Commentaire {

    public int id;
    public String contenu;
    public Recette recette_id;

    public Recette getRecette_id() {
        return recette_id;
    }

    public void setRecette_id(Recette recette_id) {
        this.recette_id = recette_id;
    }

    public Commentaire(int id, String contenu, int recette_id) {
        this.id = id;
        this.contenu = contenu;
    }

    public Commentaire(String contenu, int recette_id) {
        this.contenu = contenu;
    }

    public Commentaire(int id, String contenu) {
        this.id = id;
        this.contenu = contenu;
    }

    public Commentaire(String contenu) {
        this.contenu = contenu;
    }

    public Commentaire() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    @Override
    public String toString() {
        return "Commentaire{" + "id=" + id + ", contenu=" + contenu + '}';
    }
}
