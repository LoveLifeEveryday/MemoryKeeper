package com.xcynice.memorykeeper.http;


import com.xcynice.memorykeeper.R;
import com.xcynice.memorykeeper.base.BaseBean;
import com.xcynice.memorykeeper.bean.CardBag;
import com.xcynice.memorykeeper.bean.CardBagList;
import com.xcynice.memorykeeper.bean.CollectList;
import com.xcynice.memorykeeper.bean.UserInfo;
import com.xcynice.memorykeeper.util.XUtil;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * @Author 许朋友爱玩
 * @Date 2020/11/8 17:42
 * @Github https://github.com/LoveLifeEveryday
 * @JueJin https://juejin.im/user/5e429bbc5188254967066d1b/posts
 * @Description TODO
 */

public class API {

    static final String BASE_URL = XUtil.getApplication().getString(R.string.baseUrl);

    @SuppressWarnings("AlibabaClassNamingShouldBeCamel")
    public interface IFarmApi {

        //----------------【卡包相关】-------------------

        /**
         * 新建卡包
         *
         * @param cardBag 卡包实例
         * @return
         */

        @POST("cardBag/add")
        Observable<BaseBean<CardBag>> createNewCardBag(@Body CardBag cardBag);

        /**
         * 分页获取自己的所有卡包
         *
         * @param pageSize 页数，默认为5
         * @param pageNum  页码，默认为1
         * @return
         */
        @GET("cardBag/getMyBag")
        Observable<BaseBean<CardBagList>> getCardBagList(@Query("pageSize") String pageSize, @Query("pageNum") String pageNum);

        /**
         * 登陆
         *
         * @param password 密码
         * @param phone    手机号
         * @param code     code
         * @return 是否登陆成功
         */
        @POST("user/login")
        Observable<BaseBean<String>> login(@Query("password") String password, @Query("phone") String phone, @Query("code") String code);


        @GET("user/checkLogin")
        Observable<BaseBean<UserInfo>> getUserInfo();


        @GET("collect/get")
        Observable<BaseBean<CollectList>> getMineCollect(@Query("pageSize") String pageSize,@Query("pageNum") String pageNum);

    }

}
