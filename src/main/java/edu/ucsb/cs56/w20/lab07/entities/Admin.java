package edu.ucsb.cs56.w20.lab07.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String email;

    private boolean isPermanent = false;

    public Admin() {
    }

    public Admin(String email, boolean isPermanent) {
        this.email = email;
        this.isPermanent = isPermanent;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public boolean getIsPermanent() {
        return this.isPermanent;
    }

    public void setIsPermanent(boolean isPermanent) {
        this.isPermanent = isPermanent;
    }

}