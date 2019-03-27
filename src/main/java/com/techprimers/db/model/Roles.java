package com.techprimers.db.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Roles {
    @Id
    @GeneratedValue
    @Column(name = "id_role")
    private Integer id_role;
    @Column(name = "tip")
    private String tip;

    public Integer getId_role() {
        return id_role;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }
}
