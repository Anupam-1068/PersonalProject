package ee.mainor.librarymanagementsystem.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ReviewDto {

    private Long id;

    private String userEmail;

    private Date date;

    private double rating;

    private Long bookId;

    private String reviewDescription;
}
