package com.enviro.assessment.grad001.MukovhePat.WasteSorting.Dto.Request;

import com.enviro.assessment.grad001.MukovhePat.WasteSorting.Entity.WasteCategory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GuidelineRequestDto {
    @NotBlank(message = "Guideline is required")
    private String guideline;
    @Positive(message = "ID must be a positive number")
    private Long categoryId;
}
