package br.com.fiap.cgenius.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class Cliente {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotBlank(message = "Campo obrigatório")
    private String nomeCliente;

    @NotBlank(message = "Campo obrigatório")
    @Size(min=11,  message = "CPF Inválido")
    private String cpfCliente;

    @NotNull(message="Campo Obrigatório")
    private Date dtNascimento;

    private String genero;

    @NotBlank(message = "Campo obrigatório")
    @Size(min=8, max=8, message = "Cep Inválido")
    private String cep;

    @NotBlank(message = "Campo obrigatório")
    @Size(min = 9, message = "Telefone Inválido")
    private String telefone;

    @NotBlank(message = "Campo obrigatório")
    @Email(message = "Email inválido")
    private String email;

    @NotBlank(message = "Campo obrigatório")
    private String perfilCliente;
}
