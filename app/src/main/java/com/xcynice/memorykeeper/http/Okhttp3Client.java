package com.xcynice.memorykeeper.http;

import android.util.Log;

import com.xcynice.memorykeeper.util.ActivityUtil;
import com.xcynice.memorykeeper.util.SpUtil;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import ren.yale.android.retrofitcachelibrx2.intercept.CacheForceInterceptorNoNet;
import ren.yale.android.retrofitcachelibrx2.intercept.CacheInterceptorOnNet;

import static com.xcynice.memorykeeper.util.SpUtil.COOKIE;
import static com.xcynice.memorykeeper.util.SpUtil.IS_LOGIN;

/**
 * @author 梁爽
 * @create 2020/8/9 11:29
 */
public class Okhttp3Client {
    private volatile static Okhttp3Client okhttp3Client;
    private OkHttpClient okHttpClient;

    /**
     * 单例调用
     *
     * @return RetrofitService
     */
    public static Okhttp3Client getInstance() {
        if (okhttp3Client == null) {
            synchronized (Object.class) {
                if (okhttp3Client == null) {
                    okhttp3Client = new Okhttp3Client();
                }
            }
        }
        return okhttp3Client;
    }

    /**
     * 获取OkHttpClient对象
     *
     * @return 获取OkHttpClient对象
     */
    public OkHttpClient getOkHttpClient() {
        return okHttpClient;
    }


    public Okhttp3Client() {
        //配置缓存 200m
        int cacheSize = 200 * 1024 * 1024;
        @SuppressWarnings("AliDeprecation") File cacheFile = new File(ActivityUtil.getCurrentActivity().getCacheDir(), "cache");
        if (!cacheFile.exists()) {
            //noinspection ResultOfMethodCallIgnored
            cacheFile.mkdirs();
        }
        Cache cache = new Cache(cacheFile, cacheSize);

        //配置okHttp并设置时间、日志信息和cookies
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(message -> {
            try {
                String text = URLDecoder.decode(message, "utf-8");
                Log.e("OKHttp-----", text);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                Log.e("OKHttp-----", message);
            }
        });
        interceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);

        this.okHttpClient = new OkHttpClient.Builder()
                .cache(cache)
                .addInterceptor(interceptor)
                .addInterceptor(new CacheForceInterceptorNoNet())
                //响应拦截cookie
                .addNetworkInterceptor(chain -> {
                    Response originalResponse = chain.proceed(chain.request());
                    //这里获取请求返回的cookie
                    //noinspection AlibabaUndefineMagicConstant
                    if (!SpUtil.getBoolean(IS_LOGIN) && !originalResponse.headers("Set-Cookie").isEmpty()) {
                        //noinspection AlibabaUndefineMagicConstant
                        SpUtil.setString(COOKIE, originalResponse.headers("Set-Cookie").get(0));
                    }
                    return originalResponse;
                })
                .addNetworkInterceptor(new CacheInterceptorOnNet())
                //请求添加cookie
                .addNetworkInterceptor(chain -> {
                    Request request;
                    if (!SpUtil.getString(COOKIE).isEmpty()) {
                        request = chain.request().newBuilder().addHeader("Cookie",
                                SpUtil.getString(COOKIE)).build();
                    } else {
                        request = chain.request().newBuilder().build();
                    }
                    return chain.proceed(request);
                })
                .connectTimeout(15, TimeUnit.SECONDS)

                .build();
    }

}
