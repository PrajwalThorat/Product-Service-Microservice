package com.fitnesszone.productservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.CONFLICT, reason = "Specified program already exist")
public class ProgramAlreadyExistException extends Exception {
}
