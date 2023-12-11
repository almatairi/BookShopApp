package mk.finki.ukim.wp.lab.service.impl;

import mk.finki.ukim.wp.lab.model.Review;
import mk.finki.ukim.wp.lab.repository.jpa.ReviewRepository;
import mk.finki.ukim.wp.lab.service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {
    final private ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Optional<Review> findAllBy(String score) {
        return this.reviewRepository.findAllBy(score) ;
    }
}
