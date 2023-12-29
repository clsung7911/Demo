package com.profiles.clsung.cmm.error.code;

import org.springframework.http.HttpStatus;

public interface ErrorCode {
    int code();
    String name();
    HttpStatus getHttpStatus();
    String getMessage();
}
