package com.techprimers.db.model;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")


public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tip;

   // @OneToMany(targetEntity = Users.class, mappedBy = "role", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //private Set<Users> users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

   /*public Set<Users> getUsers() {
        return users;
    }

    public void setUsers(Set<Users> users) {
        this.users = users;
    }*/
}
