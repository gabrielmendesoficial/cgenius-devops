package br.com.fiap.cgenius.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.cgenius.model.Venda;
import br.com.fiap.cgenius.repository.VendaRepository;

@Service
public class VendaService {
    @Autowired
    VendaRepository vendaRepository;

    public List<Venda> findAll(){
        return vendaRepository.findAll();
    }

    public Venda create(Venda venda){
        verificarExistencia(venda.getId());
        return vendaRepository.save(venda);
    }

    public Venda findById(Long id){
        return vendaRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "id não encontrado"));
    }

    public List<Venda> findByCpfAtendente(String cpfAtendente){
        List<Venda> venda = vendaRepository.findByCpfAtendente(cpfAtendente);
        if (venda != null) {
            return venda;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Venda não encontrado");
        }
    }
    public List<Venda> findByCpfCliente(String cpfCliente){
        List<Venda> venda = vendaRepository.findByCpfCliente(cpfCliente);
        if (venda != null) {
            return venda;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Venda não encontrado");
        }
    }
    public Venda findByIdScript(Long id){
        Venda venda = vendaRepository.findByIdScript(id);
        if (venda != null) {
            return venda;
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Venda não encontrado");
        }
    }
    public List<Venda> findByIdPlano(Long id){
        List<Venda> venda = vendaRepository.findByIdPlano(id);
        if (venda != null) {
            return venda;
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Especificacão não encontrado");
        }
    }

    public void delete(Long id){
        verificarExistencia(id);
        vendaRepository.deleteById(id);
    }

    public Venda update(Long id, Venda venda){
        verificarExistencia(id);
        venda.setId(id);
        return vendaRepository.save(venda);
    }

    private void verificarExistencia(Long id){
        vendaRepository.
        findById(id)
        .orElseThrow(
            ()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "id não encontrado")
        );
    }
}
