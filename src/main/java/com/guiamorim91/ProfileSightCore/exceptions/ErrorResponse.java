package com.guiamorim91.ProfileSightCore.exceptions;

import lombok.Data;

@Data
public class ErrorResponse {

    private int status;

    private String message;

    private long timestamp;

}