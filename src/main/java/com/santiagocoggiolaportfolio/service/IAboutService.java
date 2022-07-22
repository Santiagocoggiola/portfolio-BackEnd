/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.santiagocoggiolaportfolio.service;

import com.santiagocoggiolaportfolio.model.About;
import java.util.*;

/**
 *
 * @author Santiago
 */
public interface IAboutService {
    //Trae todos los post about
    public List<About> getAbout();
    
    //Metodo para dar de alta un post about
    public void saveAbout(About about);
    
    //metodo para borrar un post about
    public void deleteAbout(Long id);
    
    
    //metodo para encontrar un post about
    public About findAbout(Long id);
}
