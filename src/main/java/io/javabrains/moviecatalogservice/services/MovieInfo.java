package io.javabrains.moviecatalogservice.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import io.javabrains.moviecatalogservice.model.Rating;
import io.javabrains.moviecatalogservice.model.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class MovieInfo {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallbackUserRating",
        commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"), // timeout
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"), // last n request, last 5 request
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"), // if 50% of n number of request fails
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000") // How long circuitBreaker sleeps before it picks up again
        })
    public UserRating getUserRating(String userId) {
        return restTemplate.getForObject("http://localhost:8083/ratingsdata/user/" + userId, UserRating.class);
    }

    public UserRating getFallbackUserRating(@PathVariable("userId") String userId) {
        return new UserRating(Arrays.asList(new Rating("0", 0)));
    }

}
