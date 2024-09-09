package br.com.fiap.cgenius.domain.dto;

import java.math.BigDecimal;

import br.com.fiap.cgenius.domain.model.Cliente;
import br.com.fiap.cgenius.domain.model.Especificacao;

public record EspecificacaoRequest(
    String tipoCartaoCredito,
    BigDecimal gastoMensal,
    BigDecimal rendaMensal,
    Integer viajaFrequentemente,
    String interesses,
    String profissao,
    Integer dependentes,
    Long clienteId
) {
    public Especificacao toModel() {
        return Especificacao.builder()
            .tipoCartaoCredito(tipoCartaoCredito)
            .gastoMensal(gastoMensal)
            .rendaMensal(rendaMensal)
            .viajaFrequentemente(viajaFrequentemente)
            .interesses(interesses)
            .profissao(profissao)
            .dependentes(dependentes)
            .cliente(Cliente.builder().id(clienteId).build())
            .build();
    }

}
