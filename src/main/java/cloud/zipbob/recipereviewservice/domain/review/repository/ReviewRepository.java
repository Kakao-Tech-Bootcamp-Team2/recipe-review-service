package cloud.zipbob.recipereviewservice.domain.review.repository;

import cloud.zipbob.recipereviewservice.domain.review.Review;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends MongoRepository<Review, String> {
    List<Review> findByRecipeId(String recipeId);
    List<Review> findByMemberId(Long memberId);
}
