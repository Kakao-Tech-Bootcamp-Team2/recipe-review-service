package cloud.zipbob.recipereviewservice.api;

import cloud.zipbob.recipereviewservice.domain.review.request.*;
import cloud.zipbob.recipereviewservice.domain.review.response.GetReviewsResponse;
import cloud.zipbob.recipereviewservice.domain.review.response.ReviewResponse;
import cloud.zipbob.recipereviewservice.domain.review.service.ReviewService;
import cloud.zipbob.recipereviewservice.global.Responder;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("")
    public ResponseEntity<ReviewResponse> createReview(final @Valid @RequestBody ReviewCreateRequest request, @RequestHeader("X-Member-Id") Long authenticatedMemberId){
        ReviewResponse response = reviewService.createReview(request, authenticatedMemberId);
        return Responder.success(response, HttpStatus.CREATED);
    }

    @GetMapping("/recipe")
    public ResponseEntity<GetReviewsResponse> getReviewsByRecipe(final @RequestBody GetReviewsByRecipeRequest request){
        GetReviewsResponse response = reviewService.getReviewsByRecipe(request);
        return Responder.success(response);
    }

    @GetMapping("/member")
    public ResponseEntity<GetReviewsResponse> getReviewsByMember(final @RequestBody GetReviewsByMemberRequest request, @RequestHeader("X-Member-Id") Long authenticatedMemberId){
        GetReviewsResponse response = reviewService.getReviewsByMember(request, authenticatedMemberId);
        return Responder.success(response);
    }

    @DeleteMapping("")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteReview(final @RequestBody ReviewRequest request, @RequestHeader("X-Member-Id") Long authenticatedMemberId){
        reviewService.deleteReview(request, authenticatedMemberId);
    }

    @PatchMapping("")
    public ResponseEntity<ReviewResponse> updateReview(final @Valid @RequestBody ReviewUpdateRequest request, @RequestHeader("X-Member-Id") Long authenticatedMemberId){
        ReviewResponse response = reviewService.updateReview(request, authenticatedMemberId);
        return Responder.success(response);
    }

}
