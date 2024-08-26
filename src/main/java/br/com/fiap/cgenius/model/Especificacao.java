package br.com.fiap.cgenius.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "especificacao")
public class Especificacao {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Campo obrigatório")
    private String tipoCartaoCredito;

    @PositiveOrZero(message = "O valor do produto deve ser positivo")
    private BigDecimal gastoMensal;

    @PositiveOrZero(message = "O valor do produto deve ser positivo")
    private BigDecimal rendaMensal;

    @NotBlank(message = "Campo obrigatório")
    private String viajaFrequentemente;

    @NotBlank(message = "Campo obrigatório")
    private String interesses;

    @NotBlank(message = "Campo obrigatório")
    private String profissao;

    @NotBlank(message = "Campo obrigatório")
    private Integer dependentes;

    @OneToOne
    private Cliente cliente;
}
