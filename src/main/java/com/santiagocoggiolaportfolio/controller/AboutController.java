/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.santiagocoggiolaportfolio.controller;

import com.santiagocoggiolaportfolio.model.About;
import com.santiagocoggiolaportfolio.service.IAboutService;
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
public class AboutController {
    @Autowired
    private IAboutService interAbout;
    @Autowired
    private ILoginService interLogin;
 
    @GetMapping("/database/about/get")
    public List<About> getAbout(){
        return interAbout.getAbout();
    }
    
    @PostMapping ("/database/admin/{token}/about/create")
    public String createAbout(@RequestBody About about, @PathVariable String token){
        if(interLogin.findUserByToken(token) != null){
            interAbout.saveAbout(about);
            return "El About fue creado correctamente";
        }else{
            return "No es un usuario administrador";
        }
        
    }
    
    @DeleteMapping ("/database/admin/about/delete/{id}/{token}")
    public String deleteAbout(@PathVariable Long id, @PathVariable String token){
        if(interLogin.findUserByToken(token) != null){
            interAbout.deleteAbout(id);
            return "El About fue borrado con exito";
        }else{
            return "No es un usuario administrador";
        }
        
        
    }
    
    @PutMapping ("/database/admin/about/editar/{id}/{token}")
    public About editAbout(@PathVariable Long id,
                           @PathVariable String token,
                                   @RequestParam ("photoPath") String newPath,
                                   @RequestParam ("text") String newText,
                                   @RequestParam ("isActive") Boolean newActive){
        if(interLogin.findUserByToken(token) != null){
            About about = interAbout.findAbout(id);
            about.setPhotoPath(newPath);
            about.setText(newText);
            about.setIsActive(newActive);
            interAbout.saveAbout(about);
            return about;
        }else{
            return null;
        }
        
    }
}
