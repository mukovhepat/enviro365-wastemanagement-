package com.enviro.assessment.grad001.MukovhePat.WasteSorting.Controller;

import com.enviro.assessment.grad001.MukovhePat.WasteSorting.Dto.Request.RecycleTipRequestDto;
import com.enviro.assessment.grad001.MukovhePat.WasteSorting.Dto.Request.UpdateRecycleTipRequestDto;
import com.enviro.assessment.grad001.MukovhePat.WasteSorting.Dto.Response.ResponseObject;
import com.enviro.assessment.grad001.MukovhePat.WasteSorting.Entity.RecyclingTip;
import com.enviro.assessment.grad001.MukovhePat.WasteSorting.Service.Interface.RecycleTipService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/recycleTip")
@RequiredArgsConstructor
public class RecycleTipController {

    private final RecycleTipService recycleTipService;

    @PostMapping
    public ResponseEntity<RecyclingTip> createRecycleTip(@Valid @RequestBody RecycleTipRequestDto recycleTipRequestDto){
        return new ResponseEntity<>(this.recycleTipService.createRecycleTip(recycleTipRequestDto), HttpStatus.CREATED) ;
    }

    @GetMapping
    public ResponseEntity<List<RecyclingTip>> getAllRecycleTip(){
        return new ResponseEntity<>(this.recycleTipService.getAllRecycleTip(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecyclingTip> getRecycleTipById(@PathVariable Long id){
        return new ResponseEntity<>(this.recycleTipService.getTipById(id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseObject deleteRecycleTipById(@PathVariable Long id){
        this.recycleTipService.deleteRecycleTip(id);
        return new ResponseObject("Deleted Successfully");
    }

    @PutMapping
    public ResponseEntity<RecyclingTip> updateGuideline(@Valid @RequestBody UpdateRecycleTipRequestDto updateRecycleTipRequestDto){
        return new ResponseEntity<>( this.recycleTipService.updateRecycleTip(updateRecycleTipRequestDto), HttpStatus.CREATED);
    }
}
