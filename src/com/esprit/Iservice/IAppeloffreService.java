/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Iservice;

import java.util.List;

import com.esprit.Entity.AppelOffre;

/**
 *
 * @author PACKARDBELL
 */
public interface IAppeloffreService {

    public void createAo(AppelOffre a);

    public List<AppelOffre> getAll();

    public void update(AppelOffre a);

    public void delete(int id);

   

}
