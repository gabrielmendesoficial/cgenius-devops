package br.com.fiap.cgenius.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "venda")
public class Venda {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    
    private Atendente cpfAtendente;

    
    private Cliente cpfCliente;

    
    private Script idScript;

    
    private Plano idPlano;
}
