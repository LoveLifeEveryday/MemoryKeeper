package com.xcynice.memorykeeper.module.main.listener;


import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.xcynice.memorykeeper.R;

/**
 * @Author 许朋友爱玩
 * @Date 2020/6/1 12:00
 * @Github https://github.com/LoveLifeEveryday
 * @JueJin https://juejin.im/user/5e429bbc5188254967066d1b/posts
 * @Description MainBnvListener
 */

public class MainBnvListener implements BottomNavigationView.OnNavigationItemSelectedListener {
    private ViewPager mViewPager;

    public MainBnvListener(ViewPager viewPager) {
        mViewPager = viewPager;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_study:
                mViewPager.setCurrentItem(0);
                return true;
            case R.id.navigation_create_bag:
                mViewPager.setCurrentItem(1);
                return true;
            case R.id.navigation_mine:
                mViewPager.setCurrentItem(2);
                return true;
            default:
                break;
        }
        return false;
    }
}
