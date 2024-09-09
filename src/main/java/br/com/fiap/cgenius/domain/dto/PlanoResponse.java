package br.com.fiap.cgenius.domain.dto;

import java.math.BigDecimal;

import br.com.fiap.cgenius.domain.model.Plano;

public record PlanoResponse(
    Long id,
    String nomePlano,
    String descricaoPlano,
    BigDecimal valorPlano
) {
    public static PlanoResponse from(Plano plano) {
        return new PlanoResponse(
            plano.getId(),
            plano.getNomePlano(),
            plano.getDescricaoPlano(),
            plano.getValorPlano()
        );
    }

}
