package com.github.yazhuo;

import cn.hutool.http.HttpInterceptor;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;

public class HttpResponseInterceptor implements HttpInterceptor<HttpResponse> {
    @Override
    public void process(final HttpResponse response) {
        if (response.getStatus() != 200) {
            throw new RuntimeException("http status error = " + response.getStatus());
        }

        if (!JSONUtil.isTypeJSON(response.body())) {
            throw new RuntimeException("http response body parse json error , response text : " + response.body());
        }

        final JSON json = JSONUtil.parse(response.body());
        final Boolean success = JSONUtil.getByPath(json, "success", false);
        if (!success) {
            throw new RuntimeException("http request error , message : " + JSONUtil.getByPath(json, "message", "false"));
        }
    }
}
