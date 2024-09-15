package br.com.fiap.cgenius.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fiap.cgenius.domain.model.Atendente;

public interface AtendenteRepository extends JpaRepository<Atendente, Long>{
    Atendente findByCpf(String cpf);
<<<<<<< HEAD:src/main/java/br/com/fiap/cgenius/domain/repository/AtendenteRepository.java
=======
    
    @Query("SELECT a FROM Atendente a WHERE a.cpf = :cpf and a.senha = :senha")
    Atendente login(String cpf, String senha);
    
>>>>>>> main:src/main/java/br/com/fiap/cgenius/repository/AtendenteRepository.java
    void deleteByCpf(String cpf);

}
