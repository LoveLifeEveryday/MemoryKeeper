package com.xcynice.memorykeeper.http;


import com.xcynice.memorykeeper.R;
import com.xcynice.memorykeeper.base.BaseBean;
import com.xcynice.memorykeeper.bean.Card;
import com.xcynice.memorykeeper.bean.CardBag;
import com.xcynice.memorykeeper.bean.CardBagList;
import com.xcynice.memorykeeper.bean.CardList;
import com.xcynice.memorykeeper.bean.CollectList;
import com.xcynice.memorykeeper.bean.ResponseCard;
import com.xcynice.memorykeeper.bean.UpdateCardBag;
import com.xcynice.memorykeeper.bean.UserInfo;
import com.xcynice.memorykeeper.util.XUtil;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
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
         *
         *  根据id删除卡包
         * @param id
         * @return
         */
        @GET("cardBag/delById")
        Observable<BaseBean<String>> deleteCardBag(@Query("cardBagId") String id);

        /**
         * 更新卡包
         * @param id
         * @return
         */
        @HTTP(method = "POST", path = "cardBag/upDate", hasBody = true)
//        @POST("cardBag/upDate")
        Observable<BaseBean<String>> updateCardBag(@Query("cardBagId") String id,@Body UpdateCardBag cardBag);


        /**
         * 新增卡片
         * @param card
         * @return
         */


        @POST("card/add")
        Observable<BaseBean<ResponseCard>> releaseCardBag(@Body Card card);


        /**
         * 分页获取卡片信息
         * @param id 卡包id
         * @param pageSize 页大小
         * @param pageNum  页数量
         * @return
         */
        @GET("cardBag/get")
        Observable<BaseBean<CardList>> getCardList(@Query("cardBagId")String id,@Query("pageSize") String pageSize, @Query("pageNum") String pageNum);


        /**
         * 删除卡片
         * @param cardId
         * @return
         */

        @POST("card/delById")
        Observable<BaseBean<Integer>> deleteCard(@Query("cardId") String cardId);





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




        /**
         * 注册
         *
         * @param info       用户信息
         * @param repassword 用户密码
         * @param code       验证码
         * @return 用户注册成功数据
         */
        @POST("user/addUser")
        Observable<BaseBean<String>> register(@Body RequestBody info, @Query("repassword") String repassword,
                                              @Query("code") String code);




        /**
         * 改密码
         *
         * @param password   密码
         * @param repassword 再次输入的密码
         * @param phone      手机号
         * @param code       验证码
         * @return 是否改密码成功
         */
        @POST("user/resetPassByPhone")
        Observable<BaseBean<String>> changePassword(@Query("password") String password,
                                                    @Query("repassword") String repassword,
                                                    @Query("phone") String phone,
                                                    @Query("code") String code);

    }

}
