/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Iservice;

import com.esprit.Entity.User;
import java.util.List;

/**
 *
 * @author Ahmed
 */
public interface IUserService {
    
    public void createUser(User user);
    public List<User> getAll();
    public List<User> getAllName();
}
