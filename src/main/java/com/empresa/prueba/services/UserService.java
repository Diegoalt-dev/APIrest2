package com.empresa.prueba.services;

import com.empresa.prueba.dao.UsuarioDao;
import com.empresa.prueba.models.MyUserDetails;
import com.empresa.prueba.models.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException{
        Optional<Usuarios> usuario = usuarioDao.findByUser(userName);
        usuario.orElseThrow(()-> new UsernameNotFoundException("Not found "+ userName));
        return usuario.map(MyUserDetails::new).get();
    }
}
