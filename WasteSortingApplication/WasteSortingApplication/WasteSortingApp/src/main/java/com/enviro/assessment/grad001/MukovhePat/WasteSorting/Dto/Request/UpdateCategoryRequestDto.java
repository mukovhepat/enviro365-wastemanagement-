package com.enviro.assessment.grad001.MukovhePat.WasteSorting.Dto.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCategoryRequestDto {
        @Positive(message = "ID must be a positive number")
        private Long id;
        @NotBlank(message = "Name is required")
        private String categoryName;
        private String composition;
        private String health_Risks;
}
