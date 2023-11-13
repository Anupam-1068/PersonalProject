package ee.mainor.librarymanagementsystem.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

@Data
@Table(name = "review")
public class ReviewModel {



    @Id
    private Long id;

    private String userEmail;

    private Date date;

    private double rating;

    private Long bookId;

    private String reviewDescription;




}
