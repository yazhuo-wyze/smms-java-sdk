package com.github.yazhuo.reponse;

public class ResponseBase<T> {

    private boolean success;

    private String code;

    private String message;

    private String RequestId;

    private T data;

    public ResponseBase() {
    }

    public ResponseBase(final boolean success, final String code, final String message, final String requestId, final T data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.RequestId = requestId;
        this.data = data;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(final boolean success) {
        this.success = success;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(final String code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public String getRequestId() {
        return this.RequestId;
    }

    public void setRequestId(final String requestId) {
        this.RequestId = requestId;
    }

    public T getData() {
        return this.data;
    }

    public void setData(final T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseBase{" +
                "success=" + this.success +
                ", code='" + this.code + '\'' +
                ", message='" + this.message + '\'' +
                ", RequestId='" + this.RequestId + '\'' +
                ", data=" + this.data +
                '}';
    }
}
