package br.com.fiap.cgenius.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.cgenius.model.Especificacao;

public interface EspecificacaoRepository extends JpaRepository<Especificacao, Long> {
    Especificacao findByCpf(String cpf);
    void deleteByCpf(String cpf);

}
