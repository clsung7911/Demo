package com.profiles.clsung.cmm.response;

import com.profiles.clsung.cmm.response.code.CodeMessage;
import org.springframework.http.HttpStatus;

public class ResponseWrapper {
    public static <T> ApiResponse<T> success(T data){
        return new ApiResponse<T>(HttpStatus.OK.value(), CodeMessage.SUCCESS_OK.message, data);
    }

}
