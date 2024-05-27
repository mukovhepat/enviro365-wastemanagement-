package com.enviro.assessment.grad001.MukovhePat.WasteSorting.Service.Implementation;

import com.enviro.assessment.grad001.MukovhePat.WasteSorting.Dto.Request.GuidelineRequestDto;
import com.enviro.assessment.grad001.MukovhePat.WasteSorting.Dto.Request.UpdateGuidelineRequestDto;
import com.enviro.assessment.grad001.MukovhePat.WasteSorting.Entity.DisposalGuideline;
import com.enviro.assessment.grad001.MukovhePat.WasteSorting.Entity.WasteCategory;
import com.enviro.assessment.grad001.MukovhePat.WasteSorting.Exception.*;
import com.enviro.assessment.grad001.MukovhePat.WasteSorting.Repository.DisposalGuidelineRepo;
import com.enviro.assessment.grad001.MukovhePat.WasteSorting.Repository.WasteCategoryRepo;
import com.enviro.assessment.grad001.MukovhePat.WasteSorting.Service.Interface.DisposalGuidelineService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DisposalGuidelineImpl implements DisposalGuidelineService {

    private final DisposalGuidelineRepo disposalGuidelineRepo;
    private final WasteCategoryRepo wasteCategoryRepo;

    @Override
    public DisposalGuideline createGuideline(GuidelineRequestDto guidelineRequestDto) {
        // Retrieve the WasteCategory from the database based on the categoryId
        Optional<WasteCategory> optionalCategory = this.wasteCategoryRepo.findById(guidelineRequestDto.getCategoryId());

        if (optionalCategory.isPresent()) {
            WasteCategory category = optionalCategory.get();

            // Create a new DisposalGuideline entity and associate it with the retrieved WasteCategory
            DisposalGuideline guideline = DisposalGuideline.builder()
                    .guideline(guidelineRequestDto.getGuideline())
                    .category(category)
                    .build();

            return this.disposalGuidelineRepo.save(guideline);
        } else {
            throw new CreateGuidelineException("Could not create Guideline due to invalid Category");
        }
    }

    @Override
    public List<DisposalGuideline> getAllGuidelines() {
        return this.disposalGuidelineRepo.findAll();
    }

    @Override
    public void deleteDisposalGuideline(Long id) {
        Optional<DisposalGuideline> optionalGuideline = this.disposalGuidelineRepo.findById(id);

        if(optionalGuideline.isPresent()){
            this.disposalGuidelineRepo.deleteById(id);
        }else{
            throw new GuidelineToDeleteException("Delete Unsuccessful !");
        }
    }

    @Override
    public DisposalGuideline updateGuideline(UpdateGuidelineRequestDto UpdateGuidelineRequestDto) {
        Optional<DisposalGuideline> optionalGuideline = this.disposalGuidelineRepo.findById(UpdateGuidelineRequestDto.getId());

        if (optionalGuideline.isPresent()) {
            DisposalGuideline existingGuideline = optionalGuideline.get();
            existingGuideline.setId(UpdateGuidelineRequestDto.getId());
            existingGuideline.setGuideline(UpdateGuidelineRequestDto.getGuideline());

            return this.disposalGuidelineRepo.save(existingGuideline);
        } else {
            throw new GuidelineNotFoundException("Update failed !");
        }
    }


    @Override
    public List<DisposalGuideline> getAllGuidelineByName(String categoryName) {
        // Retrieve the WasteCategory by name
        Optional<WasteCategory> optionalWasteCategory = this.wasteCategoryRepo.findByCategoryName(categoryName);

        if (optionalWasteCategory.isPresent()) {
            // Retrieve the disposal guidelines associated with the WasteCategory
            return this.disposalGuidelineRepo.findByCategoryName(categoryName);
        } else {
            // Handle case where WasteCategory with the given name does not exist
            throw new GuidelineByNameException(" Guidelines for'" + categoryName + "' do not exist.");
        }
    }
}
