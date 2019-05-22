package fr.bemore.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class AnswerNotFindException extends  Exception {

    public AnswerNotFindException(String message){
        super(message);
    }
    public AnswerNotFindException(){
        super();
    }
    public AnswerNotFindException(Exception e){
        super(e);
    }
}
