package br.com.fiap.cgenius.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Atendente {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Campo obrigatório")
    private String nomeAtendente;

    @NotBlank(message = "Campo obrigatório")
    @Size(min=11,  message = "CPF Inválido")
    private String cpfAtendente;

    @NotBlank(message = "Campo obrigatório")
    private String setorAtendente;

    @NotBlank(message = "Campo obrigatório")    
    @Size(min = 6, message = "Mínimo de 6 caracteres")
    private String senhaAtendente;

    @NotBlank(message = "Campo obrigatório")
    private String perfilAtendente;   
}