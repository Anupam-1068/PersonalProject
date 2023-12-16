package ee.mainor.librarymanagementsystem.mapper;

import ee.mainor.librarymanagementsystem.dto.BookDto;
import ee.mainor.librarymanagementsystem.model.BookModel;

public class BookMapper {

    public static BookDto toDto(BookModel BookModels) {
        BookDto bookDto = new BookDto();
        if (BookModels == null) {
            return bookDto;
        }
            bookDto.setId(BookModels.getId());
            bookDto.setAuthor(BookModels.getAuthor());
            bookDto.setTitle(BookModels.getTitle());
            bookDto.setDescription(BookModels.getDescription());
            return bookDto;

    }

    public static BookModel toModel(BookDto bookDto, BookModel bookModel) {
        if (bookModel == null) {
            bookModel = new BookModel();
        }
        if (bookDto == null) {
            return bookModel;
        }
        bookModel.setAuthor(bookDto.getAuthor());
        bookModel.setTitle(bookDto.getTitle());
        bookModel.setDescription(bookDto.getDescription());
        return bookModel;
    }
}
