package io.javabrains.moviecatalogservice.resources;

import io.javabrains.moviecatalogservice.model.CatalogItem;
import io.javabrains.moviecatalogservice.model.Movie;
import io.javabrains.moviecatalogservice.model.Rating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

  @GetMapping("/{userId}")
  public List<CatalogItem> getCatalog(@PathVariable String userId) {

    RestTemplate restTemplate = new RestTemplate();
    Movie movie = restTemplate.getForObject("http://localhost:8082/movies/12", Movie.class);

    List<Rating> ratings = Arrays.asList(
            new Rating("1234", 4),
            new Rating("5678", 3));

    return ratings.stream()
        .map(rating -> new CatalogItem("Transformers", "Test", 4))
        .collect(Collectors.toList());
  }
}
