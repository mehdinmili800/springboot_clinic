package com.mehdi.springboot_clinic.dto.saveDTO;

import lombok.Data;

@Data
public class AppointmentSaveDTO {

    private Long petId;
    private Long doctorId;
    private Long clientId;
    private String startTime;
    private String finishTime;

}
