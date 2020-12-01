package com.xcynice.memorykeeper.module.study.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;

import com.gyf.immersionbar.ImmersionBar;
import com.xcynice.memorykeeper.R;
import com.xcynice.memorykeeper.base.BaseActivity;
import com.xcynice.memorykeeper.base.BasePresenter;
import com.xcynice.memorykeeper.bean.Card;
import com.xcynice.memorykeeper.bean.CardBag;
import com.xcynice.memorykeeper.bean.CardList;
import com.xcynice.memorykeeper.bean.ResponseCard;
import com.xcynice.memorykeeper.module.study.adapter.CardAdapter;
import com.xcynice.memorykeeper.module.study.presenter.StudyCardPresenter;
import com.xcynice.memorykeeper.module.study.view.IStudyCardView;
import com.xcynice.memorykeeper.util.LogUtil;
import com.xcynice.memorykeeper.util.ToastUtil;

import java.util.ArrayList;
import java.util.List;

public class StudyCardActivity extends BaseActivity<StudyCardPresenter> implements IStudyCardView, BaseQuickAdapter.RequestLoadMoreListener {


    private RecyclerView mCardRv;
    private CardAdapter mAdapter;
    private List<ResponseCard> mCardList = new ArrayList<>();
    private ConstraintLayout mConstraintLayout;


    private  CardBag cardBag;

    //上一次加载的数量，方便进行是否加载到最后一页的判断： if (mCurrentCounter < TOTAL_COUNTER)
    private int mCurrentCounter;

    /**
     * 每一次加载的数量
     */
    private final static int SINGLE_PAGE_TOTAL_COUNTER = 5;

    /**
     * 记录分页，方便进行加载更多
     */
    private int mPage = 1;
    /**
     * 创建 presenter
     *
     * @return presenter
     */

    @Override
    protected StudyCardPresenter createPresenter() {

        return new StudyCardPresenter(this);

    }

    /**
     * 得到布局文件 id
     *
     * @return layout id
     */
    @Override
    protected int getLayoutId() {
        return R.layout.activity_study_card;
    }

    /**
     * 初始化布局
     */
    @Override
    protected void initView() {
        mConstraintLayout = findViewById(R.id.constraintLayout);

        mCardRv = findViewById(R.id.card_rv);
        ImmersionBar.with(this).titleBar(mConstraintLayout).init();
        Bundle bundle = this.getIntent().getExtras();
        if (bundle != null) {
            cardBag = (CardBag) bundle.getSerializable("cardBag");
        }

        mAdapter = new CardAdapter(R.layout.item_card);
        mAdapter.setEnableLoadMore(true);

        mCardRv.setLayoutManager(new LinearLayoutManager(this));
        mAdapter.setOnLoadMoreListener(this,mCardRv);
        mCardRv.setAdapter(mAdapter);

        //item点击事件
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener(){

            @Override
            public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                ResponseCard card = mCardList.get(i);
                bundle.putSerializable("card",card);
//                bundle.putString("id",cardBag.getCardBagId());
                intent.putExtras(bundle);
                intent.setClass(StudyCardActivity.this, CardActivity.class);
                startActivity(intent);
            }
        });


        mAdapter.setOnItemLongClickListener(new BaseQuickAdapter.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(@NonNull BaseQuickAdapter adapter, @NonNull View view, int position) {
                presenter.deleteCard(mCardList.get(position).getCardId());
                mCardList.remove(position);
                mAdapter.setNewData(mCardList);
                return true;
            }
        });


    }

    /**
     * 初始化数据
     */
    @Override
    protected void initData() {
        presenter.getCardFirst(cardBag.getCardBagId()); //初始化数据，第一次获取卡包

    }



    @Override
    public void getCardFirstSuccess(CardList cardList) {
        mCardList = cardList.getList();
        LogUtil.d("StudyCardActivity",String.valueOf(mCardList.size()));
        mCurrentCounter = cardList.getList().size();
        mPage = 1;
        mAdapter.setNewData(cardList.getList());
    }

    @Override
    public void getCardMoreSuccess(CardList cardBagList) {

        mCurrentCounter = cardBagList.getList().size();
        mAdapter.addData(cardBagList.getList());
        mAdapter.loadMoreComplete();
    }

    @Override
    public void getCardFail(String msg) {
        ToastUtil.showToast(msg);
    }

    @Override
    public void deleteSuccess(String msg) {
        ToastUtil.showToast(msg);
    }

    @Override
    public void deleteFailure(String msg) {
        ToastUtil.showToast(msg);
    }

    @Override
    public void onLoadMoreRequested() {
        if (mCurrentCounter < SINGLE_PAGE_TOTAL_COUNTER) {
            //数据加载完毕，没有更多的数据
            mAdapter.loadMoreEnd();
        } else {
            presenter.getCardMore(cardBag.getCardBagId(),++mPage);
        }
    }
}