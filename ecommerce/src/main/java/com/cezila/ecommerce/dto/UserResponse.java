package com.cezila.ecommerce.dto;

import java.util.List;

public class UserResponse {

    private String nome;
    private String sobrenome;
    private List<EnderecoResponse> enderecoDTOList;

    public UserResponse(String nome, String sobrenome, List<EnderecoResponse> enderecoDTOList) {

    }

    public UserResponse() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public List<EnderecoResponse> getEnderecoDTOList() {
        return enderecoDTOList;
    }

    public void setEnderecoDTOList(List<EnderecoResponse> enderecoDTOList) {
        this.enderecoDTOList = enderecoDTOList;
    }
}
