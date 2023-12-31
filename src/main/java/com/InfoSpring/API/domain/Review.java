package com.InfoSpring.API.domain;

import com.InfoSpring.API.domain.enumeration.RatingEnum;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "review")
public class Review extends BaseEntity{

    @Column(length = 100,nullable = false)
    private String title;

    @Column(length = 100,nullable = false)
    private String nameBook;

    @Column(nullable = false)
    private String content;

    @Enumerated(EnumType.STRING)
    private RatingEnum ratingEnum;

    @Column(nullable = false)
    private LocalDate creationDate;

    public static ReviewBuilder builder(){
        return new ReviewBuilder(new Review());
    }

    public static class ReviewBuilder{
        public Review review;

        public ReviewBuilder(Review review){
            this.review = review;
        }

        public Review.ReviewBuilder uuid(UUID uuid){
            this.review.setUuid(uuid);
            return this;
        }
    }

}
