package com.github.yazhuo.reponse;

public class ResponseApiToken {

    private String token;

    public ResponseApiToken(final String token) {
        this.token = token;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(final String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "ResponseApiToken{" +
                "token='" + this.token + '\'' +
                '}';
    }
}
