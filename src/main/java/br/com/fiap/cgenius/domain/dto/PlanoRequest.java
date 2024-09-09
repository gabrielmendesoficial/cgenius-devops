package br.com.fiap.cgenius.domain.dto;

import java.math.BigDecimal;

import br.com.fiap.cgenius.domain.model.Plano;

public record PlanoRequest(
    String nomePlano,
    String descricaoPlano,
    BigDecimal valorPlano
) {
    public Plano toModel() {
        return Plano.builder()
            .nomePlano(nomePlano)
            .descricaoPlano(descricaoPlano)
            .valorPlano(valorPlano)
            .build();
    }

}
