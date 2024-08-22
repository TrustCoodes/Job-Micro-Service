package com.trustcoodes.jobAppSimpleLogic.ReviewLayer.Service;

import com.trustcoodes.jobAppSimpleLogic.ReviewLayer.Entity.ReviewEntity;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface ReviewService {

    List<ReviewEntity> findAllReview(Long companyId);

    ReviewEntity findReviewById(Long reviewEntityId);

    boolean addReview(Long id, ReviewEntity reviewEntity);

    boolean removeReviewById(Long reviewEntityId);

    boolean updateReviewById(ReviewEntity reviewEntity, Long reviewEntityId);


}
