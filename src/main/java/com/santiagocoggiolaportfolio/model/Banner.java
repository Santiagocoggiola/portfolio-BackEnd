/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.santiagocoggiolaportfolio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;


/**
 *
 * @author Santiago
 */
@Getter @Setter
@Entity
public class Banner {
    @Id 
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
    private String imgPath;
    private Boolean isActive;
}
