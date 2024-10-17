package com.cezila.ecommerce.mapper;

import com.cezila.ecommerce.dto.EnderecoDTO;
import com.cezila.ecommerce.dto.EnderecoResponse;
import com.cezila.ecommerce.dto.UserDTO;
import com.cezila.ecommerce.dto.UserResponse;
import com.cezila.ecommerce.model.EnderecoEntity;
import com.cezila.ecommerce.model.UserEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    public static UserEntity toModel(UserDTO userDTO) {
        UserEntity entity = new UserEntity();
        entity.setEmail(userDTO.email());
        entity.setSobrenome(userDTO.sobrenome());
        entity.setNome(userDTO.nome());
        entity.setEnderecos(toModel(userDTO.enderecoDTOList(), entity));
        return entity;
    }

    private static List<EnderecoEntity> toModel(List<EnderecoDTO> enderecoDTOList, UserEntity userEntity) {
        return enderecoDTOList
                .stream()
                .map(enderecoDTO -> {
                    EnderecoEntity enderecoEntity = new EnderecoEntity();
                    enderecoEntity.setLogradouro(enderecoDTO.logradouro());
                    enderecoEntity.setNumero(enderecoDTO.numero());
                    enderecoEntity.setComplemento(enderecoDTO.complemento());
                    enderecoEntity.setUsuario(userEntity);
                    return enderecoEntity;
                })
                .collect(Collectors.toList());
    }

    public static UserResponse toResponse(UserEntity userEntity) {
        List<EnderecoResponse> enderecoResponse = new ArrayList<>();
        userEntity.getEnderecos().forEach(endereco -> enderecoResponse.add(new EnderecoResponse(endereco.getId().toString())));

        return new UserResponse(
                userEntity.getNome(),
                userEntity.getSobrenome(),
                enderecoResponse
        );
    }

}
