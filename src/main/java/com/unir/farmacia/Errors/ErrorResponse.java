package com.unir.farmacia.Errors;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ErrorResponse {
    private int status;
    private String message;
    private Date timestamp;
    List<ErrorField> errors;
    ErrorResponse (String message){
        this.message=message;
    }
    
    public void setError(List<ErrorField> errores) {
        errors=errores;
    }
}