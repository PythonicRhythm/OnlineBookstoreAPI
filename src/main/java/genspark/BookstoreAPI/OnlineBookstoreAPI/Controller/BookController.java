package genspark.BookstoreAPI.OnlineBookstoreAPI.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import genspark.BookstoreAPI.OnlineBookstoreAPI.Entity.Book;
import genspark.BookstoreAPI.OnlineBookstoreAPI.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    public BookService bs;

    @GetMapping("/")
    public String home()
    {
        return "<h1>Welcome to my Book Store!</h1><a href=\"/books\">View your books!</a>";
    }

    @GetMapping("/books")
    public String getBooks()
    {
        StringBuilder allHTML = new StringBuilder();
        allHTML.append("<h1>All your Books!</h1>");
        List<Book> allBooks = this.bs.getAllBooks();

        for(Book b: allBooks) {
            allHTML.append("<br>");
            allHTML.append(String.format("<h2>Title %s:</h2>",b.getTitle()));
            allHTML.append(String.format("<p>ISBN: %d</p>", b.getISBN()));
            allHTML.append(String.format("<p>Summary: %s</p>", b.getSummary()));
            allHTML.append(String.format("<p><b>Price: $%s</b></p>", b.getPrice()));
            allHTML.append(String.format("<h4>Book %d JSON:</h4>", b.getISBN()));
            try{
                allHTML.append(String.format("<p>%s</p>", new ObjectMapper().writeValueAsString(b)));
            } catch(JsonProcessingException ex) {
                System.out.println("Json Conversion Failed: "+ex.getMessage());
            }

            allHTML.append(String.format("<a href=\"books/%d\">View raw JSON</a>", b.getISBN()));

            allHTML.append("<br>");

        }

        if(allBooks.isEmpty()) {
            allHTML.append("<h4>No Books saved currently. Try making some via postman!</h4>");
        }

        return allHTML.toString();
    }

    @GetMapping("/books/title")
    public String getBooksByTitleSort()
    {
        StringBuilder allHTML = new StringBuilder();
        allHTML.append("<h1>All your Books!</h1>");
        List<Book> allBooks = this.bs.getBooksByTitleSort();

        for(Book b: allBooks) {
            allHTML.append("<br>");
            allHTML.append(String.format("<h2>Title %s:</h2>",b.getTitle()));
            allHTML.append(String.format("<p>ISBN: %d</p>", b.getISBN()));
            allHTML.append(String.format("<p>Summary: %s</p>", b.getSummary()));
            allHTML.append(String.format("<p><b>Price: $%s</b></p>", b.getPrice()));
            allHTML.append(String.format("<h4>Book %d JSON:</h4>", b.getISBN()));
            try{
                allHTML.append(String.format("<p>%s</p>", new ObjectMapper().writeValueAsString(b)));
            } catch(JsonProcessingException ex) {
                System.out.println("Json Conversion Failed: "+ex.getMessage());
            }

            allHTML.append(String.format("<a href=\"books/%d\">View raw JSON</a>", b.getISBN()));

            allHTML.append("<br>");

        }

        if(allBooks.isEmpty()) {
            allHTML.append("<h4>No Books saved currently. Try making some via postman!</h4>");
        }

        return allHTML.toString();
    }

    @GetMapping("/books/author")
    public String getBooksByAuthor()
    {
        return "Not Implemented";
    }

    @GetMapping("/books/price")
    public String getBooksByPrice()
    {
        return "Not Implemented";
    }

    @GetMapping("/books/{bookISBN}")
    public Book getSingleBook(@PathVariable Long bookISBN)
    {
        return this.bs.getBookByID(bookISBN);
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book)
    {
        return this.bs.addNewBook(book);
    }

    // WHEN UPDATING VIA POSTMAN
    // YOU NEED TO USE "bookISBN"
    // AS THE FIRST FIELD TO SPECIFY
    // THE BOOK NEEDING AN UPDATE.
    @PutMapping("/books")
    public Book updateBook(@RequestBody Book book)
    {
        return this.bs.updateBook(book);
    }

    @DeleteMapping("/books/{bookISBN}")
    public String deleteBook(@PathVariable Long bookISBN)
    {
        return this.bs.deleteBookByID(bookISBN);
    }

}
