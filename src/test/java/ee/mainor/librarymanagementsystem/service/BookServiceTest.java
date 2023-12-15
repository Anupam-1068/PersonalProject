package ee.mainor.librarymanagementsystem.service;

import ee.mainor.librarymanagementsystem.dto.BookDto;
import ee.mainor.librarymanagementsystem.libraryRepository.BookRepository;
import ee.mainor.librarymanagementsystem.model.BookModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    void shouldFindBooksByName() {
        BookModel bookModel = new BookModel();
        bookModel.setId(1L);
        bookModel.setAuthor("TestAuthor");
        bookModel.setCategory("TestCategory");
        bookModel.setDescription("TestDescription");

        when(bookRepository.findAllByAuthor("TestAuthor"))
                .thenReturn(List.of(bookModel));

        List<BookDto> actual = bookService.getBooksByAuthor("TestAuthor");

        assertThat(actual).hasSize(1);

        assertThat(actual.get(0).getId()).isEqualTo(1L);
        assertThat(actual.get(0).getDescription()).isEqualTo("TestDescription");
    }

    @Test
    void createBook() {
        // Given
        BookDto bookDto = new BookDto();
        bookDto.setAuthor("NewAuthor");
        bookDto.setTitle("NewTitle");
        bookDto.setDescription("NewDescription");

        BookModel createdBook = new BookModel();
        createdBook.setId(2L);
        createdBook.setAuthor("NewAuthor");
        createdBook.setCategory("NewCategory");
        createdBook.setDescription("NewDescription");

        when(bookRepository.save(any(BookModel.class)))
                .thenReturn(createdBook);


        // When
        BookDto actual = bookService.createBook(bookDto);

        // Then
        assertThat(actual.getId()).isEqualTo(2L);
        assertThat(actual.getAuthor()).isEqualTo("NewAuthor");
        assertThat(actual.getDescription()).isEqualTo("NewDescription");
    }

    @Test
    void updateBook() {
        // Given
        long bookId = 3L;
        BookDto bookDto = new BookDto();
        bookDto.setId(bookId);
        bookDto.setAuthor("UpdatedAuthor");
        bookDto.setDescription("UpdatedDescription");

        BookModel existingBook = new BookModel();
        existingBook.setId(bookId);
        existingBook.setAuthor("OldAuthor");
        existingBook.setCategory("OldCategory");
        existingBook.setDescription("OldDescription");

        when(bookRepository.findById(bookId))
                .thenReturn(java.util.Optional.of(existingBook));

        when(bookRepository.save(any(BookModel.class)))
                .thenReturn(existingBook);

        // When
        BookDto actual = bookService.updateBook(bookId, bookDto);

        // Then
        assertThat(actual.getId()).isEqualTo(bookId);
        assertThat(actual.getAuthor()).isEqualTo("UpdatedAuthor");
        assertThat(actual.getDescription()).isEqualTo("UpdatedDescription");
    }

    @Test
    void deleteBook() {
        // Given
        long bookId = 4L;

        // When
        bookService.deleteBook(bookId);

        // Then
        verify(bookRepository, times(1)).deleteById(bookId);
    }

}
