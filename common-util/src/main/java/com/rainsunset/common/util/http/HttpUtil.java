package com.rainsunset.common.util.http;

import com.rainsunset.common.util.http.okhttp.OKHttpFactory;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * @description: http连接工具类
 * @author: ligangwei
 * @company rainsunset
 * @date: 2019.03.27
 * @version : 1.0
 */
public class HttpUtil {
    private final static Logger log = LoggerFactory.getLogger(HttpUtil.class);

    //region 同步请求

    /**
     * HTTP 同步GET请求
     *
     * @param url url
     * @return String string
     * @throws IOException the io exception
     * @author : ligangwei / 2019-09-24
     */
    public static String httpGetString(String url) throws IOException {
        return httpGetString(url, null, null);
    }

    /**
     * HTTP 同步GET请求
     *
     * @param url     url
     * @param headers header
     * @param params  请求参数
     * @return String string
     * @throws IOException the io exception
     * @author : ligangwei / 2019-09-24
     */
    public static String httpGetString(String url, Map<String, String> headers, Map<String, String> params) throws
            IOException {
        Response response = httpGetResponse(url, headers, params);
        if (response.isSuccessful()) {
            String responseBody = response.body().string();
            log.info(">>> httpGetString Sucessed[responseBody:{}]", responseBody);
            return responseBody;
        }
        return null;
    }

    /**
     * HTTP 同步GET请求
     *
     * @param url url
     * @return inputStream input stream
     * @throws IOException the io exception
     * @author : ligangwei / 2019-09-24
     */
    public static InputStream httpGetInputStream(String url) throws IOException {
        return httpGetInputStream(url, null, null);
    }

    /**
     * HTTP 同步GET请求
     *
     * @param url     url
     * @param headers header
     * @param params  请求参数
     * @return inputStream input stream
     * @throws IOException the io exception
     * @author : ligangwei / 2019-09-24
     */
    public static InputStream httpGetInputStream(String url, Map<String, String> headers, Map<String, String> params) throws
            IOException {
        Response response = httpGetResponse(url, headers, params);
        if (response.isSuccessful()) {
            InputStream responseBody = response.body().byteStream();
            log.info(">>> httpGetString Sucessed");
            return responseBody;
        }
        return null;
    }

    /**
     * HTTP 同步GET请求
     *
     * @param url     url
     * @param headers header
     * @param params  请求参数
     * @return response response
     * @throws IOException the io exception
     * @author : ligangwei / 2019-09-24
     */
    public static Response httpGetResponse(String url, Map<String, String> headers, Map<String, String> params) throws
            IOException {
        String logId = buildLogId();
        Long currentTime = System.currentTimeMillis();
        log.info(">>> httpGetResponse Start[logId:{},url:{},headers:{},params:{}]", logId, url, headers, params);
        OkHttpClient okHttpClient = OKHttpFactory.INSTANCE.getOkHttpClient();
        Request.Builder builder = buildHanderAndUrl(url, params, headers);
        Response response = okHttpClient.newCall(builder.build()).execute();
        log.info(">>> httpGetResponse End[logId:{},response:{},costTime:{}ms]", logId, response, System.currentTimeMillis() - currentTime);
        return response;
    }

    /**
     * HTTP 同步POST请求
     *
     * @param url       url
     * @param mediaType Content-Type
     * @param postBody  请求体(字符串)
     * @return String string
     * @throws IOException the io exception
     * @author : ligangwei / 2019-09-24
     */
    public static String httpPostString(String url, String mediaType, String postBody) throws IOException {
        return httpPostString(url, mediaType, postBody, null, null);
    }

    /**
     * HTTP 同步POST请求
     *
     * @param url       url
     * @param mediaType Content-Type
     * @param postBody  请求体(字符串)
     * @param params    the params
     * @param headers   header
     * @return String string
     * @throws IOException the io exception
     * @author : ligangwei / 2019-09-24
     */
    public static String httpPostString(String url, String mediaType, String postBody, Map<String, String> params, Map<String, String> headers) throws
            IOException {
        String logId = buildLogId();
        Long currentTime = System.currentTimeMillis();
        log.info(">>> httpPostString Start[logId:{},url:{},mediaType:{},postBody:{},params:{},headers:{}]",
                logId, url, mediaType, postBody, params, headers);
        MediaType mime = MediaType.parse(mediaType);
        if (mime == null) {
            log.error(">>> httpPostString Media type parse failed[mediaType:{}]", mediaType);
            return null;
        }
        OkHttpClient okHttpClient = OKHttpFactory.INSTANCE.getOkHttpClient();
        Request.Builder builder = buildHanderAndUrl(url, params, headers);
        RequestBody requestBody = RequestBody.create(postBody.getBytes(),mime);
        builder.post(requestBody);
        Response response = okHttpClient.newCall(builder.build()).execute();
        log.info(">>> httpPostString End[logId:{},response:{},costTime:{}ms]", logId, response, System.currentTimeMillis() - currentTime);
        if (response.isSuccessful()) {
            String responseBody = response.body().string();
            log.info(">>> httpPostString Sucessed[logId:{},responseBody:{}]", logId, responseBody);
            return responseBody;
        }
        return null;
    }

    /**
     * HTTP 同步POST请求
     *
     * @param url       url
     * @param mediaType Content-Type
     * @param postBody  请求体(字节流)
     * @return String string
     * @throws IOException the io exception
     * @author : ligangwei / 2019-09-24
     */
    public static String httpPostStream(String url, String mediaType, byte[] postBody) throws IOException {
        return httpPostStream(url, mediaType, postBody, null, null);
    }

    /**
     * HTTP 同步POST请求
     *
     * @param url       url
     * @param mediaType Content-Type
     * @param postBody  请求体(字节流)
     * @param params    the params
     * @param headers   header
     * @return String string
     * @throws IOException the io exception
     * @author : ligangwei / 2019-09-24
     */
    public static String httpPostStream(String url, String mediaType, byte[] postBody, Map<String, String> params, Map<String, String> headers) throws
            IOException {
        String logId = buildLogId();
        Long currentTime = System.currentTimeMillis();
        log.info(">>> httpPostStream Start[logId:{},url:{},mediaType:{},params:{},headers:{}]", logId, url, mediaType, params, headers);
        MediaType mime = MediaType.parse(mediaType);
        if (mime == null) {
            log.info(">>> httpPostStream Media type parse failed[mediaType:{}]", mediaType);
            return null;
        }
        OkHttpClient okHttpClient = OKHttpFactory.INSTANCE.getOkHttpClient();
        Request.Builder builder = buildHanderAndUrl(url, params, headers);
        RequestBody requestBody = RequestBody.create(postBody,mime);
        builder.post(requestBody);
        Response response = okHttpClient.newCall(builder.build()).execute();
        log.info(">>> httpPostStream End[logId:{},response:{},costTime:{}ms]", logId, response, System.currentTimeMillis() - currentTime);
        if (response.isSuccessful()) {
            String responseBody = response.body().string();
            log.info(">>> httpPostStream Sucessed[logId:{},responseBody:{}]", logId, responseBody);
            return responseBody;
        }
        return null;
    }

    /**
     * HTTP 同步POST请求
     *
     * @param url       url
     * @param mediaType Content-Type
     * @param file      请求体(文件)
     * @return String string
     * @throws IOException the io exception
     * @author : ligangwei / 2019-09-24
     */
    public static String httpPostFile(String url, String mediaType, File file) throws IOException {
        return httpPostFile(url, mediaType, file, null, null);
    }

    /**
     * HTTP 同步POST请求
     *
     * @param url       url
     * @param mediaType Content-Type
     * @param file      请求体(文件)
     * @param params    the params
     * @param headers   header
     * @return String string
     * @throws IOException the io exception
     * @author : ligangwei / 2019-09-24
     */
    public static String httpPostFile(String url, String mediaType, File file, Map<String, String> params, Map<String, String> headers) throws
            IOException {
        String logId = buildLogId();
        Long currentTime = System.currentTimeMillis();
        log.info(">>> httpPostFile Start[logId:{},url:{},mediaType:{},params:{},headers:{}]", logId, url, mediaType, params, headers);
        MediaType mime = MediaType.parse(mediaType);
        if (mime == null) {
            log.info(">>> Media type parse failed[mediaType:{}]", mediaType);
            return null;
        }
        OkHttpClient okHttpClient = OKHttpFactory.INSTANCE.getOkHttpClient();
        Request.Builder builder = buildHanderAndUrl(url, params, headers);
        RequestBody requestBody = RequestBody.create(file,mime);
        builder.post(requestBody);
        Response response = okHttpClient.newCall(builder.build()).execute();
        log.info(">>> httpPostFile End[logId:{},response:{},costTime:{}ms]", logId, response, System.currentTimeMillis() - currentTime);
        if (response.isSuccessful()) {
            String responseBody = response.body().string();
            log.info(">>> httpPostFile Sucessed[logId:{},responseBody:{}]", logId, responseBody);
            return responseBody;
        }
        return null;
    }

    /**
     * HTTP 同步POST请求
     *
     * @param url      url
     * @param formData 请求体(表单)
     * @return String string
     * @throws IOException the io exception
     * @author : ligangwei / 2019-09-24
     */
    public static String httpPostForm(String url, Map<String, String> formData) throws IOException {
        return httpPostForm(url, formData, null, null);
    }

    /**
     * HTTP 同步POST请求
     *
     * @param url      url
     * @param formData 请求体(表单)
     * @param params   the params
     * @param headers  header
     * @return String string
     * @throws IOException the io exception
     * @author : ligangwei / 2019-09-24
     */
    public static String httpPostForm(String url, Map<String, String> formData, Map<String, String> params, Map<String, String> headers) throws
            IOException {
        String logId = buildLogId();
        Long currentTime = System.currentTimeMillis();
        log.info(">>> httpPostForm Start[logId:{},url:{},formData:{},params:{},headers:{}]", logId, url, formData, params, headers);
        OkHttpClient okHttpClient = OKHttpFactory.INSTANCE.getOkHttpClient();
        Request.Builder builder = buildHanderAndUrl(url, params, headers);
        FormBody.Builder formBodyBuilder = new FormBody.Builder();
        if (formData != null && formData.size() > 0) {
            for (Map.Entry<String, String> entry : formData.entrySet()) {
                formBodyBuilder.add(entry.getKey(), entry.getValue());
            }
        }
        FormBody requestBody = formBodyBuilder.build();
        builder.post(requestBody);
        Response response = okHttpClient.newCall(builder.build()).execute();
        log.info(">>> httpPostForm End[logId:{},response:{},costTime:{}ms]", logId, response, System.currentTimeMillis() - currentTime);
        if (response.isSuccessful()) {
            String responseBody = response.body().string();
            log.info(">>> httpPostForm Sucessed[logId:{},responseBody:{}]", logId, responseBody);
            return responseBody;
        }
        return null;
    }

    /**
     * HTTP 同步POST请求
     *
     * @param url      url
     * @param postBody 请求体(多请求块)                 通过MultipartBody.Builder的addFormDataPart构造请求体
     * @return String string
     * @throws IOException the io exception
     * @author : ligangwei / 2019-09-24
     */
    public static String httpPostMultiPart(String url, MultipartBody postBody) throws IOException {
        return httpPostMultiPart(url, postBody, null, null);
    }

    /**
     * HTTP 同步POST请求
     *
     * @param url      url
     * @param postBody 请求体(多请求块)                 通过MultipartBody.Builder的addFormDataPart构造请求体
     * @param params   the params
     * @param headers  header
     * @return String string
     * @throws IOException the io exception
     * @author : ligangwei / 2019-09-24
     */
    public static String httpPostMultiPart(String url, MultipartBody postBody, Map<String, String> params, Map<String, String> headers) throws
            IOException {
        String logId = buildLogId();
        Long currentTime = System.currentTimeMillis();
        log.info(">>> httpPostMultiPart Start[logId:{},url:{},postBody:{},params:{},headers:{}]", logId, url, postBody, params, headers);
        OkHttpClient okHttpClient = OKHttpFactory.INSTANCE.getOkHttpClient();
        Request.Builder builder = buildHanderAndUrl(url, params, headers);
        builder.post(postBody);
        Response response = okHttpClient.newCall(builder.build()).execute();
        log.info(">>> httpPostMultiPart End[logId:{},response:{},costTime:{}ms]", logId, response, System.currentTimeMillis() - currentTime);
        if (response.isSuccessful()) {
            String responseBody = response.body().string();
            log.info(">>> httpPostMultiPart Sucessed[logId:{},responseBody:{}]", logId, responseBody);
            return responseBody;
        }
        return null;
    }

    /**
     * Build hander and url request . builder.
     *
     * @param url     the url
     * @param params  the params
     * @param headers the headers
     * @return the request . builder
     * @author : ligangwei / 2019-09-24
     */
    private static Request.Builder buildHanderAndUrl(String url, Map<String, String> params, Map<String, String> headers) {
        //Header
        Request.Builder builder = new Request.Builder();
        if (headers != null && headers.size() > 0) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                builder.addHeader(entry.getKey(), entry.getValue());
            }
        }
        //URL
        StringBuilder urlBuilder = new StringBuilder(url);
        if (params != null && params.size() > 0) {
            urlBuilder.append("?");
            for (Map.Entry<String, String> entry : params.entrySet()) {
                urlBuilder.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
            urlBuilder.substring(0, urlBuilder.length() - 1);
        }
        builder.url(urlBuilder.toString());
        return builder;
    }
    //endregion

    //region 异步请求
    //TODO:异步请求封装
    //endregion
	
	/**
     * 构建日志id
     *
     * @return the string
     * @author : ligangwei / 2019-11-21 16:25:03
     */
    private static String buildLogId() {
        String logId = Thread.currentThread().getId() + "_" + System.currentTimeMillis();
        return logId;
    }
}
