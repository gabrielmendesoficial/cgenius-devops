package br.com.fiap.cgenius.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "plano")
public class Plano {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "nomePlano")
    @NotBlank(message = "Campo Obrigatório")
    private String nomePlano;

    @Column(name = "descricaoPlano")
    @NotBlank(message = "Campo Obrigatório")
    private String descricaoPlano;

    @Column(name = "valorPlano")
    @PositiveOrZero(message = "O valor do produto deve ser positivo")
    private Double valorPlano;
}
