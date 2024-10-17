package com.cezila.ecommerce.dto;

import jakarta.validation.constraints.NotBlank;

public record EnderecoResponse(
        @NotBlank String id
) {
}
