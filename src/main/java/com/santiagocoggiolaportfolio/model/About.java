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
public class About {
    @Id 
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
    private String photoPath;
    private String text;
    private Boolean isActive;
}
