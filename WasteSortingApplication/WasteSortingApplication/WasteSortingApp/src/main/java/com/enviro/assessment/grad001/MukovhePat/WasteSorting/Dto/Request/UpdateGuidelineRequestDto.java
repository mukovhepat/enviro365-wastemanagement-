package com.enviro.assessment.grad001.MukovhePat.WasteSorting.Dto.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateGuidelineRequestDto {
    @Positive(message = "ID must be a positive number")
    private Long id;
    @NotBlank(message = "Guideline is required")
    private String guideline;
}
