package com.carvajal.ecommerce.repository;

import com.carvajal.ecommerce.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRolesRepository extends JpaRepository<Roles, Long> {
    @Query("SELECT rl "
        + "FROM Roles AS rl "
        + "WHERE rl.state = true "
        + "ORDER BY rl.id")
    List<Roles> getAllActives();
}
