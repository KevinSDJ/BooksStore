package com.example.bookApp.DTO;

import java.io.Serializable;




public class BookDTO implements Serializable{
    private Long id;
    private String title;
    private String sinopsis;
    private Double price;
    private String cover_path;
    private BookImageDTO cover_front;
    
    public BookImageDTO getCover_front() {
        return cover_front;
    }
    public void setCover_front(BookImageDTO cover_front) {
        this.cover_front = cover_front;
    }
    public String getCover_path() {
        return cover_path;
    }
    public void setCover_path(String cover_path) {
        this.cover_path = cover_path;
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
        return "BookDTO [id=" + id + ", title=" + title + ", sinopsis=" + sinopsis + ", price=" + price
                + ", cover_path=" + cover_path + ", cover_front=" + cover_front + "]";
    }
    
    
}
