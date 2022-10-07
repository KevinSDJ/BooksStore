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
    private BookCover bookCover;
    
    
    public Book() {
    }

    public Book(String title, String sinopsis, Double price) {
        this.title = title;
        this.sinopsis = sinopsis;
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

    public BookCover getBookCover() {
        return bookCover;
    }

    public void setBookCover(BookCover bookCover) {
        this.bookCover = bookCover;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", sinopsis=" + sinopsis + ", price=" + price + ", bookCover="
                + bookCover + "]";
    }

}
