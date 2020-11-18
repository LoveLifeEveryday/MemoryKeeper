package com.xcynice.memorykeeper.module.mine.activity;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.gyf.immersionbar.ImmersionBar;
import com.xcynice.memorykeeper.R;
import com.xcynice.memorykeeper.base.BaseActivity;
import com.xcynice.memorykeeper.bean.CardBag;
import com.xcynice.memorykeeper.bean.CardBagList;
import com.xcynice.memorykeeper.module.mine.adapter.MineCardBagAdapter;
import com.xcynice.memorykeeper.module.mine.presenter.MineCardBagPresenter;
import com.xcynice.memorykeeper.module.mine.view.IMineCardBagView;
import com.xcynice.memorykeeper.util.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author xucanyou666
 * @date 2020/11/18
 * @github https://github.com/LoveLifeEveryday
 * @juejin https://juejin.im/user/325111175192590/posts
 * @description : MineCardBagActivity
 */


public class MineCardBagActivity extends BaseActivity<MineCardBagPresenter> implements IMineCardBagView, BaseQuickAdapter.RequestLoadMoreListener {
    @BindView(R.id.title_bar)
    LinearLayout mLlTitle;
    @BindView(R.id.title_bar_return)
    ImageView mIvBack;
    @BindView(R.id.title_bar_text)
    TextView mTvTitle;

    @BindView(R.id.rv_card_bag)
    RecyclerView mRvCardBag;

    private MineCardBagAdapter mAdapter;
    private List<CardBag> mCardBagList = new ArrayList<>();
    /**
     * 上一次加载的数量，方便进行是否加载到最后一页的判断： if (mCurrentCounter < TOTAL_COUNTER)
     */
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
    protected MineCardBagPresenter createPresenter() {
        return new MineCardBagPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_mine_card_bag;
    }

    @Override
    protected void initView() {
        mTvTitle.setText("我的卡包");
        ImmersionBar.with(this).titleBar(mLlTitle).init();

        mAdapter = new MineCardBagAdapter(R.layout.item_card_bag);
        mAdapter.setEnableLoadMore(true);


        mAdapter.setOnLoadMoreListener(this, mRvCardBag);

        mRvCardBag.setLayoutManager(new LinearLayoutManager(this));
        mRvCardBag.setAdapter(mAdapter);
    }

    @Override
    protected void initData() {
        presenter.getCardBagFirst();
    }

    @OnClick(R.id.title_bar_return)
    public void back() {
        finish();
    }


    @Override
    public void getCardBagFirstSuccess(CardBagList cardBagList) {
        mCardBagList = cardBagList.getList();
        mCurrentCounter = cardBagList.getList().size();
        mPage = 1;
        mAdapter.setNewData(cardBagList.getList());
    }

    @Override
    public void getCardBagMoreSuccess(CardBagList cardBagList) {
        mCurrentCounter = cardBagList.getList().size();
        mAdapter.addData(cardBagList.getList());
        mAdapter.loadMoreComplete();
    }

    @Override
    public void getCardBagFail(String msg) {
        ToastUtil.showToast(msg);
        mAdapter.loadMoreFail();
    }

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