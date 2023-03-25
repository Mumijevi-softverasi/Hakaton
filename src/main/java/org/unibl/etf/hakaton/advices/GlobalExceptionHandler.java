package org.unibl.etf.hakaton.advices;

import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.unibl.etf.hakaton.exceptions.NotApprovedException;
import org.unibl.etf.hakaton.exceptions.NotFoundException;

import java.io.IOException;

public class GlobalExceptionHandler {


    @ExceptionHandler(NotApprovedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public void handleNotApprovedException(){

    }
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleNotFoundException(){

    }




}
