package br.com.dianome.entregadores.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EntregadorDTO(
        @NotBlank String nome,
        @NotBlank String cpf,
        @NotNull int carga) {

}
