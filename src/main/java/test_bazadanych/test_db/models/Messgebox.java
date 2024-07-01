package test_bazadanych.test_db.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Messgebox {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;

    private String emailadress;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "email_Id")
    private Email email;

    public Messgebox() {
    }

    public Messgebox(Integer id, String emailadress, Email email) {
        Id = id;
        this.emailadress = emailadress;
        this.email = email;
    }

    public Messgebox(String emailadress, Email email) {
        this.emailadress = emailadress;
        this.email = email;
    }
}
