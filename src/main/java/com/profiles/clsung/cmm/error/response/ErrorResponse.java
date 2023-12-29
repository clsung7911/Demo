package com.profiles.clsung.cmm.error.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.ConstraintViolation;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.FieldError;

import java.util.List;

@Getter
@Builder
@RequiredArgsConstructor
public class ErrorResponse {
    private final int code;
    private final String status;
    private final String message;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private final List<ValidationError> errors;

    @Getter
    @Builder
    @RequiredArgsConstructor
    public static class ValidationError {
        private final String field;
        private final String message;

        public static ValidationError of(final FieldError fieldError) {
            return ValidationError.builder()
                    .field(fieldError.getField())
                    .message(fieldError.getDefaultMessage())
                    .build();
        }

//        public static ValidationError of(final ConstraintViolation<?> violation) {
//            final String propertyPath = violation.getPropertyPath().toString();
//
//            return ValidationError.builder()
//                    .field(StringUtils.substringAfterLast(propertyPath, "."))
//                    .message(violation.getMessage())
//                    .build();
//        }
    }

}
