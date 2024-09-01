package com.github.vitorzottino.ms_proposta_credito.dto;

import com.github.vitorzottino.ms_proposta_credito.model.Proposta;
import com.github.vitorzottino.ms_proposta_credito.model.User;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class FormDataDTO {
    @NotNull(message = "Campo obrigatório")
    private String nome;
    @NotNull(message = "Campo obrigatório")
    private String sobrenome;
    @NotNull(message = "Campo obrigatório")
    private String cpf;
    @NotNull(message = "Campo obrigatório")
    private String telefone;
    @NotNull(message = "Campo obrigatório")
    @Positive(message = "O valor deve ser positivo")
    private BigDecimal renda;
    @NotNull(message = "Campo obrigatório")
    private BigDecimal valorSolicitado;
    @NotNull(message = "Campo obrigatório")
    private Integer prazoParaPagamento;
    private boolean aprovado = false;


    public FormDataDTO(Proposta proposta, User user) {
        this.nome = user.getNome();
        this.sobrenome = user.getSobrenome();
        this.cpf = user.getCpf();
        this.telefone = user.getTelefone();
        this.renda = user.getRenda();
        this.valorSolicitado = proposta.getValorSolicitado();
        this.prazoParaPagamento = proposta.getPrazoParaPagamento();
        this.aprovado = proposta.getAprovado();

    }
}
