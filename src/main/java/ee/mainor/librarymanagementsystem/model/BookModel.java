package ee.mainor.librarymanagementsystem.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(name = "book")
public class BookModel {


    @Id
    private Long id;

    private String title;

    private String author;

    private String description;

    private int copies;

    private int copiesAvailable;

    private String category;

    private String img;



}
