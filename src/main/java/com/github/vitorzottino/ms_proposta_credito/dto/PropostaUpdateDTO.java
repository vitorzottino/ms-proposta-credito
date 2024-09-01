package com.github.vitorzottino.ms_proposta_credito.dto;


import com.github.vitorzottino.ms_proposta_credito.model.Proposta;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PropostaUpdateDTO {

    @NotNull(message = "Campo obrigatório")
    @Positive(message = "O valor deve ser positivo")
    private BigDecimal valorSolicitado;

    @NotNull(message = "Campo obrigatório")
    private Integer prazoParaPagamento;

    @NotNull(message = "Campo obrigatório")
    private Boolean aprovado;

    public PropostaUpdateDTO(Proposta proposta) {
        this.valorSolicitado = proposta.getValorSolicitado();
        this.prazoParaPagamento = proposta.getPrazoParaPagamento();
        this.aprovado = proposta.getAprovado();
    }
}
