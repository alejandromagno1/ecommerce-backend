package com.carvajal.ecommerce.repository;

import com.carvajal.ecommerce.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsersRepository extends JpaRepository<Users, Long> {

}
