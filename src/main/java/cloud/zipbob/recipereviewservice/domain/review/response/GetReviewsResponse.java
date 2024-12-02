package cloud.zipbob.recipereviewservice.domain.review.response;

import cloud.zipbob.recipereviewservice.domain.review.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.List;

@Getter
@AllArgsConstructor
public class GetReviewsResponse {
    private List<Review> reviews;

    public static GetReviewsResponse of(List<Review> reviews) {
        return new GetReviewsResponse(reviews);
    }
}
