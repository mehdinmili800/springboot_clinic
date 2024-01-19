package com.mehdi.springboot_clinic.dto.saveDTO;

import lombok.Data;
import org.springframework.lang.Nullable;


@Data
public class FeedbackSaveDTO {
    @Nullable
    /*@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
    @JsonIdentityReference(alwaysAsId=true)*/
    private Long shopId;

    @Nullable
    /*@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
    @JsonIdentityReference(alwaysAsId=true)*/
    private Long doctorId;

//    @NotNull
    private String message;

//    @NotNull
    /*@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
    @JsonIdentityReference(alwaysAsId=true)*/
    private Long clientId;

//    @NotNull
    private String title;
}
