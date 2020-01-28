package com.chaapu.springstarter.exceptions;

import org.springframework.http.HttpStatus;

public class ErrorResponse {

    private HttpStatus status;

    private int errorCode;

    private String message;

    private ErrorResponse() {
    }

    public static class ErrorResponseBuilder {
        private HttpStatus status;

        private int errorCode;

        private String message;

        public ErrorResponseBuilder() {
        }

        public ErrorResponseBuilder withStatus(HttpStatus status) {
            this.status = status;
            return this;
        }

        public ErrorResponseBuilder withErrorCode(int errorCode) {
            this.errorCode = errorCode;
            return this;
        }

        public ErrorResponseBuilder withMessage(String message) {
            this.message = message;
            return this;
        }

        public ErrorResponse build() {
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.status = this.status;
            errorResponse.errorCode = this.errorCode;
            errorResponse.message = this.message;
            return errorResponse;
        }
    }
}
