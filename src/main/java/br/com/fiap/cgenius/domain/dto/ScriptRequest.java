package br.com.fiap.cgenius.domain.dto;

import br.com.fiap.cgenius.domain.model.Plano;
import br.com.fiap.cgenius.domain.model.Script;

public record ScriptRequest(
    String descricaoScript,
    Long planoId
) {
    public Script toModel() {
        return Script.builder()
            .descricaoScript(descricaoScript)
            .plano(Plano.builder().id(planoId).build())
            .build();
    }

}
