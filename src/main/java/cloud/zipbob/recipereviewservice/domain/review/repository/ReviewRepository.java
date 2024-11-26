package cloud.zipbob.recipereviewservice.domain.review.repository;

import cloud.zipbob.recipereviewservice.domain.review.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ReviewRepository extends MongoRepository<Review, String> {
    List<Review> findByRecipeId(String recipeId);
    List<Review> findByMemberId(Long memberId);
}
