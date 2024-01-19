package com.mehdi.springboot_clinic.dto.entityDTO;


import com.mehdi.springboot_clinic.entity.Client;
import com.mehdi.springboot_clinic.entity.Doctor;
import com.mehdi.springboot_clinic.entity.Pet;
import lombok.Data;

import java.util.Date;

@Data
public class AppointmentDTO {

    private long id;
    private Client client;
    private Pet pet;
    private Doctor doctor;
    private Date startTime;
    private Date finishTime;

}
