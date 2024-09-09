package br.com.fiap.cgenius.domain.dto;

import br.com.fiap.cgenius.domain.model.Atendente;
import br.com.fiap.cgenius.domain.model.Cliente;
import br.com.fiap.cgenius.domain.model.Plano;
import br.com.fiap.cgenius.domain.model.Script;
import br.com.fiap.cgenius.domain.model.Venda;

public record VendaRequest(
    Long atendente,
    Long cliente,
    Long script,
    Long plano
) {
    public Venda toModel(){
        return Venda.builder()    
            .atendente(Atendente.builder().id(atendente).build())
            .cliente(Cliente.builder().id(cliente).build())
            .script(Script.builder().id(script).build())
            .plano(Plano.builder().id(plano).build())
            .build();
    }

}
