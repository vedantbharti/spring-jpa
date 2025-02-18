package com.example.springJpa.dao.repository;

import com.example.springJpa.dao.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<UserDetails, String> {
}
