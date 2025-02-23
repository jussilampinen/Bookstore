package hh.sof03.bookstore.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long categoryId;

    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Book> books;

    // Constructors
    public Category() {}

    public Category(String name){
        this.name = name;
    }
    
    // Getters and Setters
    public Long getCategoryid() { return categoryId; }
    public void setCategoryid(Long categoryid) { this.categoryId = categoryid; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<Book> getBooks() { return books; }
    public void setBooks(List<Book> books) { this.books = books; }
    
    //toString
    @Override
    public String toString() {
        return "Category [categoryId=" + categoryId + ", name=" + name + ", books=" + books + "]";
    }
}
