package com.xcynice.memorykeeper.http;


import com.xcynice.memorykeeper.R;
import com.xcynice.memorykeeper.base.BaseBean;
import com.xcynice.memorykeeper.bean.CardBag;
import com.xcynice.memorykeeper.util.XUtil;

import io.reactivex.Observable;
import retrofit2.http.Body;
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
         *  新建卡包
         * @param cardBag 卡包实例
         * @return
         */
        Observable<BaseBean<CardBag>> createNewCardBag(@Body CardBag cardBag);

    }

}
