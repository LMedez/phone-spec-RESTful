package com.luc.phonespecs.exceptions;

import com.google.firebase.ErrorCode;
import com.google.firebase.FirebaseException;

public class ConcurrentException extends RuntimeException {
    public ConcurrentException(String message) {
        super(message);
    }
}
