package com.github.vitorzottino.ms_proposta_credito.dto;

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
public class UserDTO {

    private Long id;

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

    public UserDTO(User user) {
        this.id = user.getId();
        this.nome = user.getNome();
        this.sobrenome = user.getSobrenome();
        this.cpf = user.getCpf();
        this.telefone = user.getTelefone();
        this.renda = user.getRenda();
    }
}
