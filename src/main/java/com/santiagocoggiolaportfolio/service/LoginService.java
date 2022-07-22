/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.santiagocoggiolaportfolio.service;

import com.santiagocoggiolaportfolio.model.Login;
import com.santiagocoggiolaportfolio.repository.LoginRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Santiago
 */
@Service
public class LoginService implements ILoginService{
    @Autowired
    private LoginRepository logRepo;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    
    @Override
    public List<Login> getLogin() {
        List<Login> listLog = logRepo.findAll();
        return listLog;
    }

    @Override
    public void saveLogin(Login login) {
        logRepo.save(login);
    }

    @Override
    public void deleteLogin(String id) {
        logRepo.deleteById(id);
    }

    @Override 
    public Login findUserByToken(String token){
        return logRepo.findById(token).orElse(null);
    }
    @Override
    public String findUser(String user, String password) {
        List<Login> login = getLogin();
        for (com.santiagocoggiolaportfolio.model.Login log : login) {
            if(log.getUserName() == null ? user == null : log.getUserName().equals(user)){
                if(log.getPassword() == null ? password == null : log.getPassword().equals(password)){
                    final String token = jwtTokenUtil.generateToken(log);
                    Login newLog = new Login();
                    newLog.setPassword(password);
                    newLog.setUserName(user);
                    newLog.setUserToken(token);
                    logRepo.delete(log);
                    logRepo.save(newLog);
                    return newLog.getUserToken();
                }else{
                    return "Wrong Password";
                }
            }
        }
        return "Wrong Username";
    }
    
}
