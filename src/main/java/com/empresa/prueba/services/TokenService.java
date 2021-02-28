package com.empresa.prueba.services;

import com.empresa.prueba.dao.TokenDao;
import com.empresa.prueba.models.Usuariotoken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.List;

@Service
public class TokenService {
    @Autowired
    private TokenDao tokenDao;


    private static final SecureRandom secureRandom = new SecureRandom(); //threadsafe
    private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder(); //threadsafe

    public boolean validaToken(String token){
        if(tokenDao.findByToken(token) != null)
        {
            return  true;
        }
        else
        {
            return false;
        }
    }

    public String generateNewToken() {
        byte[] randomBytes = new byte[24];
        secureRandom.nextBytes(randomBytes);
        return base64Encoder.encodeToString(randomBytes);
    }


    @Scheduled(fixedDelay = 90000L)
    public void updateToken() {

        List<Usuariotoken> usuariosToken = tokenDao.findAll();


        for(Usuariotoken usuarios : usuariosToken){
            usuarios.setToken(generateNewToken());
            tokenDao.save(usuarios);
            System.out.println("*******Token guardado***********");
            System.out.println("Usuario " + usuarios.getUser() + " token " + usuarios.getToken());
        }

    }
}
