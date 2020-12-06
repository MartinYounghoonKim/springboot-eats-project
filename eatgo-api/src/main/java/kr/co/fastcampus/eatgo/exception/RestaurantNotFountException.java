package kr.co.fastcampus.eatgo.exception;

public class RestaurantNotFountException extends RuntimeException {

    public RestaurantNotFountException(Long id) {
        super("Could not find restaurant " + id);
    }
}
