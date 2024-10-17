package com.cezila.ecommerce.dto;

import jakarta.validation.constraints.NotBlank;

public record EnderecoDTO(
        @NotBlank String logradouro,
        @NotBlank String numero,
        @NotBlank String complemento
) {
}
