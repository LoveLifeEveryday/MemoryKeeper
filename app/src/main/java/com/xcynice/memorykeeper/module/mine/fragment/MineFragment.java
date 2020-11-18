package com.xcynice.memorykeeper.module.mine.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gyf.immersionbar.ImmersionBar;
import com.xcynice.memorykeeper.R;
import com.xcynice.memorykeeper.base.BaseFragment;
import com.xcynice.memorykeeper.bean.UserInfo;
import com.xcynice.memorykeeper.module.mine.activity.LoginActivity;
import com.xcynice.memorykeeper.module.mine.activity.MineInfoActivity;
import com.xcynice.memorykeeper.module.mine.presenter.MinePresenter;
import com.xcynice.memorykeeper.module.mine.view.IMineView;
import com.xcynice.memorykeeper.util.ActivityUtil;
import com.xcynice.memorykeeper.util.SpUtil;
import com.xcynice.memorykeeper.util.ToastUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @Author 许朋友爱玩
 * @Date 2020/11/8
 * @Github https://github.com/LoveLifeEveryday
 * @JueJin https://juejin.im/user/5e429bbc5188254967066d1b/posts
 * @Description MineFragment
 */


public class MineFragment extends BaseFragment<MinePresenter> implements IMineView {
    @BindView(R.id.title_bar)
    LinearLayout mLlTitle;
    @BindView(R.id.title_bar_return)
    ImageView mIvBack;
    @BindView(R.id.tv_name)
    TextView mTvName;

    @BindView(R.id.rl_mine_card_bag)
    RelativeLayout mRlCardBag;
    @BindView(R.id.rl_mine_collect)
    RelativeLayout mRlCollect;
    @BindView(R.id.ll_head)
    LinearLayout mLlHead;

    @Override
    protected MinePresenter createPresenter() {
        return new MinePresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initView() {
        mIvBack.setVisibility(View.INVISIBLE);
        ImmersionBar.with(this).titleBar(mLlTitle).init();
        //如果还没有登陆
        if (!SpUtil.getBoolean(SpUtil.IS_LOGIN)) {
            mTvName.setText("登陆/注册");
        } else {
            //如果已经登陆
            presenter.test();
        }
    }


    @Override
    public void onResume() {
        super.onResume();
        if (!SpUtil.getBoolean(SpUtil.IS_LOGIN)) {
            mTvName.setText("登陆/注册");
        } else {
            //如果已经登陆
            presenter.test();
        }
    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.rl_mine_card_bag, R.id.rl_mine_collect, R.id.ll_head})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_mine_card_bag:
                ToastUtil.showToast("跳转到我的卡包");
                break;
            case R.id.rl_mine_collect:
                ToastUtil.showToast("跳转到我的收藏");
                break;
            case R.id.ll_head:
                if (SpUtil.getBoolean(SpUtil.IS_LOGIN)) {
                    ActivityUtil.startActivity(MineInfoActivity.class);
                } else {
                    ActivityUtil.startActivity(LoginActivity.class);
                }
                break;
            default:
                break;
        }
    }


    @Override
    public void getUserInfoFail(String msg) {
        ToastUtil.showToast(msg);
    }

    @Override
    public void getUserInfoSuccess(UserInfo test) {
        mTvName.setText(test.getUserName());
    }
}