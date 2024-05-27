package com.enviro.assessment.grad001.MukovhePat.WasteSorting.Service.Implementation;

import com.enviro.assessment.grad001.MukovhePat.WasteSorting.Dto.Request.CategoryRequestDto;
import com.enviro.assessment.grad001.MukovhePat.WasteSorting.Dto.Request.UpdateCategoryRequestDto;
import com.enviro.assessment.grad001.MukovhePat.WasteSorting.Dto.Response.ResponseObject;
import com.enviro.assessment.grad001.MukovhePat.WasteSorting.Entity.WasteCategory;
import com.enviro.assessment.grad001.MukovhePat.WasteSorting.Exception.CategoryExistsException;
import com.enviro.assessment.grad001.MukovhePat.WasteSorting.Exception.CategoryNotFoundException;
import com.enviro.assessment.grad001.MukovhePat.WasteSorting.Exception.CategoryToDeleteNotFound;
import com.enviro.assessment.grad001.MukovhePat.WasteSorting.Repository.WasteCategoryRepo;
import com.enviro.assessment.grad001.MukovhePat.WasteSorting.Service.Interface.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryImpl implements CategoryService {

    private final WasteCategoryRepo wasteCategoryRepo;

    @Override
    public WasteCategory CreateCategory(CategoryRequestDto categoryRequestDto){
        if(this.wasteCategoryRepo.findByCategoryName(categoryRequestDto.getCategoryName()).isPresent()) {
          throw new CategoryExistsException("Category already exists");
        }
        WasteCategory wasteCategory = WasteCategory.builder()
                .categoryName(categoryRequestDto.getCategoryName())
                .composition(categoryRequestDto.getComposition())
                .health_Risks(categoryRequestDto.getHealth_Risks())
                .build();

        return this.wasteCategoryRepo.save(wasteCategory);
    }
    @Override
    public List<WasteCategory> findAllCategories(){
      return this.wasteCategoryRepo.findAll();
    }

    @Override
    public void deleteCategory(Long id) {
        Optional<WasteCategory> optionalCategory = this.wasteCategoryRepo.findById(id);

        if(optionalCategory.isPresent()){
            this.wasteCategoryRepo.deleteById(id);
        }else{
            throw new CategoryToDeleteNotFound("Delete Unsuccessful !");
        }
    }

    @Override
    public WasteCategory updateCategory(UpdateCategoryRequestDto updateCategoryRequestDto) {
        Optional<WasteCategory> optionalCategory = this.wasteCategoryRepo.findById(updateCategoryRequestDto.getId());

        if (optionalCategory.isPresent()) {
            WasteCategory existingCategory = optionalCategory.get();
            existingCategory.setCategoryName(updateCategoryRequestDto.getCategoryName());
            existingCategory.setComposition(updateCategoryRequestDto.getComposition());
            existingCategory.setHealth_Risks(updateCategoryRequestDto.getHealth_Risks());

            return this.wasteCategoryRepo.save(existingCategory);
        } else {
            throw new CategoryNotFoundException("Update failed !");
        }
    }


}
