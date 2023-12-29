package com.profiles.clsung.cmm.response.code;

public enum CodeMessage {
    SUCCESS_OK(200, "성공"),
    SUCCESS_CREATED(201, "생성"),
    ERROR_BAD_REQUEST(400, "BAD REQUEST"),
    ERROR_FORBIDDEN(403, "FORBIDDEN ERROR"),
    ERROR_NOT_FOUND(404, "NOT_FOUND"),
    ERROR_INTERNAL_SERVER(500, "INTERNAL_SERVER")
    ;

    public int code;
    public String message;

    CodeMessage(int code, String message){
        this.code = code;
        this.message = message;
    }
}
