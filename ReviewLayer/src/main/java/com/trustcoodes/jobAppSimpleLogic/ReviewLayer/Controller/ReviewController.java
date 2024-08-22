package com.trustcoodes.jobAppSimpleLogic.ReviewLayer.Controller;

import com.trustcoodes.jobAppSimpleLogic.ReviewLayer.Entity.ReviewEntity;
import com.trustcoodes.jobAppSimpleLogic.ReviewLayer.Service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public ResponseEntity<List<ReviewEntity>> findAllReview(@RequestParam Long companyId){
        return new ResponseEntity<>(reviewService.findAllReview(companyId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addReview(@RequestParam Long companyId, @RequestBody ReviewEntity reviewEntity){
        boolean reviewIsAdded = reviewService.addReview(companyId, reviewEntity);
        if (reviewIsAdded) {
            return new ResponseEntity<>("Review Added to Id attached", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Review Not Added To ID attached", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{reviewEntityId}")
    public ResponseEntity<ReviewEntity> findReviewById(@PathVariable Long reviewEntityId){

        return new ResponseEntity<>(reviewService
                .findReviewById(reviewEntityId), HttpStatus.OK);
    }

    @PutMapping("/{reviewEntityId}")
    public ResponseEntity<String> updateReviewId(@RequestBody ReviewEntity reviewEntity,
                                                 @PathVariable Long reviewEntityId){

        boolean checkingReviewUpdate = reviewService.updateReviewById(reviewEntity, reviewEntityId);
        if (checkingReviewUpdate){
            return new ResponseEntity<>("Review Fetched and Updated, Thanks", HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>("ERROR: Review NOT Updated, Not Found on DB", HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/{reviewEntityId}")
    public ResponseEntity<String> deleteByReviewId(@PathVariable Long reviewEntityId){

        boolean reviewRemoved = reviewService.removeReviewById(reviewEntityId);
        if (reviewRemoved){
            return new ResponseEntity<>("Review Deleted Successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Info Not Found on Database",HttpStatus.NOT_FOUND);
        }
    }
}