package br.com.HabitTracker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidHabitException extends RuntimeException {

    public InvalidHabitException(String message) {
        super(message);
    }
}
