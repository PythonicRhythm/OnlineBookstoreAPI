package genspark.BookstoreAPI.OnlineBookstoreAPI.Repository;

import genspark.BookstoreAPI.OnlineBookstoreAPI.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDAO extends JpaRepository<Book, Long> {

    @Query("SELECT b from Book b WHERE b.title = :title")
    List<Book> findBooksByTitle(@Param("title") String title);

    @Query("SELECT b from Book b WHERE b.author = :author")
    List<Book> findBooksByAuthor(@Param("author") String author);

    @Query("SELECT b from Book b WHERE b.price = :price")
    List<Book> findBooksByPrice(@Param("price") double price);

    @Query(value = "SELECT * FROM book ORDER BY title", nativeQuery = true)
    List<Book> findBooksByTitleSort();

    @Query(value = "SELECT * FROM book ORDER BY author", nativeQuery = true)
    List<Book> findBooksByAuthorSort();

    @Query(value = "SELECT * FROM book ORDER BY price", nativeQuery = true)
    List<Book> findBooksByPriceSort();
}
