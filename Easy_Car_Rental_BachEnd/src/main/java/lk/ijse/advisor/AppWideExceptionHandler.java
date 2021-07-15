package lk.ijse.advisor;


import lk.ijse.exception.NotFoundException;
import lk.ijse.exception.ValidateException;
import lk.ijse.util.StandradResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
@CrossOrigin
public class AppWideExceptionHandler {

//    client case = 400;
//    server case = 500;

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleException(Exception e) {
        return new ResponseEntity(new StandradResponse("500", "Error", e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity handleNotFoundException(NotFoundException e) {
        return new ResponseEntity(new StandradResponse("404", "Error", e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ValidateException.class)
    public ResponseEntity handleValidationException(ValidateException e) {
        return new ResponseEntity(new StandradResponse("400", "Error", e.getMessage()), HttpStatus.BAD_REQUEST);
    }


}
