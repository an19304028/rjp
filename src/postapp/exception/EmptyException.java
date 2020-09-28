package postapp.exception;

import javax.servlet.ServletException;

public class EmptyException extends ServletException {
    public EmptyException(String s) {
        super(s);
    }
}