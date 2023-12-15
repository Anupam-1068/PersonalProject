package ee.mainor.librarymanagementsystem.integration;

import ee.mainor.librarymanagementsystem.EnableTestContainers;
import ee.mainor.librarymanagementsystem.dto.ReviewDto;
import ee.mainor.librarymanagementsystem.service.ReviewService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@EnableTestContainers
public class ReviewServiceIntegrationTest {

    @Autowired
    private ReviewService reviewService;


    @Test
    void shouldFindReviewsByEmailWhenEmailMatches() {
        List<ReviewDto> actual = reviewService.getReviewByUserEmail("user1@example.com");

        assertThat(actual).hasSize(1);
        assertThat(actual.get(0).getUserEmail()).isEqualTo("user1@example.com");
    }
}
