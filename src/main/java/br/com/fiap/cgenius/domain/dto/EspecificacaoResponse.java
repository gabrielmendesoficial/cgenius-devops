package br.com.fiap.cgenius.domain.dto;

import java.math.BigDecimal;

import br.com.fiap.cgenius.domain.model.Especificacao;

public record EspecificacaoResponse(
    Long id,
    String tipoCartaoCredito,
    BigDecimal gastoMensal,
    BigDecimal rendaMensal,
    Integer viajaFrequentemente,
    String interesses,
    String profissao,
    Integer dependentes,
    Long clienteId
) {
    public static EspecificacaoResponse from(Especificacao especificacao) {
        return new EspecificacaoResponse(
            especificacao.getId(),
            especificacao.getTipoCartaoCredito(),
            especificacao.getGastoMensal(),
            especificacao.getRendaMensal(),
            especificacao.getViajaFrequentemente(),
            especificacao.getInteresses(),
            especificacao.getProfissao(),
            especificacao.getDependentes(),
            especificacao.getCliente().getId()
        );
    }
}
