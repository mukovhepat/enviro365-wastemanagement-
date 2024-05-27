package com.enviro.assessment.grad001.MukovhePat.WasteSorting.Controller;

import com.enviro.assessment.grad001.MukovhePat.WasteSorting.Dto.Request.CategoryRequestDto;
import com.enviro.assessment.grad001.MukovhePat.WasteSorting.Dto.Request.UpdateCategoryRequestDto;
import com.enviro.assessment.grad001.MukovhePat.WasteSorting.Dto.Response.ResponseObject;
import com.enviro.assessment.grad001.MukovhePat.WasteSorting.Entity.WasteCategory;
import com.enviro.assessment.grad001.MukovhePat.WasteSorting.Service.Interface.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/category")
public class CategoryController {

    private final CategoryService categoryService;
    @PostMapping
    public ResponseEntity<WasteCategory> CreateCategory( @Valid @RequestBody CategoryRequestDto categoryRequestDto){
        return new ResponseEntity<>( this.categoryService.CreateCategory(categoryRequestDto),HttpStatus.CREATED);
    }

    @GetMapping
    public List<WasteCategory> getAllCategories(){
        return categoryService.findAllCategories();
    }

    @DeleteMapping("/{id}")
    public ResponseObject deleteCategoryById(@PathVariable Long id){
        categoryService.deleteCategory(id);
        return new ResponseObject("Deleted Successfully");
    }

    @PutMapping
    public ResponseEntity<WasteCategory> updateCategory(@Valid @RequestBody UpdateCategoryRequestDto updateCategoryRequestDto){
           return new ResponseEntity<>( this.categoryService.updateCategory(updateCategoryRequestDto), HttpStatus.CREATED);
    }
}

