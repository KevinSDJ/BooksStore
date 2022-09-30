package com.example.bookApp.Entities;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,length = 65)
    private String title;
    @Column(nullable = true)
    private String sinopsis;
    @Column(nullable = false,length = 40)
    private Double price;
    @Column(name = "book_cover")
    private String bookCover;

    public Book() {
    }

    public Book(String title, String sinopsis, Double price, String bookCover) {
        this.title = title;
        this.sinopsis = sinopsis;
        this.price = price;
        this.bookCover = bookCover;
    }

}
