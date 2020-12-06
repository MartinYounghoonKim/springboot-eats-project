package kr.co.fastcampus.eatgo.exception.controller;

import kr.co.fastcampus.eatgo.exception.RestaurantNotFountException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class RestaurantControllerAdvice {

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(RestaurantNotFountException.class)
    public String restaurantNotFountExceptionHandler (RestaurantNotFountException exception) {
        return exception.getMessage();
    }

}
