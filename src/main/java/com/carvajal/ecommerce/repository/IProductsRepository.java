package com.carvajal.ecommerce.repository;

import com.carvajal.ecommerce.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductsRepository extends JpaRepository<Products, Long> {

}
