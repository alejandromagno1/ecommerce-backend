package com.carvajal.ecommerce.repository;

import com.carvajal.ecommerce.model.Wishes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IWishesRepository extends JpaRepository<Wishes, Long> {

}
