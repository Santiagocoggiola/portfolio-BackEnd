/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.santiagocoggiolaportfolio.controller;

import com.santiagocoggiolaportfolio.model.Skills;
import com.santiagocoggiolaportfolio.model.Tecnologies;
import com.santiagocoggiolaportfolio.service.ILoginService;
import com.santiagocoggiolaportfolio.service.ISkillsService;
import com.santiagocoggiolaportfolio.service.ITecnologiesService;
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
public class TecnologiesController {
    @Autowired
    private ITecnologiesService interTecnologies;
    @Autowired
    private ILoginService interLogin;
    
    @GetMapping("/database/tecnologies/get")
    public List<Tecnologies> getTecnologies(){
        return interTecnologies.getTecnologies();
    }
    
    @PostMapping ("/database/admin/tecnologies/create/{token}")
    public String createTecnologies(@RequestBody Tecnologies tec, 
                               @PathVariable String token){
        if(interLogin.findUserByToken(token) != null){ 
            interTecnologies.saveTecnologies(tec);
            return "La Skill fue creada correctamente";
        }else{
            return "No es un usuario administrador";
        }
    }
    
    @DeleteMapping ("/database/admin/tecnologies/delete/{id}/{token}")
    public String deleteTecnologies(@PathVariable Long id, 
                               @PathVariable String token){
        if(interLogin.findUserByToken(token) != null){ 
            interTecnologies.deleteTecnologies(id);
            return "La Skill fue borrada con exito";
        }else{
            return "No es un usuario administrador";
        }
    }
    
    @PutMapping ("/database/admin/tecnologies/editar/{id}/{token}")
    public Tecnologies editTecnologies( @PathVariable Long id,
                                        @PathVariable String token,
                                        @RequestParam ("logoPath1") String newLogoPath1,
                                        @RequestParam ("logoPath2") String newLogoPath2,
                                        @RequestParam ("logoPath3") String newLogoPath3,
                                        @RequestParam ("logoPath4") String newLogoPath4,                                      
                                        @RequestParam ("row") Long newRow) {
        if(interLogin.findUserByToken(token) != null){ 
            Tecnologies tec = interTecnologies.findTecnologies(id);
            tec.setLogoPath1(newLogoPath1);
            tec.setLogoPath2(newLogoPath2);
            tec.setLogoPath3(newLogoPath3);
            tec.setLogoPath4(newLogoPath4);
            tec.setRow(newRow);
            interTecnologies.saveTecnologies(tec);
            return tec;
        }else{
            return null;
        } 
    }
}
