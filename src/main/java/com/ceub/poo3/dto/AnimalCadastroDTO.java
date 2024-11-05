package com.ceub.poo3.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AnimalCadastroDTO(@NotBlank String nome,
                                @NotBlank String tipo,
                                @NotNull Integer idade,
                                @NotBlank String raca,
                                @NotBlank String descricao) {
}
