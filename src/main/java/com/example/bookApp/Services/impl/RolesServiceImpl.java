package com.example.bookApp.Services.impl;

import com.example.bookApp.Entities.Rol;
import com.example.bookApp.Exceptions.NotFound;
import com.example.bookApp.Exceptions.RolAlreadyExist;
import com.example.bookApp.Repositories.RolRepository;
import com.example.bookApp.Services.RolesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
            throw new RolAlreadyExist("No puede haber roles duplicados");
        }
    }

    @Override
    public void deleteRol(String rolName) {

    }

    @Override
    public void deleteAllRoles() {

    }
}
