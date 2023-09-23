package com.github.yazhuo;

import cn.hutool.core.lang.TypeReference;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.http.Method;
import cn.hutool.json.JSONUtil;
import com.github.yazhuo.reponse.ImageItem;
import com.github.yazhuo.reponse.ResponseApiToken;
import com.github.yazhuo.reponse.ResponseBase;
import com.github.yazhuo.reponse.ResponseUserProfile;
import java.io.File;
import java.util.List;


public class SMMSClient {

    private final HttpResponseInterceptor responseInterceptor = new HttpResponseInterceptor();
    private String secretToken;

    /**
     * doc : <a href="https://doc.sm.ms/#api-_">...</a>
     *
     * @param secretToken secretToken
     */
    public SMMSClient(final String secretToken) {
        this.secretToken = secretToken;
    }

    /**
     * doc : <a href="https://doc.sm.ms/#api-User-Get_Token">...</a>
     *
     * @param username username
     * @param password password
     */
    public SMMSClient(final String username, final String password) {
        final APIEnum apiToken = APIEnum.API_TOKEN;
        final HttpRequest request = HttpUtil.createRequest(Method.valueOf(apiToken.method), Constants.BASIC_URl + apiToken.uri);
        request.form("username", username);
        request.form("password", password);
        request.header(Header.USER_AGENT.getValue(), Constants.USER_AGENT);
        request.addResponseInterceptor(this.responseInterceptor);

        request.then(httpResponse -> {
            final ResponseBase<ResponseApiToken> responseBase = JSONUtil.toBean(httpResponse.body(), new TypeReference<ResponseBase<ResponseApiToken>>() {
            }, true);
            this.secretToken = responseBase.getData().getToken();
        });
    }

    /**
     * doc : <a href="https://doc.sm.ms/#api-User-Get_Profile">...</a>
     *
     * @return user profile
     */
    public ResponseUserProfile profile() {
        final APIEnum apiEnum = APIEnum.USER_PROFILE;
        final HttpRequest request = HttpUtil.createRequest(Method.valueOf(apiEnum.method), Constants.BASIC_URl + apiEnum.uri);
        request.header(Header.USER_AGENT.getValue(), Constants.USER_AGENT);
        request.auth(this.secretToken);
        request.addResponseInterceptor(this.responseInterceptor);
        try (final HttpResponse response = request.execute()) {
            final ResponseBase<ResponseUserProfile> responseBase = JSONUtil.toBean(response.body(), new TypeReference<ResponseBase<ResponseUserProfile>>() {
            }, true);
            return responseBase.getData();
        }
    }

    /**
     * doc : <a href="https://doc.sm.ms/#api-Image-Clear_Temporary_History">...</a>
     *
     * @return clear
     */
    @Deprecated
    public Boolean clear() {
        final APIEnum apiEnum = APIEnum.CLEAR;
        final HttpRequest request = HttpUtil.createRequest(Method.valueOf(apiEnum.method), Constants.BASIC_URl + apiEnum.uri);
        request.header(Header.USER_AGENT.getValue(), Constants.USER_AGENT);
        request.auth(this.secretToken);
        request.addResponseInterceptor(this.responseInterceptor);
        try (final HttpResponse response = request.execute()) {
            final ResponseBase<List<String>> responseBase = JSONUtil.toBean(response.body(), new TypeReference<ResponseBase<List<String>>>() {
            }, true);
            return responseBase.isSuccess();
        }
    }

    /**
     * doc ； <a href="https://doc.sm.ms/#api-Image-Temporary_History">...</a>
     *
     * @return history
     */
    @Deprecated
    public List<ImageItem> history() {
        final APIEnum apiEnum = APIEnum.HISTORY;
        final HttpRequest request = HttpUtil.createRequest(Method.valueOf(apiEnum.method), Constants.BASIC_URl + apiEnum.uri);
        request.header(Header.USER_AGENT.getValue(), Constants.USER_AGENT);
        request.auth(this.secretToken);
        request.addResponseInterceptor(this.responseInterceptor);
        try (final HttpResponse response = request.execute()) {
            final ResponseBase<List<ImageItem>> responseBase =
                    JSONUtil.toBean(response.body(), new TypeReference<ResponseBase<List<ImageItem>>>() {
                    }, true);
            return responseBase.getData();
        }
    }

    /**
     * doc : <a href="https://doc.sm.ms/#api-Image-Deletion">...</a>
     *
     * @param fileHash fileHash
     * @return delete
     */
    public Boolean delete(final String fileHash) {
        final APIEnum apiEnum = APIEnum.DELETION;
        final HttpRequest request = HttpUtil.createRequest(Method.valueOf(apiEnum.method), (Constants.BASIC_URl + apiEnum.uri).replaceAll(":hash", fileHash));
        request.header(Header.USER_AGENT.getValue(), Constants.USER_AGENT);
        request.auth(this.secretToken);
        request.addResponseInterceptor(this.responseInterceptor);
        try (final HttpResponse response = request.execute()) {
            final ResponseBase<Void> responseBase =
                    JSONUtil.toBean(response.body(), new TypeReference<ResponseBase<Void>>() {
                    }, true);
            return responseBase.isSuccess();
        }
    }

    /**
     * doc : <a href="https://doc.sm.ms/#api-Image-Upload_History">...</a>
     *
     * @return upload history
     */
    public List<ImageItem> uploadHistory() {
        final APIEnum apiEnum = APIEnum.UPLOAD_HISTORY;
        final HttpRequest request = HttpUtil.createRequest(Method.valueOf(apiEnum.method), Constants.BASIC_URl + apiEnum.uri);
        request.header(Header.USER_AGENT.getValue(), Constants.USER_AGENT);
        request.auth(this.secretToken);
        request.addResponseInterceptor(this.responseInterceptor);
        try (final HttpResponse response = request.execute()) {
            final ResponseBase<List<ImageItem>> responseBase =
                    JSONUtil.toBean(response.body(), new TypeReference<ResponseBase<List<ImageItem>>>() {
                    }, true);
            return responseBase.getData();
        }
    }

    /**
     * doc : <a href="https://doc.sm.ms/#api-Image-Upload">...</a>
     *
     * @param file file
     * @return image item
     */
    public ImageItem upload(final File file) {
        final APIEnum apiEnum = APIEnum.UPLOAD;
        final HttpRequest request = HttpUtil.createRequest(Method.valueOf(apiEnum.method), Constants.BASIC_URl + apiEnum.uri);
        request.form("smfile", file);
        request.header(Header.USER_AGENT.getValue(), Constants.USER_AGENT);
        request.auth(this.secretToken);
        request.addResponseInterceptor(this.responseInterceptor);
        try (final HttpResponse response = request.execute()) {
            final ResponseBase<ImageItem> responseBase =
                    JSONUtil.toBean(response.body(), new TypeReference<ResponseBase<ImageItem>>() {
                    }, true);
            return responseBase.getData();
        }
    }
}
