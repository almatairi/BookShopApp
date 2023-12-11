package mk.finki.ukim.wp.lab.repository.impl;

import mk.finki.ukim.wp.lab.bootstrap.DataHolder;
import mk.finki.ukim.wp.lab.model.Review;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class InMemoryReviewRepository {
    public Optional<Review> findAllBy(String score){
        return DataHolder.reviews.stream().filter(c-> c.getScore().equals(score)).findFirst();
    }
}
