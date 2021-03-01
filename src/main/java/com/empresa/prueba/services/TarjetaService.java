package com.empresa.prueba.services;


import com.empresa.prueba.dao.TarjetaDao;
import com.empresa.prueba.models.Persona2;
import com.empresa.prueba.models.Tarjeta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TarjetaService {
    @Autowired
    private TarjetaDao tarjetaDao;

    public boolean validaTarjeta(Tarjeta tarjeta){
        if (tarjetaDao.findById(tarjeta.getId())!=null){
            return true;
        }
        else
        {
            return false;
        }
    }
}
