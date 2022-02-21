package com.hamitmizrak.jwt;

import java.io.Serializable;

public class JwtResponse implements Serializable {
    private static final long serialVersionUID = -8091879091924046844L;

    private final String jwttoken;

    //parametreli constructor
    public JwtResponse(String jwttoken) {
        this.jwttoken = jwttoken;
    }

    //getter
    public String getToken() {
        return this.jwttoken;
    }
}