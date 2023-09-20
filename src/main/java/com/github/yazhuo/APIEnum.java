package com.github.yazhuo;

public enum APIEnum {

    API_TOKEN("POST", "token"),
    USER_PROFILE("POST", "profile"),
    CLEAR("GET", "clear"),
    HISTORY("GET", "history"),
    DELETION("GET", "delete/:hash"),
    UPLOAD_HISTORY("GET", "upload_history"),
    UPLOAD("POST", "upload");

    final String method;

    final String uri;

    APIEnum(final String method, final String uri) {
        this.method = method;
        this.uri = uri;
    }
}
