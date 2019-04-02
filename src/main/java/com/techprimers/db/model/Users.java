package com.techprimers.db.model;

import org.springframework.data.annotation.Transient;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "user")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min=2, max=30)
    private String ime;
    @Size(min=1, message = "Polje za prezime ne smije biti praznoo")
    private String prezime;
    private String email;
    private String password;


    @ManyToMany
    private Set<Roles> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {

      /*  if (salt) {
            this.password = BCrypt.hashpw(password, BCrypt.gensalt());
        } else {
            this.password = password;
        }*/
        BCryptPasswordEncoder passwordEncoder= new BCryptPasswordEncoder();
        String newpassword=passwordEncoder.encode(password);
        System.out.println("Compare 1 "+passwordEncoder.matches("123",password));
        System.out.println("Compare 2: "+passwordEncoder.matches("12345",password));

        this.password = newpassword;
    }

    public Set<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }

}