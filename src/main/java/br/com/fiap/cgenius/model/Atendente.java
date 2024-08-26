package br.com.fiap.cgenius.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "atendente")
public class Atendente {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Campo obrigatório")
    private String nome;

    @NotBlank(message = "Campo obrigatório")
    @Size(min=11,  message = "CPF Inválido")
    private String cpf;

    @NotBlank(message = "Campo obrigatório")
    private String setor;

    @NotBlank(message = "Campo obrigatório")    
    @Size(min = 6, message = "Mínimo de 6 caracteres")
    private String senha;

    @NotBlank(message = "Campo obrigatório")
    private String perfil;   
}