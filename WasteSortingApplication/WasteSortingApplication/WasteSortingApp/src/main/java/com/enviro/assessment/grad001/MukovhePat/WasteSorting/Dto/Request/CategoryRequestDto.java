package com.enviro.assessment.grad001.MukovhePat.WasteSorting.Dto.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryRequestDto {
    @NotBlank(message = "Name is required")
    private String categoryName;
    private String composition;
    private String health_Risks;
}
