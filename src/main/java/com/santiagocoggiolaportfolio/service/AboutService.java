/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.santiagocoggiolaportfolio.service;

import com.santiagocoggiolaportfolio.model.About;
import com.santiagocoggiolaportfolio.repository.AboutRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Santiago
 */
@Service
public class AboutService implements IAboutService {
    @Autowired
    private AboutRepository aboutRepository;

    @Override
    public List<About> getAbout() {
        List<About> listAbout = aboutRepository.findAll();
        return listAbout;
    }

    @Override
    public void saveAbout(About about) {
        aboutRepository.save(about);
    }

    @Override
    public void deleteAbout(Long id) {
        aboutRepository.deleteById(id);
    }

    @Override
    public About findAbout(Long id) {
        About about = aboutRepository.findById(id).orElse(null);
        return about;
    }
    
    
}
