package br.com.fiap.cgenius.domain.dto;

import br.com.fiap.cgenius.domain.model.Atendente;
import br.com.fiap.cgenius.domain.service.AtendenteService;

public record AtendenteUpdate(
    String nome,
    String setor,
    String senha,
    String perfil
) {
    public static Atendente toModel(Long atendenteId, AtendenteUpdate atendenteUpdate) {
        AtendenteService atendenteService = new AtendenteService();
        Atendente atendente = atendenteService.findById(atendenteId);
        atendente.setNome(atendenteUpdate.nome());
        atendente.setSetor(atendenteUpdate.setor());
        atendente.setSenha(atendenteUpdate.senha());
        atendente.setPerfil(atendenteUpdate.perfil());
        return atendente;
    }

}
