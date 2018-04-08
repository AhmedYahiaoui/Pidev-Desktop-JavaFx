/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Iservice;

import com.esprit.Entity.Recette;

import java.util.List;

/**
 *
 * @author Ahmed
 */
public interface IRecetteService {
    
    public void createRecette(Recette r);

    public List<Recette> getAll();
    
    public List<Recette> getAll2();

    
    public List<Recette> get_Nom_Recette();
    
    public List<Recette> getRecette_Admin();
    
    public List<Recette> get_image_Recette();

    public Recette AfficherRecetteId(int id);
    
    public Recette AfficherRecetteCategorie(int id);
    
    public void update(Recette r);

    public void delete(int id);

}
