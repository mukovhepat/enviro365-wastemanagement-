package com.enviro.assessment.grad001.MukovhePat.WasteSorting.Service.Interface;

import com.enviro.assessment.grad001.MukovhePat.WasteSorting.Dto.Request.RecycleTipRequestDto;
import com.enviro.assessment.grad001.MukovhePat.WasteSorting.Dto.Request.UpdateRecycleTipRequestDto;
import com.enviro.assessment.grad001.MukovhePat.WasteSorting.Entity.RecyclingTip;

import java.util.List;

public interface RecycleTipService {

    public RecyclingTip createRecycleTip(RecycleTipRequestDto recycleTipRequestDto);
    public List<RecyclingTip> getAllRecycleTip();
    public RecyclingTip getTipById(Long id);
    public void deleteRecycleTip(Long id);
    public RecyclingTip updateRecycleTip(UpdateRecycleTipRequestDto updateRecycleTipRequestDto);
}
