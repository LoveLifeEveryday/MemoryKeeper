package com.xcynice.memorykeeper.module.main.listener;


import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * @Author 许朋友爱玩
 * @Date 2020/7/27 20:37
 * @Github https://github.com/LoveLifeEveryday
 * @JueJin https://juejin.im/user/5e429bbc5188254967066d1b/posts
 * @Description MainVpListener vp 的监听器
 */

public class MainVpListener implements ViewPager.OnPageChangeListener {
    BottomNavigationView mBnvMain;

    public MainVpListener(BottomNavigationView bnv) {
        mBnvMain = bnv;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
        mBnvMain.getMenu().getItem(position).setChecked(true);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
