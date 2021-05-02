package io.javabrains.moviecatalogservice.resources;

import io.javabrains.moviecatalogservice.model.CatalogItem;
import io.javabrains.moviecatalogservice.model.Movie;
import io.javabrains.moviecatalogservice.model.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

  @Autowired private RestTemplate restTemplate;

  @Autowired WebClient.Builder webClientBuilder;

  @GetMapping("/{userId}")
  public List<CatalogItem> getCatalog(@PathVariable String userId) {

    List<Rating> ratings = Arrays.asList(new Rating("1234", 4), new Rating("5678", 3));

    return ratings.stream()
        .map(
            rating -> {
              // Movie movie = restTemplate.getForObject("http://localhost:8082/movies/" + rating.getMovieId(), Movie.class);

                Movie movie = webClientBuilder.build()
                        .get()
                        .uri("http://localhost:8082/movies/" + rating.getMovieId())
                        .retrieve()
                        .bodyToMono(Movie.class)
                        .block();

              return new CatalogItem(movie.getName(), "Test", rating.getRating());
            })
        .collect(Collectors.toList());
  }
}
