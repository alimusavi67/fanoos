package com.fanoos.models.dto;

import com.fanoos.models.entities.BankEntity;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class BankDto {
    private Long id;
    private String name;

    public BankDto(BankEntity bankEntity) {
        this.id = bankEntity.getId();
        this.name = bankEntity.getName();
    }
}
