package com.carvajal.ecommerce.repository;

import com.carvajal.ecommerce.model.Sales;
import com.carvajal.ecommerce.dto.SalesDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISalesRepository extends JpaRepository<Sales, Long> {
    @Query("SELECT new com.carvajal.ecommerce.dto.SalesDTO(pr.nameProd, pr.descProd, "
        + "pr.price, pr.urlPicture, sl.quantity, sl.dateSale, sl.state) "
        + "FROM Sales as sl "
        + "INNER JOIN Products AS pr ON sl.idProduct = pr.id "
        + "WHERE sl.idUser = ?1 "
        + "ORDER BY sl.id")
    List<SalesDTO> getAllshopping(Long idUser);
}
