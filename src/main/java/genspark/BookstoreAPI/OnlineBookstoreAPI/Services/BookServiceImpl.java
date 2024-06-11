package genspark.BookstoreAPI.OnlineBookstoreAPI.Services;

import genspark.BookstoreAPI.OnlineBookstoreAPI.Entity.Book;
import genspark.BookstoreAPI.OnlineBookstoreAPI.Repository.BookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    public BookDAO bookDAO;

    @Override
    public List<Book> getAllBooks() {
        return this.bookDAO.findAll();
    }

    @Override
    public Book getBookByID(long isbn) {

        Optional<Book> b = this.bookDAO.findById(isbn);
        Book book = null;
        if(b.isPresent())
            book=b.get();
        else
            throw new RuntimeException("Book Not Found: "+isbn);

        return book;
    }

    @Override
    public List<Book> getBooksByTitle(String title)
    {
        return bookDAO.findBooksByTitle(title);
    }

    @Override
    public List<Book> getBooksByTitleSort()
    {
        return bookDAO.findBooksByTitleSort();
    }

    @Override
    public List<Book> getBooksByAuthor(String author)
    {
        return bookDAO.findBooksByAuthor(author);
    }

    @Override
    public List<Book> getBooksByAuthorSort()
    {
        return bookDAO.findBooksByAuthorSort();
    }

    @Override
    public List<Book> getBooksByPrice(double price)
    {
        return bookDAO.findBooksByPrice(price);
    }

    @Override
    public List<Book> getBooksByPriceSort()
    {
        return bookDAO.findBooksByPriceSort();
    }

    @Override
    public Book addNewBook(Book newBook) {
        return this.bookDAO.save(newBook);
    }

    @Override
    public Book updateBook(Book book) {

        for(Book b: getAllBooks()) {
            if(book.getISBN() == b.getISBN()){
                deleteBookByID(b.getISBN());
            }
        }

        return this.bookDAO.save(book);
    }

    @Override
    public String deleteBookByID(long isbn) {
        this.bookDAO.deleteById(isbn);
        return "Book Deleted Successfully!";
    }
}
