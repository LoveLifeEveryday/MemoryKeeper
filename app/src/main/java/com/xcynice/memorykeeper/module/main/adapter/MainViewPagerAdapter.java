package com.xcynice.memorykeeper.module.main.adapter;


import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.xcynice.memorykeeper.R;
import com.xcynice.memorykeeper.module.CreateBag.CreateBagFragment;
import com.xcynice.memorykeeper.module.mine.MineFragment;
import com.xcynice.memorykeeper.module.study.StudyFragment;
import com.xcynice.memorykeeper.util.XUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 许朋友爱玩
 * @Date 2020/6/1 10:55
 * @Github https://github.com/LoveLifeEveryday
 * @JueJin https://juejin.im/user/5e429bbc5188254967066d1b/posts
 * @Description main vp 的 adapter
 */

public class MainViewPagerAdapter extends FragmentStatePagerAdapter {

    private static final int VIEWPAGER_COUNT = 3;
    private List<String> mTitleList = new ArrayList<>();
    private BottomNavigationView mBottomNavigationView;

    public MainViewPagerAdapter(@NonNull FragmentManager fm, BottomNavigationView bottomNavigationView) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mBottomNavigationView = bottomNavigationView;
        mTitleList.add(XUtil.getApplication().getString(R.string.study));
        mTitleList.add(XUtil.getApplication().getString(R.string.create_bag));
        mTitleList.add(XUtil.getApplication().getString(R.string.mine));
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                mBottomNavigationView.setVisibility(View.VISIBLE);
                return new StudyFragment();
            case 1:
                mBottomNavigationView.setVisibility(View.GONE);
                return new CreateBagFragment();
            case 2:
                mBottomNavigationView.setVisibility(View.VISIBLE);
                return new MineFragment();
            default:
                //noinspection ConstantConditions
                return null;
        }
    }

    @Override
    public int getCount() {
        return VIEWPAGER_COUNT;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitleList.get(position);
    }
}
