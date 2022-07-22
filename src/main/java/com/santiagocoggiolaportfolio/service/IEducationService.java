/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.santiagocoggiolaportfolio.service;

import com.santiagocoggiolaportfolio.model.Education;
import java.util.List;
/**
 *
 * @author Santiago
 */
public interface IEducationService {
    //Trae todos los post Education
    public List<Education> getEducation();
    
    //Metodo para dar de alta un post Education
    public void saveEducation(Education edu);
    
    //metodo para borrar un post Education
    public void deleteEducation(Long id);
    
    //metodo para encontrar un post Education
    public Education findEducation(Long id);
}
