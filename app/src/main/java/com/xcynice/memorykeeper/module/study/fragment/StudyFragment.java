package com.xcynice.memorykeeper.module.study.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.xcynice.memorykeeper.R;
import com.xcynice.memorykeeper.base.BaseBean;
import com.xcynice.memorykeeper.base.BaseFragment;
import com.xcynice.memorykeeper.base.BasePresenter;
import com.xcynice.memorykeeper.bean.CardBag;
import com.xcynice.memorykeeper.bean.CardBagList;
import com.xcynice.memorykeeper.module.CreateBag.presenter.CreateBagPresenter;
import com.xcynice.memorykeeper.module.CreateBag.view.ICreateBagView;
import com.xcynice.memorykeeper.module.study.presenter.StudyPresenter;
import com.xcynice.memorykeeper.module.study.view.IStudyView;

import butterknife.BindView;


/**
 * @author Yuki-r
 * @date on 2020/11/17
 * @describle  学习界面的fragment
 */

public class StudyFragment extends BaseFragment<StudyPresenter> implements  IStudyView {

    @BindView(R.id.card_bag_rv)
    ImageView mRefreshIv;
    @BindView(R.id.refresh_iv)
    RecyclerView mCardBagRv;


    @Override
    protected StudyPresenter createPresenter() {
        return new StudyPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_study;
    }

    @Override
    protected void initView() {
       mRefreshIv.setOnClickListener(new View.OnClickListener() {

           @Override
           public void onClick(View v) {

           }
       });
    }

    @Override
    protected void initData() {
        presenter.getCardBagFirst(); //初始化数据，第一次获取卡包

    }


    /**
     * 第一次设置卡包数据
     *
     * @param cardBagList 卡包集合
     */
    @Override
    public void setCardBagListFirst(BaseBean<CardBagList> cardBagList) {

    }

    /**
     * 用刷新的方法设置卡包数据
     *
     * @param list 卡包集合
     */
    @Override
    public void setCardBagRefresh(BaseBean<CardBagList> list) {

    }

    /**
     * 设置卡包数据失败
     *
     * @param errorMsg 错误信息
     */
    @Override
    public void setCardBagError(String errorMsg) {

    }

    /**
     * 用加载更多的方式设置卡包数据
     *
     * @param list 卡包数据
     */
    @Override
    public void setCardBagByMore(BaseBean<CardBagList> list) {

    }

    /**
     * 加载更多失败
     *
     * @param errorMsg 失败信息
     */
    @Override
    public void showCardBagErrorMore(String errorMsg) {

    }
}