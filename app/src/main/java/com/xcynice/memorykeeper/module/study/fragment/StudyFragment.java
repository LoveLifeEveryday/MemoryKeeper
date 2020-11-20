package com.xcynice.memorykeeper.module.study.fragment;


import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.widget.ImageView;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.xcynice.memorykeeper.R;
import com.xcynice.memorykeeper.base.BaseBean;
import com.xcynice.memorykeeper.base.BaseFragment;
import com.xcynice.memorykeeper.bean.CardBag;
import com.xcynice.memorykeeper.bean.CardBagList;
import com.xcynice.memorykeeper.module.study.fragment.CardBagAdapter;
import com.xcynice.memorykeeper.module.study.presenter.StudyPresenter;
import com.xcynice.memorykeeper.module.study.view.IStudyView;
import com.xcynice.memorykeeper.util.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


/**
 * @author Yuki-r
 * @date on 2020/11/17
 * @describle  学习界面的fragment
 */

public class StudyFragment extends BaseFragment<StudyPresenter> implements  IStudyView, BaseQuickAdapter.RequestLoadMoreListener {
    @BindView(R.id.card_bag_rv)
    RecyclerView mCardBagRv;
    @BindView(R.id.refresh_iv)
    ImageView mRefreshIv;

    private CardBagAdapter mAdapter;
    private List<CardBag> mCardBagList = new ArrayList<>();

    //上一次加载的数量，方便进行是否加载到最后一页的判断： if (mCurrentCounter < TOTAL_COUNTER)
    private int mCurrentCounter;

    /**
     * 每一次加载的数量
     */
    private final static int SINGLE_PAGE_TOTAL_COUNTER = 10;

    /**
     * 记录分页，方便进行加载更多
     */
    private int mPage = 1;

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

        mAdapter = new CardBagAdapter(R.layout.item_card_bag);
        mAdapter.setEnableLoadMore(true);

        mCardBagRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter.setOnLoadMoreListener(this,mCardBagRv);
        mCardBagRv.setAdapter(mAdapter);
    }

    @Override
    protected void initData() {
        presenter.getCardBagFirst(); //初始化数据，第一次获取卡包

    }

    /**
     *  第一次设置数据成功
     * @param cardBagList
     */
    @Override
    public void getCardBagFirstSuccess(CardBagList cardBagList) {
        mCardBagList = cardBagList.getList();
        mCurrentCounter = cardBagList.getList().size();
        mPage = 1;
        mAdapter.setNewData(cardBagList.getList());

    }

    /**
     * 加载更多数据成功
     * @param cardBagList
     */
    @Override
    public void getCardBagMoreSuccess(CardBagList cardBagList) {
        mCurrentCounter = cardBagList.getList().size();
        mAdapter.addData(cardBagList.getList());
        mAdapter.loadMoreComplete();
    }

    /**
     * 获取卡包数据失败
     * @param msg
     */
    @Override
    public void getCardBagFail(String msg) {
        ToastUtil.showToast("加载数据失败："+msg);
    }

    /**
     * 加载更多数据
     */
    @Override
    public void onLoadMoreRequested() {
        if (mCurrentCounter < SINGLE_PAGE_TOTAL_COUNTER) {
            //数据加载完毕，没有更多的数据
            mAdapter.loadMoreEnd();
        } else {
            presenter.getCardBagMore(++mPage);
        }
    }
}