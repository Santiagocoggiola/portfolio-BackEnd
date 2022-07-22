/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.santiagocoggiolaportfolio.service;

import com.santiagocoggiolaportfolio.model.Education;
import com.santiagocoggiolaportfolio.repository.EducationRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Santiago
 */
@Service
public class EducationService implements IEducationService {

    @Autowired
    private EducationRepository eduRepo;
    @Override
    public List<Education> getEducation() {
        List<Education> listEdu = eduRepo.findAll();
        return listEdu;
    }

    @Override
    public void saveEducation(Education edu) {
        eduRepo.save(edu);
    }

    @Override
    public void deleteEducation(Long id) {
        eduRepo.deleteById(id);
    }

    @Override
    public Education findEducation(Long id) {
        Education edu = eduRepo.findById(id).orElse(null);
        return edu;
    }
    
}
