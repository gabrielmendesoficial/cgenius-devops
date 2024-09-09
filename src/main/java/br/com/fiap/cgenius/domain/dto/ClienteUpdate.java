package br.com.fiap.cgenius.domain.dto;

import java.time.LocalDate;

import br.com.fiap.cgenius.domain.model.Cliente;

public record ClienteUpdate(
    String nome,
    String telefone,
    String cep,
    String email,
    LocalDate dtNascimento
) {
    public Cliente toModel(Long clienteId) {
        return Cliente.builder()
            .id(clienteId)
            .nome(nome)
            .telefone(telefone)
            .cep(cep)
            .email(email)
            .dtNascimento(dtNascimento)
            .build();
    }

}
