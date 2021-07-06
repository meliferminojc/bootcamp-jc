package br.com.meli.linktracker.exception;

public class InvalidLinkException extends RuntimeException {
    public InvalidLinkException(String msg) {
        super(msg);
    }

    public InvalidLinkException(Exception e) {
        super(e);
    }
}
