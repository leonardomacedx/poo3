package com.ceub.poo3.enums;

import lombok.Getter;

@Getter
public enum StatusEnum {

    DISPONIVEL("Disponível"),
    ADOTADO("Adotado"),
    PROCESSO_ADOCAO("Em processo de adoção");

    private final String status;

    StatusEnum(String status) {
        this.status = status;
    }

}
