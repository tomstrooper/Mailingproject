package test_bazadanych.test_db.repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import test_bazadanych.test_db.models.Email;

public interface EmailRepo extends JpaRepository<Email, Integer> {
}
