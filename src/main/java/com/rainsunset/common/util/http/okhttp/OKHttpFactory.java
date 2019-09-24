package com.rainsunset.common.util.http.okhttp;

import com.rainsunset.common.util.http.okhttp.interceptor.LoggingInterceptor;
import okhttp3.OkHttpClient;

import javax.net.ssl.*;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

import static com.rainsunset.common.util.http.okhttp.OKHttpConfig.*;
import static com.rainsunset.common.util.http.okhttp.interceptor.LoggingInterceptor.Level.NONE;

/**
 *
 * @Author: ligangwei
 * @Company rainsunset
 * @CreateDate: 2019.09.24
 * @Version : 1.0
 */
public enum OKHttpFactory {
    INSTANCE();

    private final OkHttpClient mOkHttpClient;

    OKHttpFactory() {
        LoggingInterceptor loggingInterceptor = new LoggingInterceptor();
        //Set log interceptor level
        loggingInterceptor.setLevel(NONE);

        try {
            // Create a trust manager that does not validate certificate chains
            final TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
                @Override
                public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }

                @Override
                public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }
            }};
            // Install the all-trusting trust manager
            final SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
            // Create an ssl socket factory with our all-trusting manager
            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
            final HostnameVerifier hostnameVerifier = new HostnameVerifier() {
                @Override
                public boolean verify(String s, SSLSession sslSession) {
                    return true;
                }
            };
            mOkHttpClient = new OkHttpClient.Builder()
                    .addNetworkInterceptor(loggingInterceptor)
                    //失败重连
                    .retryOnConnectionFailure(true)
                    .connectTimeout(TIMEOUT_CONNECTION, TimeUnit.SECONDS)
                    .readTimeout(TIMEOUT_READ, TimeUnit.SECONDS)
                    .writeTimeout(TIMEOUT_WRITE, TimeUnit.SECONDS)
                    .sslSocketFactory(sslSocketFactory)
                    .hostnameVerifier(hostnameVerifier)
                    .build();
        } catch (NoSuchAlgorithmException | NoSuchProviderException | KeyManagementException e) {
            e.printStackTrace();
            throw new RuntimeException("OKHttpClient initialization failed");
        }
    }

    public OkHttpClient getOkHttpClient() {
        return mOkHttpClient;
    }
}
