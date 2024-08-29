package br.com.fiap.cgenius.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.cgenius.model.Atendente;

public interface AtendenteRepository extends JpaRepository<Atendente, Long>{
    Atendente findByCpf(String cpf);

    void deleteByCpf(String cpf);

}
