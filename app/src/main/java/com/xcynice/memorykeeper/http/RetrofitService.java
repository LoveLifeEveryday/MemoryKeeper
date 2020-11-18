package com.xcynice.memorykeeper.http;


import com.xcynice.memorykeeper.http.gson.BaseConverterFactory;

import okhttp3.OkHttpClient;
import ren.yale.android.retrofitcachelibrx2.RetrofitCache;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * @Author 许朋友爱玩
 * @Date 2020/10/11 20:02
 * @Github https://github.com/LoveLifeEveryday
 * @JueJin https://juejin.im/user/5e429bbc5188254967066d1b/posts
 * @Description RetrofitService
 */

public class RetrofitService {

    private volatile static RetrofitService apiRetrofit;
    private API.IFarmApi apiServer;

    /**
     * 单例调用
     *
     * @return RetrofitService
     */
    public static RetrofitService getInstance() {
        if (apiRetrofit == null) {
            synchronized (Object.class) {
                if (apiRetrofit == null) {
                    apiRetrofit = new RetrofitService();
                }
            }
        }
        return apiRetrofit;
    }


    /**
     * 获取api对象
     *
     * @return api对象
     */
    public API.IFarmApi getApiService() {
        return apiServer;
    }


    /**
     * 初始化retrofit
     */
    private RetrofitService() {

        OkHttpClient okHttpClient = Okhttp3Client.getInstance().getOkHttpClient();

        //关联okHttp并加上rxJava和Gson的配置和baseUrl
        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(BaseConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(API.BASE_URL)
                .build();
        RetrofitCache.getInstance().addRetrofit(retrofit);
        apiServer = retrofit.create(API.IFarmApi.class);
    }
}
