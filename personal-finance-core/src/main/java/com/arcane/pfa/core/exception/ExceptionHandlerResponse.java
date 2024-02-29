package com.arcane.pfa.core.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionHandlerResponse {
    private String message;
    private int errorCode;
    private String possibleResolution;
}
