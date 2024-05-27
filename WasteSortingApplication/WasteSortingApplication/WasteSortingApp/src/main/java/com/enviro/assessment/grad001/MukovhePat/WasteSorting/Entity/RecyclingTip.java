package com.enviro.assessment.grad001.MukovhePat.WasteSorting.Entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name="RecycleTips")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Builder
public class RecyclingTip {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String tip;
    private String author;
}
