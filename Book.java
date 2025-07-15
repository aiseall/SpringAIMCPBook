package cn.ai4se.springaimcp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;       // 书名
    private String author;      // 作者
    private String category;    // 分类
    private LocalDate publishDate; // 出版日期

    public Book() {} // JPA必需

    public Book(String title, String author, String category, LocalDate publishDate) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.publishDate = publishDate;
    }

    // Getter + Setter（略，实际需完整实现）
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public LocalDate getPublishDate() { return publishDate; }
    public void setPublishDate(LocalDate publishDate) { this.publishDate = publishDate; }
}