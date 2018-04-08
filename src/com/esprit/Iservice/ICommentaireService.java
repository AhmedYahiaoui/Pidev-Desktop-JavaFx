/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Iservice;

import com.esprit.Entity.Commentaire;
import java.util.List;

/**
 *
 * @author Ahmed
 */
public interface ICommentaireService {
    
    public void createCommentair(Commentaire com);

    public List<Commentaire> getAll();

    public void update(Commentaire com);

    public void delete(int id);
    
    public List<Commentaire> AfficherCommentaire(int r);

}
