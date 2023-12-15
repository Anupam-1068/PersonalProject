package ee.mainor.librarymanagementsystem.service;

import ee.mainor.librarymanagementsystem.libraryRepository.BookRepository;
import ee.mainor.librarymanagementsystem.dto.BookDto;
import ee.mainor.librarymanagementsystem.mapper.BookMapper;
import ee.mainor.librarymanagementsystem.model.BookModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<BookDto> getAllBook(){
        List<BookModel> BookModels = bookRepository.getAllBook();

        return getBookDtos(BookModels);
    }
    public List<BookDto> getBooksById(Long id){
        List<BookModel> BookModels = bookRepository.findAllById(id);

        return getBookDtos(BookModels);
    }

    public List<BookDto> getBooksByTitle(String title){
        List<BookModel> BookModels = bookRepository.findAllByTitle(title);

        return getBookDtos(BookModels);
    }



    public List<BookDto> getBooksByAuthor(String author){
        List<BookModel> bookModels = bookRepository.findAllByAuthor(author);

        return getBookDtos(bookModels);
    }

    public List<BookDto> getBooksByCategory(String category){
        List<BookModel> BookModels = bookRepository.findAllByCategory(category);

        return getBookDtos(BookModels);

    }

    private static List<BookDto> getBookDtos(List<BookModel> BookModels) {
        return BookModels.stream().map(BookModel -> {
            BookDto bookDto = new BookDto();
            bookDto.setId(BookModel.getId());
            bookDto.setTitle(BookModel.getTitle());
            bookDto.setDescription(BookModel.getDescription());
            return bookDto;
        }).toList();
    }

    @Transactional
    public BookDto createBook(BookDto bookdto) {

        BookModel bookModel = BookMapper.toEntity(bookdto, null);

        BookModel bookModel1 = bookRepository.save(bookModel);

        return BookMapper.toDto(bookModel1);

    }



    @Transactional
    public BookDto updateBook(Long id, BookDto bookDto) {
        BookModel initialBook = requireBook(id);
        BookModel bookModel = BookMapper.toEntity(bookDto, initialBook);

        return BookMapper.toDto(bookRepository.save(bookModel));
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    private BookModel requireBook(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(String.format("Book with id: %s was not found", id)));
    }
}
