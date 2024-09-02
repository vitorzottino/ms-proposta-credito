package com.github.vitorzottino.ms_proposta_credito.service;

import com.github.vitorzottino.ms_proposta_credito.dto.UserDTO;
import com.github.vitorzottino.ms_proposta_credito.exception.UserNotFoundException;
import com.github.vitorzottino.ms_proposta_credito.model.User;
import com.github.vitorzottino.ms_proposta_credito.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public Page<UserDTO> findAll(Pageable pageable) {
        Page<User> users = userRepository.findAll(pageable);
        return users.map(UserDTO::new);
    }

    @Transactional(readOnly = true)
    public UserDTO findById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        return new UserDTO(user);
    }

    @Transactional
    public UserDTO insert(UserDTO dto) {
        User user = new User();
        copyDtoToEntity(dto, user);
        user = userRepository.save(user);
        return new UserDTO(user);
    }

    @Transactional
    public UserDTO update(Long id, UserDTO dto) {
        try {
            User user = userRepository.getReferenceById(id);
            copyDtoToEntity(dto, user);
            user.setId(id);
            user = userRepository.save(user);
            return new UserDTO(user);
        } catch (EntityNotFoundException e) {
            throw new UserNotFoundException(id);
        }
    }

    @Transactional
    public void delete(Long id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException(id);
        }
        try {
            userRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new UserNotFoundException(id);
        }
    }


    private void copyDtoToEntity(UserDTO dto, User user) {
        user.setId(dto.getId());
        user.setNome(dto.getNome());
        user.setSobrenome(dto.getSobrenome());
        user.setCpf(dto.getCpf());
        user.setTelefone(dto.getTelefone());
        user.setRenda(dto.getRenda());
    }
}
