package com.carvajal.ecommerce.repository;

import com.carvajal.ecommerce.model.Lines;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILinesRepository extends JpaRepository<Lines, Long> {

}
