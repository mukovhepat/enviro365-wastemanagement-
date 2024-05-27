package com.enviro.assessment.grad001.MukovhePat.WasteSorting.Dto.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRecycleTipRequestDto {
    @Positive(message = "ID must be a positive number")
    private Long id;
    @NotBlank(message = "Tip is required")
    private String tip;
    private String author;
}
