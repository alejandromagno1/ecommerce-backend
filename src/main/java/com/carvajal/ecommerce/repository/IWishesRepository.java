package com.carvajal.ecommerce.repository;

import com.carvajal.ecommerce.model.Wishes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IWishesRepository extends JpaRepository<Wishes, Long> {
    @Query("SELECT ws "
        + "FROM Wishes AS ws "
        + "WHERE ws.idUser = ?1 "
        + "AND ws.idProduct = ?2 "
        + "ORDER BY ws.id")
    Wishes getWishesByUsrProd(Long idUser, Long idProd);
}
