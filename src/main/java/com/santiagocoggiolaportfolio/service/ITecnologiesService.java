/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.santiagocoggiolaportfolio.service;

import com.santiagocoggiolaportfolio.model.Tecnologies;
import java.util.List;
/**
 *
 * @author Santiago
 */
public interface ITecnologiesService {
    //Trae todos los post Tecnologies
    public List<Tecnologies> getTecnologies();
    
    //Metodo para dar de alta un post Tecnologies
    public void saveTecnologies(Tecnologies tecnologies);
    
    //metodo para borrar un post Tecnologies
    public void deleteTecnologies(Long id);
    
    //metodo para encontrar un post Tecnologies
    public Tecnologies findTecnologies(Long id);
}
