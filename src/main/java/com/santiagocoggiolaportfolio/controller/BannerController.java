/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.santiagocoggiolaportfolio.controller;


import com.santiagocoggiolaportfolio.model.Banner;
import com.santiagocoggiolaportfolio.service.IBannerService;
import com.santiagocoggiolaportfolio.service.ILoginService;
import com.santiagocoggiolaportfolio.service.LoginService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Santiago
 */
@RestController
public class BannerController {
    @Autowired
    private IBannerService interBanner;
    @Autowired
    private ILoginService interLogin;
    @GetMapping("/database/banner/get")
    public List<Banner> getBanner(){
        return interBanner.getBanner();
    }
    
    @PostMapping ("/database/admin/banner/create/{token}")
    public String createBanner(@RequestBody Banner banner, 
                               @PathVariable String token){
        if(interLogin.findUserByToken(token) != null){ 
            interBanner.saveBanner(banner);
            return "El Banner fue creado correctamente";
        }else{
            return "No es un usuario admin";
        }
    }
    
    @DeleteMapping ("/database/admin/banner/delete/{id}/{token}")
    public String deleteBanner(@PathVariable Long id, 
                               @PathVariable String token){
        if(interLogin.findUserByToken(token) != null){ 
            interBanner.deleteBanner(id);
            return "El About fue borrado con exito";
        }else{
            return "No es un usuario admin";
        }
    }
    
    @PutMapping ("/database/admin/banner/editar/{id}/{token}")
    public Banner editBanner (@PathVariable Long id,
                              @PathVariable String token,
                              @RequestParam ("imgPath") String newPath,
                              @RequestParam ("isActive") Boolean newActive){
        
        if(interLogin.findUserByToken(token) != null){    
            Banner banner = interBanner.findBanner(id);
            banner.setImgPath(newPath);
            banner.setIsActive(newActive);
            interBanner.saveBanner(banner);
            return banner;
        }else{
            return null;
        }
    }
}
