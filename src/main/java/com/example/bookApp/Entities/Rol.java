package com.example.bookApp.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Rol {

    @Id
    private Long id;
    @Column(nullable = false,unique = true)
    private String name;

    public Rol() {
    }

    public Rol(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Rol{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
