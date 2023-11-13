package ee.mainor.librarymanagementsystem.libraryRepository;

import ee.mainor.librarymanagementsystem.model.BookModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<BookModel,Long> {

    List<BookModel> findAllById(Long id);
    List<BookModel> findAllByTitle(String title);
    List<BookModel> findAllByAuthor(String author);
    List<BookModel> findAllByCategory(String category);

}
