package br.com.fiap.cgenius.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.cgenius.model.Atendente;
import br.com.fiap.cgenius.model.Cliente;
import br.com.fiap.cgenius.model.Plano;
import br.com.fiap.cgenius.model.Script;
import br.com.fiap.cgenius.model.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long> {
    List<Venda> findByCpfAtendente(Atendente cpfAtendente);
    List<Venda> findByCpfCliente(Cliente cpfCliente);
    List<Venda> findByIdScript(Script idScript);
    List<Venda> findByIdPlano(Plano idPlano);

}
