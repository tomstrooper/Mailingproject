package test_bazadanych.test_db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import test_bazadanych.test_db.models.Client;
import test_bazadanych.test_db.models.Messgebox;

public interface MessageboxRepo extends JpaRepository<Messgebox, Integer> {
}
