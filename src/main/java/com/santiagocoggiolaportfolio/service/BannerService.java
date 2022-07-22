/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.santiagocoggiolaportfolio.service;

import com.santiagocoggiolaportfolio.model.Banner;
import com.santiagocoggiolaportfolio.repository.BannerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Santiago
 */
@Service
public class BannerService implements IBannerService{

    @Autowired
    private BannerRepository bannerRepository;
    @Override
    public List<Banner> getBanner() {
        List<Banner> listBanner = bannerRepository.findAll();
        return listBanner;
    }

    @Override
    public void saveBanner(Banner banner) {
        bannerRepository.save(banner);
    }

    @Override
    public void deleteBanner(Long id) {
        bannerRepository.deleteById(id);
    }

    @Override
    public Banner findBanner(Long id) {
        Banner banner = bannerRepository.findById(id).orElse(null);
        return banner;
    }
    
}
