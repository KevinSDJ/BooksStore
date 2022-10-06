package com.example.bookApp.Entities;
import javax.persistence.OneToOne;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.Column;

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
    @OneToOne(optional=false) @MapsId
    private String bookCover;

    public Book() {
    }

    public Book(String title, String sinopsis, Double price) {
        this.title = title;
        this.sinopsis = sinopsis;
        this.price = price;
    }

}
