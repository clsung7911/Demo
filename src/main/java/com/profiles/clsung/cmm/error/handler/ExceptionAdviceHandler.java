package com.profiles.clsung.cmm.error.handler;

import com.profiles.clsung.cmm.error.code.CommonErrorCode;
import com.profiles.clsung.cmm.error.code.ErrorCode;
import com.profiles.clsung.cmm.error.exception.RestApiException;
import com.profiles.clsung.cmm.error.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
@Slf4j
public class ExceptionAdviceHandler extends ResponseEntityExceptionHandler {
    /**
     * IllegalArgumentException 처리시
     * @param e
     * @return
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleIllegalArgument(final IllegalArgumentException e) {
        log.warn("handleIllegalArgument", e);
        final ErrorCode errorCode = CommonErrorCode.INVALID_PARAMETER;
        return handleExceptionInternal(errorCode, e.getMessage());
    }

    /**
     * Exception 처리시
     * @param ex
     * @return
     */
//    @ExceptionHandler({Exception.class})
//    public ResponseEntity<Object> handleAllException(final Exception ex) {
//        log.warn("handleAllException", ex);
//        final ErrorCode errorCode = CommonErrorCode.INTERNAL_SERVER_ERROR;
//        return handleExceptionInternal(errorCode);
//    }

    @ExceptionHandler(RestApiException.class)
    public ResponseEntity<Object> handleRestApiException(final RestApiException ex) {
        log.warn("handleRestApiException", ex);
        final ErrorCode errorCode = ex.getErrorCode();
        return handleExceptionInternal(errorCode, ex.getMessage());
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<Object> handleNullPointerException(final NullPointerException ex) {
        log.warn("handleNullPointerException", ex);
        final ErrorCode errorCode = CommonErrorCode.RESOURCE_NOT_FOUND;
        return handleExceptionInternal(errorCode, ex.getMessage());
    }

    private ResponseEntity<Object> handleExceptionInternal(final ErrorCode errorCode) {
        return ResponseEntity.status(errorCode.getHttpStatus())
                .body(makeErrorResponse(errorCode));
    }

    private ErrorResponse makeErrorResponse(final ErrorCode errorCode) {
        return ErrorResponse.builder()
                .code(errorCode.code())
                .status(errorCode.name())
                .message(errorCode.getMessage())
                .build();
    }

    private ResponseEntity<Object> handleExceptionInternal(final ErrorCode errorCode, final String message) {
        return ResponseEntity.status(errorCode.getHttpStatus())
                .body(makeErrorResponse(errorCode, message));
    }

    private ErrorResponse makeErrorResponse(final ErrorCode errorCode, final String message) {
        return ErrorResponse.builder()
                .code(errorCode.code())
                .status(errorCode.name())
                .message(message)
                .build();
    }

    private ResponseEntity<Object> handleExceptionInternal(final BindException e, final ErrorCode errorCode) {
        return ResponseEntity.status(errorCode.getHttpStatus())
                .body(makeErrorResponse(e, errorCode));
    }

    private ErrorResponse makeErrorResponse(final BindException e, final ErrorCode errorCode) {
        final List<ErrorResponse.ValidationError> validationErrorList = e.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(ErrorResponse.ValidationError::of)
                .collect(Collectors.toList());

        return ErrorResponse.builder()
                .code(errorCode.code())
                .status(errorCode.name())
                .message(errorCode.getMessage())
                .errors(validationErrorList)
                .build();
    }
}
