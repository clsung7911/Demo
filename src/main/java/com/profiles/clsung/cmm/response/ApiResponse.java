package com.profiles.clsung.cmm.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ApiResponse<T> {

    private int code = 0;
    private String message = "";
    private T data = null;

    public ApiResponse(int code, String message, T data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ApiResponse(int code, String message){
        this.code = code;
        this.message = message;
    }
}
