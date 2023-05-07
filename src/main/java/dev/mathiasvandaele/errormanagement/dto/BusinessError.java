package dev.mathiasvandaele.errormanagement.dto;

import lombok.Builder;

@Builder
public class BusinessError {

    public final Integer code;
    public final String message;
    public final String advice;
}
