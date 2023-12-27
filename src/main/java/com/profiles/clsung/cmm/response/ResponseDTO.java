package com.profiles.clsung.cmm.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResponseDTO<T> {
    private final ResponseStatus status;
    private final ResponseCode code;
    private final String message;
    private final T data;
}
