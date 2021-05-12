package io.javabrains.moviecatalogservice.resources;

import io.javabrains.moviecatalogservice.model.CatalogItem;
import io.javabrains.moviecatalogservice.model.Movie;
import io.javabrains.moviecatalogservice.model.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

  @Autowired private RestTemplate restTemplate;

  @Autowired WebClient.Builder webClientBuilder;

  @RequestMapping("/{userId}")
  public List<CatalogItem> getCatalog(@PathVariable String userId) {

    UserRating userRating = restTemplate.getForObject("RATING-DATA-SERVICE/ratingsdata/user/" + userId, UserRating.class);

    return userRating.getRatings().stream().map(rating -> {
              Movie movie = restTemplate.getForObject("MOVIE-INFO-SERVICE/movies/" + rating.getMovieId(), Movie.class);
              return new CatalogItem(movie.getName(), "Test Description", rating.getRating());
            })
        .collect(Collectors.toList());
  }
}