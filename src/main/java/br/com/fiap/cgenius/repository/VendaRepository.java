package br.com.fiap.cgenius.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import br.com.fiap.cgenius.model.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long> {
    List<Venda> findByCpfAtendente(String cpfAtendente);
    List<Venda> findByCpfCliente(String cpfCliente);
    Venda findByIdScript(Long idScript);
    List<Venda> findByIdPlano(Long idPlano);

}
