package br.com.fiap.cgenius.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.cgenius.domain.model.Atendente;
import br.com.fiap.cgenius.domain.repository.AtendenteRepository;

@Service
public class AtendenteService {

    @Autowired
    AtendenteRepository atendenteRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Atendente> findAll() {
        return atendenteRepository.findAll();
    }

    public Atendente create(Atendente atendente) {
        if (atendenteRepository.findByCpf(atendente.getCpf()) == null) {
            atendente.setSenha(passwordEncoder.encode(atendente.getSenha()));
            return atendenteRepository.save(atendente);
        }else {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Atendente já cadastrado");
        }
    }

    public Atendente findById(Long id) {
        return atendenteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não encontrado atendente com o id: " + id));
    }

    public Atendente findByCpf(String cpf_atendente){
        Atendente atendente = atendenteRepository.findByCpf(cpf_atendente);
        if (atendente != null) {
            return atendente;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Atendente não encontrado");
        }
    }

<<<<<<< HEAD:src/main/java/br/com/fiap/cgenius/domain/service/AtendenteService.java
    public Atendente update(Atendente atendente) {
        atendente.setSenha(passwordEncoder.encode(atendente.getSenha()));
        return atendenteRepository.save(atendente);
=======
    public Atendente login(String cpf, String senha) {
        return atendenteRepository.login(cpf, senha);
    }

    public Atendente update(Long id, Atendente atendente) {
        Atendente a = findById(id);
        a.setNome(atendente.getNome());
        a.setCpf(atendente.getCpf());
        a.setSetor(atendente.getSetor());
        a.setSenha(atendente.getSenha());
        a.setPerfil(atendente.getPerfil());
        return atendenteRepository.save(a);
    }

    public Atendente update(String cpf_atendente, Atendente atendente){
        Atendente a = verificarCpf(cpf_atendente);
        a.setNome(atendente.getNome());
        a.setCpf(atendente.getCpf());
        a.setSetor(atendente.getSetor());
        a.setSenha(atendente.getSenha());
        a.setPerfil(atendente.getPerfil());
        return atendenteRepository.save(a);
>>>>>>> main:src/main/java/br/com/fiap/cgenius/service/AtendenteService.java
    }

    public void delete(Long id) {
        verificarExistencia(id);
        atendenteRepository.deleteById(id);
    }

    public void deleteByCpf(String cpf){
        verificarCpf(cpf);
        atendenteRepository.deleteByCpf(cpf);
    }

    public void verificarExistencia(Long id){
        atendenteRepository.
        findById(id)
        .orElseThrow(
            ()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "id não encontrado")
        );
    }

    private Atendente verificarCpf(String cpf_atendente){
        Atendente atendente = atendenteRepository.findByCpf(cpf_atendente);
    if (atendente == null) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Atendente não encontrado");
    }else{
        return atendente;
    }
}
}
