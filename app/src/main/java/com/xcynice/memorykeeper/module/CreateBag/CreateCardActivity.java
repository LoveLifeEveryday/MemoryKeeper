package com.xcynice.memorykeeper.module.CreateBag;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import com.xcynice.memorykeeper.R;
import com.xcynice.memorykeeper.base.BaseActivity;
import com.xcynice.memorykeeper.base.BasePresenter;

import butterknife.BindView;

public class CreateCardActivity extends BaseActivity {

  /*  @BindView(R.id.brief_introduction_edit)
    EditText mBriefIntroductionEdit;
    @BindView(R.id.remained_words_tv)
    TextView mRemainedWordsTv;*/

    /**
     * 创建 presenter
     *
     * @return presenter
     */
    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    /**
     * 得到布局文件 id
     *
     * @return layout id
     */
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_release_card;
    }

    /**
     * 初始化布局
     */
    @Override
    protected void initView() {
//        calculateEditCost();

    }

    /**
     * 初始化数据
     */
    @Override
    protected void initData() {

    }

    /**
     * 计算字数
     */
    /*private void calculateEditCost() {
        //记录字数上限
        int wordLimitNum= 100;
        mBriefIntroductionEdit.addTextChangedListener(new TextWatcher() {
            //记录输入的字数
            private CharSequence enterWords;
            private int selectionStart;
            private int selectionEnd;
            private int enteredWords;

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //实时记录输入的字数
                enterWords= s;
            }

            @Override
            public void afterTextChanged(Editable s) {
                //已输入字数
                enteredWords= wordLimitNum - s.length();
                //TextView显示剩余字数
                mRemainedWordsTv.setText(100 - enteredWords+ "/100字");
                selectionStart = mBriefIntroductionEdit.getSelectionStart();
                selectionEnd = mBriefIntroductionEdit.getSelectionEnd();
                if (enterWords.length() > wordLimitNum) {
                    //删除多余输入的字（不会显示出来）
                    s.delete(selectionStart - 1, selectionEnd);
                    int tempSelection = selectionEnd;
                    mBriefIntroductionEdit.setText(s);
                    //设置光标在最后
                    mBriefIntroductionEdit.setSelection(tempSelection);
                }
            }
        });
    }*/


}