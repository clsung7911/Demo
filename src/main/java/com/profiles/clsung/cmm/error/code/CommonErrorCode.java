package com.profiles.clsung.cmm.error.code;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum CommonErrorCode implements ErrorCode{
    INVALID_PARAMETER(400, HttpStatus.BAD_REQUEST, "Invalid parameter Included"),
    RESOURCE_NOT_FOUND(404, HttpStatus.NOT_FOUND, "Cannot find resource"),
    INTERNAL_SERVER_ERROR(500, HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error"),
    ;

    private final int code;
    private final HttpStatus httpStatus;
    private final String message;


    @Override
    public int code() {
        int code = this.code;
        return code;
    }
}
