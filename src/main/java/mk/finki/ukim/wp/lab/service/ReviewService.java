package mk.finki.ukim.wp.lab.service;

import mk.finki.ukim.wp.lab.model.Review;

import java.util.Optional;

public interface ReviewService {
    Optional<Review> findAllBy(String score);
}
