/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.santiagocoggiolaportfolio.service;

import com.santiagocoggiolaportfolio.model.Login;
import java.util.List;
/**
 *
 * @author Santiago
 */
public interface ILoginService {
    //Trae todos los post Login
    public List<Login> getLogin();
    
    //Metodo para dar de alta un post Login
    public void saveLogin(Login Login);
    
    //metodo para borrar un post Login
    public void deleteLogin(String id);
    
    //metodo para encontrar usuario cuando se tiene el token
    public Login findUserByToken(String token);
    
    //metodo para encontrar un post Login
    public String findUser(String user, String password);
}
