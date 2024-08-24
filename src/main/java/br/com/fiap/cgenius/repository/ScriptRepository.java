package br.com.fiap.cgenius.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.cgenius.model.Script;

public interface ScriptRepository extends JpaRepository<Script, Long> {


}
