package com.enviro.assessment.grad001.MukovhePat.WasteSorting.Repository;

import com.enviro.assessment.grad001.MukovhePat.WasteSorting.Entity.DisposalGuideline;
import com.enviro.assessment.grad001.MukovhePat.WasteSorting.Entity.WasteCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DisposalGuidelineRepo extends JpaRepository<DisposalGuideline,Long> {

    @Query(value = "SELECT g.*, c.category_name AS category_name FROM Guidelines g JOIN Categories c ON g.category_id = c.id WHERE c.category_name = ?1", nativeQuery = true)
    List<DisposalGuideline> findByCategoryName(String categoryName);




}
