package com.jobapplication.jobapplication.review;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> getAllReviews(Long companyId){

        return reviewRepository.findByCompanyId(companyId);

    }
}
