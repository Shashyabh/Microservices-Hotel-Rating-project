package com.lcwd.user.service.controllers;

import com.lcwd.user.service.entities.User;
import com.lcwd.user.service.services.UserService;
import com.lcwd.user.service.services.impl.UserServiceImpl;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private Logger logger= LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> CreateUser( @RequestBody User user){
        User user1=userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    //Retry

//    int retryCount=1;
//    @GetMapping("/{userId}")
//   // @CircuitBreaker(name="ratingHotelBreaker",fallbackMethod = "ratingHotelFallback")
//    @Retry(name = "ratingHotelService",fallbackMethod = "ratingHotelFallback")
//    public ResponseEntity<User> getSingleUser(@PathVariable  String userId) {
//        logger.info("Get single user Handler : UserController");
//        logger.info("Retry count : {}", retryCount);
//        retryCount++;
//        User user = userService.getUser(userId);
//        return ResponseEntity.ok(user);
//    }

    //Circuit breaker

//    @GetMapping("/{userId}")
//     @CircuitBreaker(name="ratingHotelBreaker",fallbackMethod = "ratingHotelFallback")
//    public ResponseEntity<User> getSingleUser(@PathVariable  String userId){
//        User user = userService.getUser(userId);
//        return ResponseEntity.ok(user);
//    }



    @GetMapping("/{userId}")
    @RateLimiter(name="userRateLimiter",fallbackMethod = "ratingHotelFallback")
    public ResponseEntity<User> getSingleUser(@PathVariable  String userId){
        User user = userService.getUser(userId);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        List<User> allUser= userService.getAllUser();
        return ResponseEntity.ok(allUser);
    }


    //Creating fallback method for circuit breaker
    public ResponseEntity<User> ratingHotelFallback(String userId, Exception ex){
       logger.info("Fallback is executed because service is down : ",ex.getMessage());

        User user=User.builder()
                .email("dummy@gmail.com")
                .name("Dummy")
                .about("This user is dummy becauses some servivces down")
                .userId("1234")
                .build();
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
}
