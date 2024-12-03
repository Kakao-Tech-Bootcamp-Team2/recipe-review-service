package cloud.zipbob.recipereviewservice.demo;

import cloud.zipbob.recipereviewservice.domain.review.Review;
import cloud.zipbob.recipereviewservice.domain.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Profile("testdata")
@RequiredArgsConstructor
public class ReviewDataLoader {
    private final ReviewRepository reviewRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void loadReviewTestData(){
        reviewRepository.deleteAll();
        var review1 = Review.builder()
                .memberId(135l)
                .recipeId("recipe_6789012")
                .content("음식이 맛있어요!!")
                .authorNickname("covy")
                .rating(5)
                .build();
        var review2 = Review.builder()
                .memberId(123l)
                .recipeId("recipe_6789012")
                .content("그냥 그래요!!")
                .authorNickname("leo")
                .rating(3)
                .build();
        reviewRepository.save(review1);
        reviewRepository.save(review2);
    }
}
