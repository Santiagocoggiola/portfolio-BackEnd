/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.santiagocoggiolaportfolio.service;

import com.santiagocoggiolaportfolio.model.Projects;
import java.util.List;
/**
 *
 * @author Santiago
 */
public interface IProjectsService {
    //Trae todos los post Projects
    public List<Projects> getProjects();
    
    //Metodo para dar de alta un post Projects
    public void saveProjects(Projects projects);
    
    //metodo para borrar un post Projects
    public void deleteProjects(Long id);
    
    //metodo para encontrar un post Projects
    public Projects findProjects(Long id);
}
