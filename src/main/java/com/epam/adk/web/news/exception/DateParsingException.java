package com.epam.adk.web.news.exception;

/**
 * TODO: Comment
 * <p>
 * Created on 5/17/2017.
 *
 * @author Kaikenov Adilkhan
 */
public class DateParsingException extends Exception {

    public DateParsingException(Throwable cause) {
        super(cause);
    }

    public DateParsingException(String message) {
        super(message);
    }

    public DateParsingException(String message, Throwable cause) {
        super(message, cause);
    }
}
