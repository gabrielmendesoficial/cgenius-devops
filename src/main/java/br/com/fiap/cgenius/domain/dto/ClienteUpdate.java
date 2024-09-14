package br.com.fiap.cgenius.domain.dto;

import java.time.LocalDate;

import br.com.fiap.cgenius.domain.model.Cliente;
import br.com.fiap.cgenius.domain.service.ClienteService;

public record ClienteUpdate(
    String nome,
    String telefone,
    String cep,
    String email,
    LocalDate dtNascimento
) {
    public static Cliente toModel(Long clienteId, ClienteUpdate clienteUpdate) {
        ClienteService clienteService = new ClienteService();
        Cliente cliente = clienteService.findById(clienteId);
        cliente.setNome(clienteUpdate.nome());
        cliente.setTelefone(clienteUpdate.telefone());
        cliente.setCep(clienteUpdate.cep());
        cliente.setEmail(clienteUpdate.email());
        cliente.setDtNascimento(clienteUpdate.dtNascimento());
        return cliente;
    }
}
