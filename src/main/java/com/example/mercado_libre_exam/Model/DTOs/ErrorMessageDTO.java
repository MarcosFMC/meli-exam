package com.example.mercado_libre_exam.Model.DTOs;

public class ErrorMessageDTO {
    private String errorMessage;
    public ErrorMessageDTO(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
