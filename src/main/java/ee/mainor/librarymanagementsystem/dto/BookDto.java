package ee.mainor.librarymanagementsystem.dto;


import lombok.Data;

@Data
public class BookDto {

    private Long id;

    private String title;

    private String author;

    private String description;


}
