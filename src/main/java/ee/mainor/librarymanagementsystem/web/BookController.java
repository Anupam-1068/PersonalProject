package ee.mainor.librarymanagementsystem.web;
import ee.mainor.librarymanagementsystem.dto.BookDto;
import ee.mainor.librarymanagementsystem.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("book")
public class BookController {

    private final BookService bookService;
    @GetMapping()
    public List<BookDto> getAllBooks() {
        return bookService.getAllBook();
    }

    @GetMapping("{id}")
    public BookDto getBookById(@PathVariable Long id) {
        return bookService.getBookModelById(id);
    }

    @GetMapping("title")
    public List<BookDto> getBookByTitle(@RequestParam String title) {
        return bookService.getBooksByTitle(title);
    }

    @GetMapping("author")
    public List<BookDto> getBookByAuthor(@RequestParam String author) {
        return bookService.getBooksByAuthor(author);
    }


    @GetMapping("category")
    public List<BookDto> getBookByCategory(@RequestParam String category) {
        return bookService.getBooksByCategory(category);
    }

    @PostMapping
    public BookDto createBook(@RequestBody BookDto bookDto) {
        return bookService.createBook(bookDto);
    }

    @PutMapping("{id}")
    public BookDto updateBook(@RequestBody BookDto bookDto, @PathVariable Long id) {
        return bookService.updateBook(id, bookDto);

    }

    @DeleteMapping("{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }

}
