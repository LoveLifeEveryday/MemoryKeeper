package com.xcynice.memorykeeper.module.main.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.MenuItem;

import androidx.annotation.NonNull;

import androidx.navigation.Navigation;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.xcynice.memorykeeper.R;
import com.xcynice.memorykeeper.base.BaseActivity;
import com.xcynice.memorykeeper.base.BasePresenter;

import com.xcynice.memorykeeper.module.CreateBag.activity.CreateCardActivity;
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

@SuppressLint("NonConstantResourceId")
public class MainActivity extends BaseActivity {

//    @BindView(R.id.vp_main)
//    ViewPager mVpMain;
    @BindView(R.id.bnv_main)
    BottomNavigationView mBnvMain;
    Activity activity = this;


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

        initListeners();




    }

    @Override
    protected void initData() {

    }





    private void initListeners() {
         mBnvMain.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.navigation_study:
                                Navigation.findNavController(activity,R.id.main_nva_graph).navigate(R.id.navigation_study);
                                break;
                            case R.id.navigation_create_bag:
                                Intent intent = new Intent(activity, CreateCardActivity.class);
                                startActivity(intent);
                                break;
                            case R.id.navigation_mine:
                                Navigation.findNavController(activity,R.id.main_nva_graph).navigate(R.id.navigation_mine);
                                break;
                                default:
                                    break;

                        }
                        return true;
                    }
                });
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