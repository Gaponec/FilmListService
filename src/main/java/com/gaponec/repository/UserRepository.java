package com.gaponec.repository;

import com.gaponec.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Override
    User getOne(Integer id);
}
