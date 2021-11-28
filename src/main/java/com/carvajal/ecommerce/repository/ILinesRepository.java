package com.carvajal.ecommerce.repository;

import com.carvajal.ecommerce.model.Lines;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILinesRepository extends JpaRepository<Lines, Long> {
    @Query("SELECT ln "
        + "FROM Lines AS ln "
        + "WHERE ln.state = true "
        + "ORDER BY ln.id")
    List<Lines> getAllActives();
}
