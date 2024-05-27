package com.enviro.assessment.grad001.MukovhePat.WasteSorting.Repository;

import com.enviro.assessment.grad001.MukovhePat.WasteSorting.Entity.WasteCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface WasteCategoryRepo extends JpaRepository<WasteCategory,Long> {
    @Query(value = "select * from Categories where category_name = ?1", nativeQuery = true)
    Optional<WasteCategory> findByCategoryName(String categoryName);

}
