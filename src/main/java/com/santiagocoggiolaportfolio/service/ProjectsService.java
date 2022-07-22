/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.santiagocoggiolaportfolio.service;

import com.santiagocoggiolaportfolio.model.Projects;
import com.santiagocoggiolaportfolio.repository.ProjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
/**
 *
 * @author Santiago
 */
@Service
public class ProjectsService implements IProjectsService{
    @Autowired
    private ProjectsRepository prRepo;
    
    @Override
    public List<Projects> getProjects() {
        List<Projects> listprct = prRepo.findAll();
        return listprct;
    }

    @Override
    public void saveProjects (Projects pr) {
        prRepo.save(pr);
    }

    @Override
    public void deleteProjects(Long id) {
        prRepo.deleteById(id);
    }

    @Override
    public Projects findProjects(Long id) {
        Projects pr = prRepo.findById(id).orElse(null);
        return pr;
    }
}
