package org.example.dto;

import java.time.LocalDate;

public class Book {
    private Integer id;
    private String title;
    private String author;
    private String publishYear;
    private Integer amount;
    private Boolean visible;
    public Book() {
    }

    public Book(Integer id, String title, String author, String publishYear, Integer amount, Boolean visible) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publishYear = publishYear;
        this.amount = amount;
        this.visible = visible;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getPublishYear() {
        return publishYear;
    }
    public void setPublishYear(String publishYear) {
        this.publishYear = publishYear;
    }
    public Integer getAmount() {
        return amount;
    }
    public void setAmount(Integer amount) {
        this.amount = amount;
    }
    public Boolean getVisible() {
        return visible;
    }
    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publishYear=" + publishYear +
                ", amount=" + amount +
                ", visible=" + visible +
                '}';
    }
}
