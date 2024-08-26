package br.com.fiap.cgenius.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fiap.cgenius.model.Especificacao;

public interface EspecificacaoRepository extends JpaRepository<Especificacao, Long> {
    @Query("SELECT e FROM Especificacao e WHERE e.cliente.cpf = :cpf")
    Especificacao findByCpfCliente(String cpf);

    @Query("SELECT e FROM Especificacao e WHERE e.cliente.id = :id")
    Especificacao findByIdCliente(Long id);

    @Query("SELECT e FROM Especificacao e WHERE e.cliente.cpf = :cpf")
    void deleteByCpfCliente(String cpf);

    @Query("SELECT e FROM Especificacao e WHERE e.cliente.id = :id")
    void deleteByIdCliente(Long id);

}
