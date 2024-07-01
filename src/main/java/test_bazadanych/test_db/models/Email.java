package test_bazadanych.test_db.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Email {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;

    private String subject;

    private String emailtext;
    @OneToMany(mappedBy = "email",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Messgebox> messgeboxes;

    public Email(Integer id, String subject, String emailtext) {
        Id = id;
        this.subject = subject;
        this.emailtext = emailtext;
    }

    public Email(String subject, String emailtext) {
        this.subject = subject;
        this.emailtext = emailtext;
    }
    public Email(){

    }
}
