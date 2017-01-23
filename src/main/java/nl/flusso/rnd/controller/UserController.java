package nl.flusso.rnd.controller;

import com.google.common.collect.Lists;
import io.swagger.annotations.ApiParam;
import nl.flusso.rnd.model.User;
import nl.flusso.rnd.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "",
            produces = { "application/json", "text/plain; charset=utf-8" },
            method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseEntity<java.util.List<User>> getUsers()  {
        Iterable<User> usersIterable = userRepository.findAll();
        List<User> users = Lists.newArrayList(usersIterable);
        return ResponseEntity.ok().body(users);
    }

    @RequestMapping(value = "",
            produces = { "application/json", "text/plain; charset=utf-8" },
            method = RequestMethod.POST)
    public
    @ResponseBody
    ResponseEntity<User> newUser(@ApiParam("User to add") @RequestBody User user) {
        String identifier = UUID.randomUUID().toString();
        User response = userRepository.save(user);
        return ResponseEntity.ok().body(response);
    }


    @RequestMapping(value = "/{id}",
            produces = { "application/json", "text/plain; charset=utf-8" },
            method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseEntity<User> getUser(@ApiParam(value = "User ID", required = true) @PathVariable("id") Long id) {
        User response = userRepository.findOne(id);
        return ResponseEntity.ok().body(response);
    }

    /*To Do fix annotations */
    @RequestMapping(value = "/hello",
            produces = { "application/json", "text/plain; charset=utf-8" },
            method = RequestMethod.GET)
    public
    @ResponseBody
    void hello() {
      //  new ScalaService().hello();

        System.out.println("hello world");
    }

    @RequestMapping(value = "/getListings",
            produces = { "application/json", "text/plain; charset=utf-8" },
            method = RequestMethod.POST)
    public
    @ResponseBody
    void getListings(@RequestBody String checkin, @RequestBody String checkout) {

        String s = new String();

        RestTemplate restTemplate = new RestTemplate();

      //  s = restTemplate.getForObject("https://api.airbnb.com/v2/search_results?client_id=3092nxybyb0otqw18e8nh5nty&locale=en-US&currency=USD&_format=for_search_results_with_minimal_pricing&_limit=10&_offset=0&fetch_facets=true&guests=1&ib=false&ib_add_photo_flow=true&location=Lake%20Tahoe%2C%20CA%2C%20US&min_bathrooms=2&min_bedrooms=5&min_beds=1&min_num_pic_urls=10&price_max=210&price_min=40&sort=1&user_lat=37.3398634&user_lng=-122.0455164&checkin=2017-01-24&=checkout=2017-01-27",String.class);

        s = restTemplate.getForObject("https://api.airbnb.com/v2/search_results?client_id=3092nxybyb0otqw18e8nh5nty&locale=en-US&currency=USD&_format=for_search_results_with_minimal_pricing&_limit=10&_offset=0&fetch_facets=true&guests=1&ib=false&ib_add_photo_flow=true&location=Lake%20Tahoe%2C%20CA%2C%20US&min_bathrooms=2&min_bedrooms=5&min_beds=1&min_num_pic_urls=10&price_max=210&price_min=40&sort=1&user_lat=37.3398634&user_lng=-122.0455164&checkin=" + checkin + "&=checkout=" + checkout,String.class);


        log.info(s);

    }




}