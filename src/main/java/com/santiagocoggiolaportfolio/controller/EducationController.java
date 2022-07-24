/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.santiagocoggiolaportfolio.Controller;

import com.santiagocoggiolaportfolio.model.Education;
import com.santiagocoggiolaportfolio.service.IEducationService;
import com.santiagocoggiolaportfolio.service.ILoginService;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Santiago
 */
@RestController
public class EducationController {  
        
    @Autowired
    private IEducationService interEducation;
    @Autowired
    private ILoginService interLogin;
 
    @GetMapping("/database/education/get")
    public List<Education> getEducation(){
        return interEducation.getEducation();
    }
    
    @PostMapping ("/database/admin/education/create/{token}/")
    public String createEducation(@RequestBody Education edu, 
                                  @PathVariable String token){
        if(interLogin.findUserByToken(token) != null){ 
            interEducation.saveEducation(edu);
            return "La educacion fue creada correctamente";
        }else{
            return "No es un usuario administrador";
        }
        
    }
    
    @DeleteMapping ("/database/admin/education/delete/{id}/{token}")
    public String deleteEducation(@PathVariable Long id, 
                                  @PathVariable String token){
        if(interLogin.findUserByToken(token) != null){ 
            interEducation.deleteEducation(id);
            return "La educacion fue borrada con exito";
        }else{
            return "No es un usuario administrador";
        }
    }
    
    @PutMapping ("/database/admin/education/editar/{id}/{token}")
    public Education editEducation(@PathVariable Long id,
                                   @PathVariable String token,
                                   @RequestParam ("logoPath") String newPath,
                                   @RequestParam ("university") String newUniversity,
                                   @RequestParam ("career") String newCareer,
                                   @RequestParam ("date") String newDate){
        if(interLogin.findUserByToken(token) != null){ 
            Education edu = interEducation.findEducation(id);
            edu.setLogoPath(newPath);
            edu.setUniversity(newUniversity);
            edu.setCareer(newCareer);
            edu.setDate(newDate);
            interEducation.saveEducation(edu);
            return edu;
        }else{
            return null;
        } 
    }
}
