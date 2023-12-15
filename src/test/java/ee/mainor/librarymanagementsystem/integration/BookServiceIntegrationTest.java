package ee.mainor.librarymanagementsystem.integration;

import ee.mainor.librarymanagementsystem.EnableTestContainers;
import ee.mainor.librarymanagementsystem.dto.BookDto;
import ee.mainor.librarymanagementsystem.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@EnableTestContainers
public class BookServiceIntegrationTest {

    @Autowired
    private BookService bookService;


    @Test
    void shouldFindBooksByAuthorWhenAuthorMatches() {
        List<BookDto> actual = bookService.getBooksByTitle("Book Title 1");

        assertThat(actual).hasSize(1);
        assertThat(actual.get(0).getTitle()).isEqualTo("Book Title 1");
    }
}
