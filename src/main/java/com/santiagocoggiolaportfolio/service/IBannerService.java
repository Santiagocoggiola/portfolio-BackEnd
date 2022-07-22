/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.santiagocoggiolaportfolio.service;

import com.santiagocoggiolaportfolio.model.Banner;
import java.util.*;
/**
 *
 * @author Santiago
 */
public interface IBannerService {
    //Trae todos los post banner
    public List<Banner> getBanner();
    
    //Metodo para dar de alta un post banner
    public void saveBanner(Banner banner);
    
    //metodo para borrar un post banner
    public void deleteBanner(Long id);
    
    //metodo para encontrar un post banner
    public Banner findBanner(Long id);
}
