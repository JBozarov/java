package io.javabrains.moviecatalogservice.resources;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.javabrains.moviecatalogservice.model.CatalogItem;
import io.javabrains.moviecatalogservice.model.Movie;
import io.javabrains.moviecatalogservice.model.Rating;
import io.javabrains.moviecatalogservice.model.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

  @Autowired private RestTemplate restTemplate;
  @Autowired WebClient.Builder webClientBuilder;

  @GetMapping("/{userId}")
  @HystrixCommand(fallbackMethod = "getFallbackCatalog")
  public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
    UserRating userRating = getUserRating(userId);
    return userRating.getRatings().stream().map(this::getCatalogItem).collect(Collectors.toList());
  }

  public List<CatalogItem> getFallbackCatalog(@PathVariable("userId") String userId) {
    return Arrays.asList(new CatalogItem("No movie", "", 0));
  }



  @HystrixCommand(fallbackMethod = "getFallbackCatalogItem")
  private CatalogItem getCatalogItem(io.javabrains.moviecatalogservice.model.Rating rating) {
    Movie movie = restTemplate.getForObject("http://localhost:8082/movies/" + rating.getMovieId(), Movie.class);
    return new CatalogItem(movie.getName(), "Test Description", rating.getRating());
  }

  private CatalogItem getFallbackCatalogItem(Rating rating) {
    return null;
  }



  @HystrixCommand(fallbackMethod = "getFallbackUserRating")
  private UserRating getUserRating(String userId) {
    return restTemplate.getForObject("http://localhost:8083/ratingsdata/user/" + userId, UserRating.class);
  }

  private UserRating getFallbackUserRating(@PathVariable("userId") String userId) {
    return null;
  }

}
