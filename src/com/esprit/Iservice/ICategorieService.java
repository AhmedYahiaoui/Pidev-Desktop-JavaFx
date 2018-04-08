/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Iservice;

import com.esprit.Entity.Categorie;
import com.esprit.Entity.User;
import java.util.List;

/**
 *
 * @author Ahmed
 */
public interface ICategorieService {
        
    public void createCategorie(Categorie cat);

    public List<Categorie> getAll();
    public void update(Categorie cat);
    public List<Categorie> getAllName();


}
