package br.com.HabitTracker.exception;

import java.util.Date;

public record ExceptionResponse(String message, String details, Date timestamp) {
}
