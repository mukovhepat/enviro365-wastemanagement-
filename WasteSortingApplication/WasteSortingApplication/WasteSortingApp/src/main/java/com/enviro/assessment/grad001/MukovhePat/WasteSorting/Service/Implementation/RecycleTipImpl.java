package com.enviro.assessment.grad001.MukovhePat.WasteSorting.Service.Implementation;

import com.enviro.assessment.grad001.MukovhePat.WasteSorting.Dto.Request.RecycleTipRequestDto;
import com.enviro.assessment.grad001.MukovhePat.WasteSorting.Dto.Request.UpdateRecycleTipRequestDto;
import com.enviro.assessment.grad001.MukovhePat.WasteSorting.Entity.RecyclingTip;
import com.enviro.assessment.grad001.MukovhePat.WasteSorting.Exception.*;
import com.enviro.assessment.grad001.MukovhePat.WasteSorting.Repository.RecycleTipsRepo;
import com.enviro.assessment.grad001.MukovhePat.WasteSorting.Service.Interface.RecycleTipService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecycleTipImpl implements RecycleTipService {

    private final RecycleTipsRepo recycleTipsRepo;

    @Override
    public RecyclingTip createRecycleTip(RecycleTipRequestDto recycleTipRequestDto) {

         RecyclingTip recyclingTip = RecyclingTip.builder()
                 .tip(recycleTipRequestDto.getTip())
                 .author(recycleTipRequestDto.getAuthor())
                 .build();

         return recycleTipsRepo.save(recyclingTip);
    }

    @Override
    public List<RecyclingTip> getAllRecycleTip() {
        if(recycleTipsRepo.findAll().isEmpty()){
            throw new RecycleTipNotFoundException("There are no Recycle Tips");
        }
        return recycleTipsRepo.findAll();
    }

    @Override
    public RecyclingTip getTipById(Long id) {
        if(recycleTipsRepo.findById(id).isEmpty()) {
            throw new RecycleTipNotFoundException("Recycle Tip not Found");
        }else{
            return recycleTipsRepo.findById(id).orElseThrow();
        }
    }

    @Override
    public void deleteRecycleTip(Long id) {
        Optional<RecyclingTip> optionalRecyclingTip = this.recycleTipsRepo.findById(id);

        if(optionalRecyclingTip.isPresent()){
            this.recycleTipsRepo.deleteById(id);
        }else{
            throw new RecycleTipToDeleteNotFound("Delete Unsuccessful");
        }
    }

    @Override
    public RecyclingTip updateRecycleTip(UpdateRecycleTipRequestDto updateRecycleTipRequestDto) {
        Optional<RecyclingTip> optionalRecyclingTip = this.recycleTipsRepo.findById(updateRecycleTipRequestDto.getId());

        if (optionalRecyclingTip.isPresent()) {
            RecyclingTip existingRecycleTip = optionalRecyclingTip.get();
            existingRecycleTip.setTip(updateRecycleTipRequestDto.getTip());
            existingRecycleTip.setAuthor(updateRecycleTipRequestDto.getAuthor());

            return this.recycleTipsRepo.save(existingRecycleTip);
        } else {
            throw new RecycleTipUpdateException("Update failed !");
        }
    }


}
