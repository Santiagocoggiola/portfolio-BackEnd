/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.santiagocoggiolaportfolio.service;

import com.santiagocoggiolaportfolio.model.Skills;
import com.santiagocoggiolaportfolio.repository.SkillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
/**
 *
 * @author Santiago
 */
@Service
public class SkillsService implements ISkillsService{
    @Autowired
    private SkillsRepository skillsRepo;
    @Override
    public List<Skills> getSkills() {
        List<Skills> listSkills = skillsRepo.findAll();
        return listSkills;
    }

    @Override
    public void saveSkills(Skills skill) {
        skillsRepo.save(skill);
    }

    @Override
    public void deleteSkills(Long id) {
        skillsRepo.deleteById(id);
    }

    @Override
    public Skills findSkills(Long id) {
        Skills skill = skillsRepo.findById(id).orElse(null);
        return skill;
    }
}
