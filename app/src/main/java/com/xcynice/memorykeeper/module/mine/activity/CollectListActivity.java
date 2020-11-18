package com.xcynice.memorykeeper.module.mine.activity;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gyf.immersionbar.ImmersionBar;
import com.xcynice.memorykeeper.R;
import com.xcynice.memorykeeper.base.BaseActivity;
import com.xcynice.memorykeeper.bean.CollectList;
import com.xcynice.memorykeeper.module.mine.adapter.CollectListAdapter;
import com.xcynice.memorykeeper.module.mine.presenter.CollectListPresenter;
import com.xcynice.memorykeeper.module.mine.view.IMineCollectView;
import com.xcynice.memorykeeper.util.ToastUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author xucanyou666
 * @date 2020/11/18
 * @github https://github.com/LoveLifeEveryday
 * @juejin https://juejin.im/user/325111175192590/posts
 * @description : CollectListActivity
 */


public class CollectListActivity extends BaseActivity<CollectListPresenter> implements IMineCollectView {


    @BindView(R.id.title_bar)
    LinearLayout mLlTitle;
    @BindView(R.id.title_bar_return)
    ImageView mIvBack;
    @BindView(R.id.title_bar_text)
    TextView mTvTitle;
    @BindView(R.id.rv_collect)
    RecyclerView mRvCollect;
    CollectListAdapter mAdapter;

    @Override
    protected CollectListPresenter createPresenter() {
        return new CollectListPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_collect_list;
    }

    @Override
    protected void initView() {
        mTvTitle.setText("我的收藏");
        ImmersionBar.with(this).titleBar(mLlTitle).init();

        mAdapter = new CollectListAdapter(R.layout.item_collect);
        mRvCollect.setLayoutManager(new LinearLayoutManager(this));
        mRvCollect.setAdapter(mAdapter);
    }

    @Override
    protected void initData() {
        presenter.getMineCollectList();
    }


    @Override
    public void getMineCollectSuccess(CollectList collectList) {
        mAdapter.setNewData(collectList.getList());
    }

    @Override
    public void getMineCollectFail(String msg) {
        ToastUtil.showToast(msg);
    }

    @OnClick(R.id.title_bar_return)
    public void back() {
        finish();
    }

}