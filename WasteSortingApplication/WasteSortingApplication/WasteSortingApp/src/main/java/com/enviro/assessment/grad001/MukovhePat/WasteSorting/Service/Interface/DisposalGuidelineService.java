package com.enviro.assessment.grad001.MukovhePat.WasteSorting.Service.Interface;

import com.enviro.assessment.grad001.MukovhePat.WasteSorting.Dto.Request.GuidelineRequestDto;
import com.enviro.assessment.grad001.MukovhePat.WasteSorting.Dto.Request.UpdateGuidelineRequestDto;
import com.enviro.assessment.grad001.MukovhePat.WasteSorting.Entity.DisposalGuideline;

import java.util.List;

public interface DisposalGuidelineService {

    public DisposalGuideline createGuideline(GuidelineRequestDto guidelineRequestDto);
    public List<DisposalGuideline> getAllGuidelineByName(String categoryName);
    public List<DisposalGuideline> getAllGuidelines();
    public void deleteDisposalGuideline(Long id);
    public DisposalGuideline updateGuideline(UpdateGuidelineRequestDto updateCategoryRequestDto);
}
