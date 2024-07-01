package test_bazadanych.test_db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import test_bazadanych.test_db.models.Client;

import java.util.List;


public interface ClientRepo extends JpaRepository<Client, Integer> {
}
