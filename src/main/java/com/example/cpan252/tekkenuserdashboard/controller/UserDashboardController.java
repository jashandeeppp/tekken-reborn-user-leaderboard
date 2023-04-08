package com.example.cpan252.tekkenuserdashboard.controller;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import com.example.cpan252.tekkenuserdashboard.model.TekkenUser;

@RestController
@RequestMapping("/api/userdashboard")
public class UserDashboardController {
    
    // private RestTemplate restTemplate;

    // public UserDashboardController(RestTemplate restTemplate){
    //     this.restTemplate = restTemplate;
    // }

    // @GetMapping     // this method will return response Entity esentially it will used in REst Template. Response Entity will transfer out response.
    // public ResponseEntity<PostDto[]> getPosts() {
    //     // we do getForEntity and we specify the response type,so getForEntity in RestTemplate it retrives an entity by doing a getRequest on a specified URL and we also convert a request to Response Entity.
    //     // restTemplate allows us to consume restAPI from the different Urls, by using getEntity we do two things in a row, first of all we consume API data in a Json format from the below url. Second we convert into Post DTO class.
    //     // By using restTemplate we can build multiple Api for our need and we can use or exchange the data from them.
    //     return restTemplate.getForEntity("https://jsonplaceholder.typicode.com/posts", PostDto[].class);
    // }

    @GetMapping
    public List<TekkenUser> getUsers() {
        // var usersStream = List.of(new TekkenUser("Bob", 10, 6, 1, false),
        //         new TekkenUser("Brad", 11, 5, 1, false),
        //         new TekkenUser("Joel", 10, 6, 3, false));


        // We made a Stream of Users and then we used usersStreamSorted and we performed functions on Stream and we convert it into List in the end. 
        // We used Stream because it is very powerful. 
        var usersStream = Stream.of(new TekkenUser("Bob", 10, 6, 1, false),
        new TekkenUser("Brad", 11, 5, 1, false),
        new TekkenUser("Joel", 10, 6, 3, false));
        return usersStream.sorted(Comparator.comparing(TekkenUser::getWins)).collect(Collectors.toList());
    }

}
  