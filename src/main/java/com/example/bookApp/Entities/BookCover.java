package com.example.bookApp.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="Books_cover")
public class BookCover {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String coverpath;
    public BookCover(String name, String coverpath) {
        this.name = name;
        this.coverpath = coverpath;
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
    public String getCoverpath() {
        return coverpath;
    }
    public void setCoverpath(String coverpath) {
        this.coverpath = coverpath;
    }
    @Override
    public String toString() {
        return "BookCover [id=" + id + ", name=" + name + ", coverpath=" + coverpath + "]";
    }
    
    
}
