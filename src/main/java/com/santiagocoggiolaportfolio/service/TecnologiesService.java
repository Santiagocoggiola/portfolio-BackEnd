/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.santiagocoggiolaportfolio.service;


import com.santiagocoggiolaportfolio.model.Tecnologies;
import com.santiagocoggiolaportfolio.repository.TecnologiesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Santiago
 */
@Service
public class TecnologiesService implements ITecnologiesService {

    @Autowired
    TecnologiesRepository tecnoRepo;
    @Override
    public List<Tecnologies> getTecnologies() {
        List<Tecnologies> listTecnologies = tecnoRepo.findAll();
        return listTecnologies;
    }

    @Override
    public void saveTecnologies(Tecnologies tecnologies) {
        tecnoRepo.save(tecnologies);
    }

    @Override
    public void deleteTecnologies(Long id) {
        tecnoRepo.deleteById(id);
    }

    @Override
    public Tecnologies findTecnologies(Long id) {
        Tecnologies tecno = tecnoRepo.findById(id).orElse(null);
        return tecno;
    }
    
}
