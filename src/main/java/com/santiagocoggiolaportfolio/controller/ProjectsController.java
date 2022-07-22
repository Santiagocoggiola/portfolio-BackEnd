/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.santiagocoggiolaportfolio.controller;

import com.santiagocoggiolaportfolio.model.Projects;
import com.santiagocoggiolaportfolio.service.ILoginService;
import com.santiagocoggiolaportfolio.service.IProjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
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
public class ProjectsController {
    @Autowired
    private IProjectsService interProject;
    @Autowired
    private ILoginService interLogin;
    
    @GetMapping("/database/projects/get")
    public List<Projects> getProjects(){
        return interProject.getProjects();
    }
    
    @PostMapping ("/database/admin/{token}/projects/create")
    public String createProject(@RequestBody Projects pro, 
                                  @PathVariable String token){
        if(interLogin.findUserByToken(token) != null){ 
            interProject.saveProjects(pro);
            return "La educacion fue creada correctamente";
        }else{
            return "No es un usuario administrador";
        }
        
    }
    
    @DeleteMapping ("/database/admin/{token}/projects/delete/{id}")
    public String deleteProject(@PathVariable Long id, 
                                @PathVariable String token){
        if(interLogin.findUserByToken(token) != null){ 
            interProject.deleteProjects(id);
            return "La educacion fue borrada con exito";
        }else{
            return "No es un usuario administrador";
        }
    }
    
    @PutMapping ("/database/admin/{token}/projects/editar/{id}")
    public Projects editProject(@PathVariable Long id,
                                @PathVariable String token,
                                @RequestParam ("name") String newName,
                                @RequestParam ("imgPath") String newImgPath,
                                @RequestParam ("description") String newDesc,
                                @RequestParam ("idProject") Long newIdProject){
        if(interLogin.findUserByToken(token) != null){ 
            Projects pro = interProject.findProjects(id);
            pro.setName(newName);
            pro.setImgPath(newImgPath);
            pro.setDescription(newDesc);
            pro.setIdProject(newIdProject);
            interProject.saveProjects(pro);
            return pro;
        }else{
            return null;
        } 
    }
}
