/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.santiagocoggiolaportfolio.repository;

import com.santiagocoggiolaportfolio.model.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Santiago
 */
@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Long>{
    
}
