package com.example.ecommerce.project.Controller;

import com.example.ecommerce.project.Entity.Reviews;
import com.example.ecommerce.project.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
    @PutMapping("/updatereview")
    public void updateCategory(@RequestBody Reviews reviews){
        reviewService.updateRatingById(reviews.getReview_id(),reviews.getRating());
    }
    @GetMapping("/getreviews")
    public List<Reviews> getreviews(){
        return reviewService.getAllReviews();
    }
    @DeleteMapping("/deletereview")
    public void deletereview(@RequestBody Reviews reviews) {
        reviewService.deleteReviewsById(reviews.getReview_id());
    }
    @GetMapping("/getreview/{id}")
    public List<Reviews> getReviewById(@PathVariable("id") Integer id){
        return reviewService.getReviewsById(id);
    }
    @PostMapping("/addReview")
    public void postDetails(@RequestBody Reviews reviews){
        reviewService.addReview(reviews.getUser_id(),reviews.getProduct_id(),reviews.getRating()
                ,reviews.getComment());
    }
}
