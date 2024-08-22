package com.trustcoodes.jobAppSimpleLogic.ReviewLayer.Service.ReviewImpl;


import com.trustcoodes.jobAppSimpleLogic.Exceptions.ResourceNotFoundException;
import com.trustcoodes.jobAppSimpleLogic.Exceptions.ReviewNotFoundException;
import com.trustcoodes.jobAppSimpleLogic.ReviewLayer.Entity.ReviewEntity;
import com.trustcoodes.jobAppSimpleLogic.ReviewLayer.Repository.ReviewRepo;
import com.trustcoodes.jobAppSimpleLogic.ReviewLayer.Service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ImplReview implements ReviewService {

    @Autowired
    private ReviewRepo reviewRepo;

    @Override
    public List<ReviewEntity> findAllReview(Long companyId) {
        return reviewRepo.findByCompanyId(companyId);
    }

    @Override
    public ReviewEntity findReviewById(Long reviewEntityId) {
        return reviewRepo.findById(reviewEntityId)
                .orElseThrow(() -> new ReviewNotFoundException("Review Not Found for This ID"));
    }

    @Override
    public boolean addReview(Long id, ReviewEntity reviewEntity) {

        if (id !=null && reviewEntity !=null){
            reviewEntity.setCompanyId(id);
            reviewRepo.save(reviewEntity);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeReviewById(Long reviewEntityId) {
        ReviewEntity entity = reviewRepo.findById(reviewEntityId)
                .orElseThrow(() -> new ResourceNotFoundException("No Review Found For This Request"));
        if (entity != null) {
            reviewRepo.deleteById(reviewEntityId);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateReviewById(ReviewEntity reviewEntity, Long reviewEntityId) {
        ReviewEntity reviewEntity1 = reviewRepo.findById(reviewEntityId)
                .orElseThrow(() -> new ResourceNotFoundException("Review" + reviewEntityId + "Not Found"));

           reviewEntity1.setInfo(reviewEntity.getInfo());
           reviewEntity1.setHeading(reviewEntity.getHeading());
           reviewEntity1.setReviewRating(reviewEntity.getReviewRating());
           reviewRepo.save(reviewEntity1);

           return true;

    }


}