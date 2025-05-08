package com.example.UserAuthenticationSpringBoot.model;

public class AuthenticationResponse {
    private String jwt;
    private String error;

    public AuthenticationResponse(String jwt, String error) {
        this.jwt = jwt;
        this.error = error;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
