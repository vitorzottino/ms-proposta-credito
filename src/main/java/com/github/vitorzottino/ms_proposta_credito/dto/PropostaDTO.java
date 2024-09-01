package com.github.vitorzottino.ms_proposta_credito.dto;

import com.github.vitorzottino.ms_proposta_credito.model.Proposta;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PropostaDTO {

    @NotNull(message = "Campo obrigatório")
    private Long id;
    @NotNull(message = "Campo obrigatório")
    private BigDecimal valorSolicitado;
    @NotNull(message = "Campo obrigatório")
    private Integer prazoParaPagamento;
    private boolean apovado = false;
    @NotNull(message = "Campo obrigatório")
    private Long userId;

    public PropostaDTO(Proposta proposta) {
        this.id = proposta.getId();
        this.valorSolicitado = proposta.getValorSolicitado();
        this.prazoParaPagamento = proposta.getPrazoParaPagamento();
    }
}
