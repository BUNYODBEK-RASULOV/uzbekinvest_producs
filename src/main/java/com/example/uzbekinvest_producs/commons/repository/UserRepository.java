package com.example.uzbekinvest_producs.commons.repository;

import com.example.uzbekinvest_producs.commons.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
    Optional<UserEntity> findByTbLogin(String tbLogin);
}
