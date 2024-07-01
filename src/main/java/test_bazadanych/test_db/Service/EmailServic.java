package test_bazadanych.test_db.Service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import test_bazadanych.test_db.models.Email;
import test_bazadanych.test_db.repository.EmailRepo;

import java.util.List;

@Service
@Transactional
public class EmailServic {
    @Autowired
    public EmailRepo emailRepo;

    public List<Email> getallemails(){
        return emailRepo.findAll();
    }
}
