package com.xcynice.memorykeeper.module.main.activity;

import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.xcynice.memorykeeper.R;
import com.xcynice.memorykeeper.base.BaseActivity;
import com.xcynice.memorykeeper.base.BasePresenter;
import com.xcynice.memorykeeper.module.main.adapter.MainViewPagerAdapter;
import com.xcynice.memorykeeper.module.main.listener.MainBnvListener;
import com.xcynice.memorykeeper.module.main.listener.MainVpListener;
import com.xcynice.memorykeeper.util.ActivityUtil;
import com.xcynice.memorykeeper.util.ToastUtil;

import butterknife.BindView;


/**
 * @Author 许朋友爱玩
 * @Date 2020/11/8
 * @Github https://github.com/LoveLifeEveryday
 * @JueJin https://juejin.im/user/5e429bbc5188254967066d1b/posts
 * @Description MainActivity
 */


public class MainActivity extends BaseActivity {

    @BindView(R.id.vp_main)
    ViewPager mVpMain;
    @BindView(R.id.bnv_main)
    BottomNavigationView mBnvMain;


    private static final int OVER_TIME = 2000;

    /**
     * 保存用户按返回键的时间
     */
    private long mExitTime = 0;

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        initViewPager();
        initListeners();
    }

    @Override
    protected void initData() {

    }


    private void initViewPager() {
        MainViewPagerAdapter adapter = new MainViewPagerAdapter(getSupportFragmentManager());
        mVpMain.setOffscreenPageLimit(2);
        mVpMain.setAdapter(adapter);
    }


    private void initListeners() {
        MainBnvListener bnvListener = new MainBnvListener(mVpMain);
        MainVpListener vpListener = new MainVpListener(mBnvMain);
        mVpMain.addOnPageChangeListener(vpListener);
        mBnvMain.setOnNavigationItemSelectedListener(bnvListener);
    }


    /**
     * 根据当前时间节点判断是否退出,双击退出功能的设置
     */
    @Override
    public void onBackPressed() {
        if ((System.currentTimeMillis() - mExitTime) > OVER_TIME) {
            ToastUtil.showToast(getResources().getString(R.string.double_quit) + getResources().getString(R.string.app_name));
            mExitTime = System.currentTimeMillis();
        } else {
            ActivityUtil.closeAllActivity();
        }
    }
}