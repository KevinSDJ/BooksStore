package com.bookStore.bookApp.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;

@Entity
@Table(name="books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,unique = true)
    private String title;
    private String sinopsis;
    @Column(nullable = false)
    private Double price;
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Category category;
    

    public Book(String title, String sinopsis, Double price) {
        this.title = title;
        this.sinopsis = sinopsis;
        this.price = price;
    }
    public Book() {
    }
    public Book(String title, Double price) {
        this.title = title;
        this.price = price;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getSinopsis() {
        return sinopsis;
    }
    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", sinopsis=" + sinopsis + ", price=" + price + "]";
    }

    
}
