package com.example.bookApp.Services.impl;

import com.example.bookApp.Entities.Rol;
import com.example.bookApp.Exceptions.NotFound;
import com.example.bookApp.Exceptions.AlreadyExist;
import com.example.bookApp.Repositories.RolRepository;
import com.example.bookApp.Services.RolesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public  class RolesServiceImpl implements RolesService {
    private static final Logger log = LoggerFactory.getLogger(RolesServiceImpl.class);

    @Autowired
    RolRepository rolRepository;

    @Override
    public List<Rol> finddAllROles() {
        List<Rol> roles=rolRepository.findAll();
        if(roles.size()<1){
            throw new NotFound("No hay roles cargados");
        }
        return roles;
    }

    @Override
    public List<Rol> saveRoles(String[] roles) {
        List<Rol> newRoles= new ArrayList<Rol>();
        for(String rol:roles){
            Rol nrol= new Rol(rol);
            newRoles.add(nrol);
        }
        try{
            return rolRepository.saveAll(newRoles);
        }catch (Exception e){
            log.error("Error roles create:{}",e.getMessage());
            throw new AlreadyExist("duplicate roles are not allowed");
        }
    }

    @Override
    public void deleteRol(Long id) {
        try{
            rolRepository.deleteById(id);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.resolve(e.hashCode()),e.getMessage());
        }
    }

    @Override
    public void deleteAllRoles() {
        try{
            rolRepository.deleteAll();
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.resolve(e.hashCode()),e.getMessage());
        }
    }
}
