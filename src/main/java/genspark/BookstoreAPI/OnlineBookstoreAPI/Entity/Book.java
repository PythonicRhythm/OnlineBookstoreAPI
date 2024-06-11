package genspark.BookstoreAPI.OnlineBookstoreAPI.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.convert.DataSizeUnit;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookISBN;
    private String title;
    @Column(length = 500)
    private String summary;
    private String author;
    private double price;

    public long getISBN() {
        return bookISBN;
    }

    public String getTitle() {
        return title;
    }

    public String getSummary() {
        return summary;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public void setBookISBN(long bookISBN) {
        this.bookISBN = bookISBN;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
