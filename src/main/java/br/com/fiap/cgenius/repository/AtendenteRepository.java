package br.com.fiap.cgenius.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fiap.cgenius.model.Atendente;

public interface AtendenteRepository extends JpaRepository<Atendente, Long>{
    Atendente findByCpf(String cpf);
    
    @Query("SELECT a FROM Atendente a WHERE a.cpf = :cpf and a.senha = :senha")
    Atendente login(String cpf, String senha);
    
    void deleteByCpf(String cpf);

}
