package br.com.fiap.cgenius.domain.dto;

import br.com.fiap.cgenius.domain.model.Venda;

public record VendaResponse(
    Long id,
    Long atendenteId,
    Long clienteId,
    Long scriptId,
    Long planoId
) {
    public static VendaResponse from(Venda venda) {
        return new VendaResponse(
            venda.getId(),
            venda.getAtendente().getId(),
            venda.getCliente().getId(),
            venda.getScript().getId(),
            venda.getPlano().getId()
        );
    }

}
