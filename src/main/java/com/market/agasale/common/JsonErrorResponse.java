package com.market.agasale.common;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class JsonErrorResponse {
    private String message;
    private int status;

    public JsonErrorResponse(String message, int status) {
        this.message = message;
        this.status = status;
    }

}
