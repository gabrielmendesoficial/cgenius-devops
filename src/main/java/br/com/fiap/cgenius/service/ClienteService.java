package br.com.fiap.cgenius.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.cgenius.model.Cliente;
import br.com.fiap.cgenius.repository.ClienteRepository;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;

    public List<Cliente> findAll(){
        return clienteRepository.findAll();
    }

    public Cliente create(Cliente cliente){
        if (clienteRepository.findByCpf(cliente.getCpf()) == null){
            return clienteRepository.save(cliente);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente já cadastrado");
        }
        
    }

    public Cliente findById(Long id){
        return clienteRepository
        .findById(id)
        .orElseThrow(() -> new RuntimeException("Não encontrado cliente com o id: " + id));
    }

    public Cliente findByCpf(String cpfCliente){
        Cliente cliente = clienteRepository.findByCpf(cpfCliente);
    if (cliente != null) {
        return cliente;
    } else {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado");
    }
    }

    public void deleteById(Long id){
        verificarId(id);
        clienteRepository.deleteById(id);
    }

    public void deleteByCpf(String cpfCliente){
        verificarCpf(cpfCliente);
        clienteRepository.deleteByCpf(cpfCliente);
    }

    public Cliente update(Long id, Cliente cliente){
        verificarId(id);
        cliente.setId(id);
        return clienteRepository.save(cliente);
    }

    public Cliente updateByCpf(String cpfCliente, Cliente cliente){
        Cliente c = verificarCpf(cpfCliente);
        c.setNome(cliente.getNome());
        c.setCpf(cliente.getCpf());
        c.setDtNascimento(cliente.getDtNascimento());
        c.setGenero(cliente.getGenero());
        c.setCep(cliente.getCep());
        c.setTelefone(cliente.getTelefone());
        c.setEmail(cliente.getEmail());
        c.setPerfil(cliente.getPerfil());
        return clienteRepository.save(c);
}

    private void verificarId(Long id){
        clienteRepository.
        findById(id)
        .orElseThrow(
            ()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "id não encontrado")
        );
    }

    private Cliente verificarCpf(String cpfCliente){
        Cliente cliente = clienteRepository.findByCpf(cpfCliente);
    if (cliente == null) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente com CPF não encontrado");
    }else{
        return cliente;
    }
}
}
