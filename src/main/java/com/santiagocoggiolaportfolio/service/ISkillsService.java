/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.santiagocoggiolaportfolio.service;

import com.santiagocoggiolaportfolio.model.Skills;
import java.util.List;
/**
 *
 * @author Santiago
 */
public interface ISkillsService {
    //Trae todos los post Skills
    public List<Skills> getSkills();
    
    //Metodo para dar de alta un post Skills
    public void saveSkills (Skills skills);
    
    //metodo para borrar un post Skills
    public void deleteSkills(Long id);
    
    //metodo para encontrar un post Skills
    public Skills findSkills(Long id);
}
