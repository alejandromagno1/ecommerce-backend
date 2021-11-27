package com.carvajal.ecommerce.repository;

import com.carvajal.ecommerce.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolesRepository extends JpaRepository<Roles, Long> {

}
