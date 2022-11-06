package com.bookStore.bookApp.Repositories;

import com.bookStore.bookApp.Entities.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Rol,Long> {
    Rol findByName(String name);
}
