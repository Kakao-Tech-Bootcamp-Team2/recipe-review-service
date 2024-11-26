package cloud.zipbob.recipereviewservice.domain.review;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Document
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class Review {
    @Id
    private String id;

    private Long memberId;
    private String recipeId;
    private String content;
    private String authorNickname;
    private int rating; //별점

    @CreatedDate
    private LocalDateTime createdDate;
    @LastModifiedDate
    private LocalDateTime updatedDate;

    public void updateReview(String content, int rating){
        this.content = content;
        this.rating = rating;
    }
}
