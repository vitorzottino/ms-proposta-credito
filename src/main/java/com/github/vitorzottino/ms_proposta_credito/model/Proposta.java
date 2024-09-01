package com.github.vitorzottino.ms_proposta_credito.model;


import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_proposta")
public class Proposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private BigDecimal valorSolicitado;

    @Column(nullable = false)
    private Integer prazoParaPagamento;

    private Boolean aprovado = false;

    @Column(nullable = false, name = "user_id")
    private Long userId;
}
