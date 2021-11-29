package com.carvajal.ecommerce.repository;

import com.carvajal.ecommerce.model.Wishes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface IWishesRepository extends JpaRepository<Wishes, Long> {
    @Query("SELECT ws "
        + "FROM Wishes AS ws "
        + "WHERE ws.idUser = ?1 "
        + "AND ws.idProduct = ?2 "
        + "AND ws.state = true "
        + "ORDER BY ws.id")
    Wishes getWishesByUsrProd(Long idUser, Long idProd);

    @Transactional
    @Modifying
    @Query("DELETE FROM Wishes AS ws "
        + "WHERE ws.idUser = ?1 AND ws.idProduct = ?2")
    void deleteByUsrProd(Long idUser, Long idProd);
}
