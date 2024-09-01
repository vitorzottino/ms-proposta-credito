package com.github.vitorzottino.ms_proposta_credito.service;


import com.github.vitorzottino.ms_proposta_credito.dto.FormDataDTO;
import com.github.vitorzottino.ms_proposta_credito.dto.PropostaDTO;
import com.github.vitorzottino.ms_proposta_credito.dto.PropostaUpdateDTO;
import com.github.vitorzottino.ms_proposta_credito.exception.DatabaseException;
import com.github.vitorzottino.ms_proposta_credito.exception.PropostaNotFoundException;
import com.github.vitorzottino.ms_proposta_credito.model.Proposta;
import com.github.vitorzottino.ms_proposta_credito.model.User;
import com.github.vitorzottino.ms_proposta_credito.repository.PropostaRepository;
import com.github.vitorzottino.ms_proposta_credito.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PropostaService {

    @Autowired
    private PropostaRepository propostaRepository;

    @Autowired
    private UserRepository userRepository;


    @Transactional(readOnly = true)
    public Page<PropostaDTO> findAll(Pageable pageable) {
        Page<Proposta> users = propostaRepository.findAll(pageable);
        return users.map(PropostaDTO::new);
    }

    @Transactional(readOnly = true)
    public PropostaDTO findById(Long id) {
        Proposta proposta = propostaRepository.findById(id).orElseThrow(() -> new PropostaNotFoundException(id));
        return new PropostaDTO(proposta);
    }

    @Transactional
    public FormDataDTO insert(FormDataDTO dto) {
        User user = new User();
        Proposta proposta = new Proposta();
        copyWholeDtoToEntity(dto, proposta, user);
        user = userRepository.save(user);
        proposta.setUserId(user.getId());
        proposta = propostaRepository.save(proposta);
        return new FormDataDTO(proposta, user);
    }

    @Transactional
    public PropostaUpdateDTO update(Long id, PropostaUpdateDTO dto) {
        try {
            Proposta proposta = propostaRepository.getReferenceById(id);
            copySimpleDtoToEntity(dto, proposta);
            proposta = propostaRepository.save(proposta);
            return new PropostaUpdateDTO(proposta);
        } catch (EntityNotFoundException e) {
            throw new PropostaNotFoundException(id);
        }
    }

    @Transactional
    public void delete(Long id){
        if(! propostaRepository.existsById(id)){
            throw new PropostaNotFoundException(id);
        }
        try{
            propostaRepository.deleteById(id);
        } catch (DataIntegrityViolationException e){
            throw new DatabaseException("Falha de integridade referencial");
        }
    }


    private void copySimpleDtoToEntity(PropostaUpdateDTO dto, Proposta proposta) {
        proposta.setValorSolicitado(dto.getValorSolicitado());
        proposta.setPrazoParaPagamento(dto.getPrazoParaPagamento());
        proposta.setAprovado(dto.getAprovado());

    }

    private void copyWholeDtoToEntity(FormDataDTO dto, Proposta proposta, User user) {
        proposta.setValorSolicitado(dto.getValorSolicitado());
        proposta.setPrazoParaPagamento(dto.getPrazoParaPagamento());
        proposta.setAprovado(dto.isAprovado());
        user.setNome(dto.getNome());
        user.setSobrenome(dto.getSobrenome());
        user.setCpf(dto.getCpf());
        user.setTelefone(dto.getTelefone());
        user.setRenda(dto.getRenda());
    }
}
