/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.santiagocoggiolaportfolio.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.santiagocoggiolaportfolio.model.Login;
import com.santiagocoggiolaportfolio.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.santiagocoggiolaportfolio.helpers.Password;
/**
 *
 * @author Santiago
 */
@RestController
public class LoginController {
    @Autowired
    private ILoginService interLogin;
    
    @PostMapping ("/login/getToken")
    public String createLogin(@RequestBody Password password, @RequestParam String username){
        return interLogin.findUser(username, password.getPassword());
    }
    
    @GetMapping ("/login/getLogin")
    public Login getUser(@RequestParam String token){
        return interLogin.findUserByToken(token);
    }
}
