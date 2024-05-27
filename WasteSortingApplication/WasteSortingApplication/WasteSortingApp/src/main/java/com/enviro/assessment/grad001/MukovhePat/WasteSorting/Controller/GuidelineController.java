package com.enviro.assessment.grad001.MukovhePat.WasteSorting.Controller;

import com.enviro.assessment.grad001.MukovhePat.WasteSorting.Dto.Request.GuidelineRequestDto;
import com.enviro.assessment.grad001.MukovhePat.WasteSorting.Dto.Request.UpdateCategoryRequestDto;
import com.enviro.assessment.grad001.MukovhePat.WasteSorting.Dto.Request.UpdateGuidelineRequestDto;
import com.enviro.assessment.grad001.MukovhePat.WasteSorting.Dto.Response.ResponseObject;
import com.enviro.assessment.grad001.MukovhePat.WasteSorting.Entity.DisposalGuideline;
import com.enviro.assessment.grad001.MukovhePat.WasteSorting.Entity.WasteCategory;
import com.enviro.assessment.grad001.MukovhePat.WasteSorting.Service.Interface.DisposalGuidelineService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/guideline")
public class GuidelineController {

    private final DisposalGuidelineService disposalGuidelineService;

    @PostMapping
    public ResponseEntity<DisposalGuideline> createGuideline(@Valid @RequestBody GuidelineRequestDto guidelineRequestDto){
        return new ResponseEntity<>(this.disposalGuidelineService.createGuideline(guidelineRequestDto),HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DisposalGuideline>> getAllGuidelines(){
        return new ResponseEntity<>(this.disposalGuidelineService.getAllGuidelines(),HttpStatus.OK);
    }

    @GetMapping("/{categoryName}")
    public ResponseEntity<List<DisposalGuideline>> getGuidelinesByName(@PathVariable String categoryName){
        return new ResponseEntity<>(this.disposalGuidelineService.getAllGuidelineByName(categoryName),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseObject deleteGuidelineById(@PathVariable Long id){
        this.disposalGuidelineService.deleteDisposalGuideline(id);
        return new ResponseObject("Deleted Successfully");
    }

    @PutMapping
    public ResponseEntity<DisposalGuideline> updateGuideline(@Valid @RequestBody UpdateGuidelineRequestDto updateCategoryRequestDto){
        return new ResponseEntity<>( this.disposalGuidelineService.updateGuideline(updateCategoryRequestDto), HttpStatus.CREATED);
    }
}
