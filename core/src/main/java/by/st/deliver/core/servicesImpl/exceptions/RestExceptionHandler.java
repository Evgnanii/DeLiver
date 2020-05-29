package by.st.deliver.core.servicesImpl.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NoSuchDataExceptionQ.class)
    public ResponseEntity<Object> handleNoSuchDataException(NoSuchDataExceptionQ c) {
        ErrorMessage errorMessage = new ErrorMessage(new Date(), c.getMessage());
        return new ResponseEntity(errorMessage, new HttpHeaders(), HttpStatus.NOT_FOUND);
    } @ExceptionHandler(MinRatingException.class)
    public ResponseEntity<Object> handleMinRatingException(MinRatingException c) {
        ErrorMessage errorMessage = new ErrorMessage(new Date(), c.getMessage());
        return new ResponseEntity(errorMessage, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoDataException.class)
    public ResponseEntity<Object> handleNoDataException(NoDataException c) {
        ErrorMessage errorMessage = new ErrorMessage(new Date(), c.getMessage());
        return new ResponseEntity(errorMessage, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DataAlreadyExistException.class)
    public ResponseEntity<Object> handleDataExistsException(DataAlreadyExistException c) {
        ErrorMessage errorMessage = new ErrorMessage(new Date(), c.getMessage());
        return new ResponseEntity(errorMessage, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BadRequestBodyException.class)
    public ResponseEntity<Object> handleBadRequestBodyException(BadRequestBodyException c) {
        ErrorMessage errorMessage = new ErrorMessage(new Date(), c.getMessage());
        return new ResponseEntity(errorMessage, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }


}
