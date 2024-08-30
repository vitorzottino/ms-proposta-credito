package com.github.vitorzottino.ms_proposta_credito.repository;

import com.github.vitorzottino.ms_proposta_credito.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
