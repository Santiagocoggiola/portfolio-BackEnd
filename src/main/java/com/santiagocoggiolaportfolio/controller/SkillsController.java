/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.santiagocoggiolaportfolio.controller;

import com.santiagocoggiolaportfolio.model.Skills;
import com.santiagocoggiolaportfolio.service.ILoginService;
import com.santiagocoggiolaportfolio.service.ISkillsService;
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
public class SkillsController {
    @Autowired
    private ISkillsService interSkills;
    @Autowired
    private ILoginService interLogin;
    
    @GetMapping("/database/skills/get")
    public List<Skills> getSkills(){
        return interSkills.getSkills();
    }
    
    @PostMapping ("/database/admin/skills/create/{token}")
    public String createSkills(@RequestBody Skills skl, 
                                  @PathVariable String token){
        if(interLogin.findUserByToken(token) != null){ 
            interSkills.saveSkills(skl);
            return "La Skill fue creada correctamente";
        }else{
            return "No es un usuario administrador";
        }
        
    }
    
    @DeleteMapping ("/database/admin/skills/delete/{id}/{token}")
    public String deleteSkills(@PathVariable Long id, 
                               @PathVariable String token){
        if(interLogin.findUserByToken(token) != null){ 
            interSkills.deleteSkills(id);
            return "La Skill fue borrada con exito";
        }else{
            return "No es un usuario administrador";
        }
    }
    
    @PutMapping ("/database/admin/skills/editar/{id}/{token}")
    public Skills editSkills(@PathVariable Long id,
                             @PathVariable String token,
                             @RequestParam ("name") String newName,
                             @RequestParam ("percentage") Float newPercentage,
                             @RequestParam ("type") String newType) {
        if(interLogin.findUserByToken(token) != null){ 
            Skills skl = interSkills.findSkills(id);
            skl.setName(newName);
            skl.setPercentage(newPercentage);
            skl.setType(newType);
            interSkills.saveSkills(skl);
            return skl;
        }else{
            return null;
        } 
    }
}
