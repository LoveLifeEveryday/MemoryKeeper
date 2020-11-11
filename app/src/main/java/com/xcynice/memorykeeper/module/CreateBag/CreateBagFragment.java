package com.xcynice.memorykeeper.module.CreateBag;

import android.annotation.SuppressLint;
import android.text.Editable;
import android.text.Layout;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.xcynice.memorykeeper.R;
import com.xcynice.memorykeeper.base.BaseFragment;
import com.xcynice.memorykeeper.base.BasePresenter;
import com.xcynice.memorykeeper.module.main.activity.MainActivity;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CreateBagFragment#} factory method to
 * create an instance of this fragment.
 */
@SuppressLint("NonConstantResourceId")
public class CreateBagFragment extends BaseFragment {



    @BindView(R.id.brief_introduction_edit)
    EditText mBriefIntroductionEdit;
    @BindView(R.id.remained_words_tv)
    TextView mRemainedWordsTv;


    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_create_bag;
    }

    @Override
    protected void initView(){


        calculateEditCost();

    }

    /**
     * 计算字数
     */
    private void calculateEditCost() {
        //记录字数上限
        int wordLimitNum= 600;
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
                mRemainedWordsTv.setText(600 - enteredWords+ "/600字");
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
    }

    @Override
    protected void initData() {
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }


}