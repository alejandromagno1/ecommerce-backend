package com.carvajal.ecommerce.repository;

import com.carvajal.ecommerce.model.Users;
import com.carvajal.ecommerce.dto.UsersDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsersRepository extends JpaRepository<Users, Long> {
    @Query("SELECT new com.carvajal.ecommerce.dto.UsersDTO(us.id, "
        + "us.idRol, us.user, us.pwd, us.nameUser, us.eMail, rl.admin, us.state)"
        + "FROM Users AS us "
        + "INNER JOIN Roles AS rl ON us.idRol = rl.id "
        + "Where us.user = ?1 AND us.pwd = ?2")
    UsersDTO login(String user, String passwd);
}
