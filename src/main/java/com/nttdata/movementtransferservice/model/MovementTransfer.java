package com.nttdata.movementtransferservice.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document
public class MovementTransfer {
    @Id
    private String id;
    private Double amount;
    private MovementTransferType typeTransfer;
    private String idAccountOrigin;
    private String idAccountDestination;
    private LocalDate date;
    private String description;
}
