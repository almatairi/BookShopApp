package mk.finki.ukim.wp.lab.service;

import mk.finki.ukim.wp.lab.model.Review;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ReviewService {
    Optional<Review> findAllBy(String score);
    List<Review> filterByDateTimeBetween(LocalDateTime from, LocalDateTime to);
}
