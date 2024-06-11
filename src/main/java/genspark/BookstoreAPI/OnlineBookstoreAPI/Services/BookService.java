package genspark.BookstoreAPI.OnlineBookstoreAPI.Services;

import genspark.BookstoreAPI.OnlineBookstoreAPI.Entity.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();
    Book getBookByID(long isbn);
    List<Book> getBooksByTitle(String title);
    List<Book> getBooksByAuthor(String author);
    List<Book> getBooksByPrice(double price);
    List<Book> getBooksByTitleSort();
    List<Book> getBooksByAuthorSort();
    List<Book> getBooksByPriceSort();
    Book addNewBook(Book newBook);
    Book updateBook(Book book);
    String deleteBookByID(long isbn);
}
