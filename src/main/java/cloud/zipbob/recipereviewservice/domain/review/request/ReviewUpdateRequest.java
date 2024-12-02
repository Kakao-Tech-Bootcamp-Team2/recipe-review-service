package cloud.zipbob.recipereviewservice.domain.review.request;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;

public record ReviewUpdateRequest (
        String reviewId,
        String content,
        @DecimalMin(value = "1.0", message = "Rating must be at least 1.0")
        @DecimalMax(value = "5.0", message = "Rating must be no more than 5.0")
        float rating
){}
