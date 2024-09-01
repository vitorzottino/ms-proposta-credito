package com.github.vitorzottino.ms_proposta_credito.exception;

public class PropostaNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public PropostaNotFoundException(Long id){
        super("Proposta not found with id " + id);
    }
}
