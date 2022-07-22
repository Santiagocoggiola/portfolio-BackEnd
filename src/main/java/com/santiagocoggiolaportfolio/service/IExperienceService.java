/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.santiagocoggiolaportfolio.service;

import com.santiagocoggiolaportfolio.model.Experience;
import java.util.List;
/**
 *
 * @author Santiago
 */
public interface IExperienceService {
    //Trae todos los post Experience
    public List<Experience> getExperience();
    
    //Metodo para dar de alta un post Experience
    public void saveExperience(Experience experience);
    
    //metodo para borrar un post Experience
    public void deleteExperience(Long id);
    
    //metodo para encontrar un post Experience
    public Experience findExperience(Long id);
}
