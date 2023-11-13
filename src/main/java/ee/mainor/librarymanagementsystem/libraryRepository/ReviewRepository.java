package ee.mainor.librarymanagementsystem.libraryRepository;

import ee.mainor.librarymanagementsystem.model.ReviewModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends CrudRepository<ReviewModel,Long> {

    List<ReviewModel> findReviewModelByUserEmail(String userEmail);


}
