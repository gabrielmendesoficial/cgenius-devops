package br.com.fiap.cgenius.domain.dto;

import br.com.fiap.cgenius.domain.model.Script;

public record ScriptResponse(
    Long id,
    String descricaoScript,
    Long planoId
) {
    public static ScriptResponse from(Script script) {
        return new ScriptResponse(
            script.getId(),
            script.getDescricaoScript(),
            script.getPlano().getId()
        );
    }

}
