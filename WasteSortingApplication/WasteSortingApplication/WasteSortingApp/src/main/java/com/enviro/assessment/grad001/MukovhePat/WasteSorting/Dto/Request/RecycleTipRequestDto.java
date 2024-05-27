package com.enviro.assessment.grad001.MukovhePat.WasteSorting.Dto.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecycleTipRequestDto {
    @NotBlank(message = "Tip is required")
    private String tip;
    private String author;
}
