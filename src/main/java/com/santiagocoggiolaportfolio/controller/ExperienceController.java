/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.santiagocoggiolaportfolio.controller;

import com.santiagocoggiolaportfolio.model.Experience;
import com.santiagocoggiolaportfolio.service.IExperienceService;
import com.santiagocoggiolaportfolio.service.ILoginService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Santiago
 */
@RestController
public class ExperienceController {
    @Autowired
    private IExperienceService interExperience;
    @Autowired
    private ILoginService interLogin;
 
    @GetMapping("/database/experience/get")
    public List<Experience> getExperience(){
        return interExperience.getExperience();
    }
    
    @PostMapping ("/database/admin/experience/create/{token}/")
    public String createExperience(@RequestBody Experience exp,
                                   @PathVariable String token){
        if(interLogin.findUserByToken(token) != null){ 
            interExperience.saveExperience(exp);
        return "La Experience fue creada correctamente";
        }else{
            return "No es un usuario administrador";
        }
    }
    
    @DeleteMapping ("/database/admin/experience/delete/{id}/{token}")
    public String deleteExperience(@PathVariable Long id,
                                   @PathVariable String token){
        if(interLogin.findUserByToken(token) != null){ 
            interExperience.deleteExperience(id);
            return "La Experience fue borrada con exito";
        }else{
            return "No es un usuario administrador";
        }
        
    }
    
    @PutMapping ("/database/admin/experience/editar/{id}/{token}")
    public Experience editExperience(@PathVariable Long id,
                                     @PathVariable String token,
                                     @RequestParam ("logoPath") String newPath,
                                     @RequestParam ("position") String newPosition,
                                     @RequestParam ("place") String newPlace,
                                     @RequestParam ("date") String newDate){
        if(interLogin.findUserByToken(token) != null){ 
            Experience exp = interExperience.findExperience(id);
            exp.setLogoPath(newPath);
            exp.setPosition(newPosition);
            exp.setPlace(newPlace);
            exp.setDate(newDate);
            interExperience.saveExperience(exp);
            return exp;
        }else{
            return null;
        }
    }
}
