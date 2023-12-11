package mk.finki.ukim.wp.lab.web.controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import mk.finki.ukim.wp.lab.model.Review;
import mk.finki.ukim.wp.lab.service.ReviewService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/filter")
    public String filteredReviews(LocalDateTime from,
                                  LocalDateTime to,
                                  HttpServletRequest req,
                                  Model model){
        List<Review> filteredReviews = reviewService.filterByDateTimeBetween(from, to);
        model.addAttribute("reviews", filteredReviews);
        return "reviews-filtered";
    }
}
