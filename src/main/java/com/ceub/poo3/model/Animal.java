package com.ceub.poo3.model;

import com.ceub.poo3.enums.StatusEnum;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "animais")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private String tipo;

    private Integer idade;

    private String raca;

    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    private String descricao;
}
