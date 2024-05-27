package com.enviro.assessment.grad001.MukovhePat.WasteSorting.Service.Interface;

import com.enviro.assessment.grad001.MukovhePat.WasteSorting.Dto.Request.CategoryRequestDto;
import com.enviro.assessment.grad001.MukovhePat.WasteSorting.Dto.Request.UpdateCategoryRequestDto;
import com.enviro.assessment.grad001.MukovhePat.WasteSorting.Dto.Response.ResponseObject;
import com.enviro.assessment.grad001.MukovhePat.WasteSorting.Entity.WasteCategory;

import java.util.List;

public interface CategoryService {
    public WasteCategory CreateCategory(CategoryRequestDto categoryRequestDto);
    public List<WasteCategory> findAllCategories();
    public void deleteCategory(Long id);
    public WasteCategory updateCategory(UpdateCategoryRequestDto updateCategoryRequestDto) ;
}
