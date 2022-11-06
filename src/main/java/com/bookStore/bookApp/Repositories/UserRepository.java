package com.bookStore.bookApp.Repositories;
import com.bookStore.bookApp.projections.UsersPr;
import com.bookStore.bookApp.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
    @Query(value = "SELECT  u.id,u.email,u.username FROM users AS u",nativeQuery = true)
    List<UsersPr> findAllNotRolPassword();

    @Query(
            value = "SELECT CAST( CASE WHEN COUNT(*)>0 THEN 1 ELSE 0 END AS BIT) FROM users AS r WHERE r.email = :email",nativeQuery = true)
    Boolean existByEmail(@Param("email") String email);

    @Query(value = "SELECT CAST( CASE WHEN COUNT(*)>0 THEN 1 ELSE 0 END AS BIT) FROM users AS r WHERE r.username = :username",nativeQuery = true)
    Boolean existByUsername(@Param("username") String username);

    User findByUsername(String username);
}
