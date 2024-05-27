package com.enviro.assessment.grad001.MukovhePat.WasteSorting.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name="Guidelines")
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class DisposalGuideline {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String guideline;

    //Many DisposalGuidelines can belong to one WasteCategory
    @ManyToOne
    @JsonIgnore
    private WasteCategory category;

}
