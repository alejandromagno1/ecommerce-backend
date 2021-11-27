package com.carvajal.ecommerce.repository;

import com.carvajal.ecommerce.model.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISalesRepository extends JpaRepository<Sales, Long> {

}
