package test_bazadanych.test_db.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;

    private String email;

    private String imie;

    private String nazwisko;

    private String plec;

    private String kraj;

    public Integer getId() {
        return Id;
    }

    public String getEmail() {
        return email;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getPlec() {
        return plec;
    }

    public String getKraj() {
        return kraj;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    public void setKraj(String kraj) {
        this.kraj = kraj;
    }
}
