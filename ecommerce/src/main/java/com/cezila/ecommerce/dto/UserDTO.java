package com.cezila.ecommerce.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record UserDTO(
        @NotBlank String nome,
        @NotBlank String sobrenome,
        @NotBlank String email,
        List<EnderecoDTO> enderecoDTOList
) {
}
