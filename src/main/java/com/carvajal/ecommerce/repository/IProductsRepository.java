package com.carvajal.ecommerce.repository;

import com.carvajal.ecommerce.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductsRepository extends JpaRepository<Products, Long> {
    @Query("SELECT pr "
        + "FROM Products AS pr "
        + "WHERE pr.state = true "
        + "ORDER BY pr.id")
    List<Products> getAllActives();

    @Query("SELECT pr "
        + "FROM Products AS pr "
        + "INNER JOIN Wishes AS ws ON pr.id = ws.idProduct AND ws.idUser = ?1 "
        + "WHERE pr.state = true "
        + "ORDER BY pr.id")
    List<Products> getAllWishes(Long idUser);
}
