package com.xcynice.memorykeeper.module.study.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.gyf.immersionbar.ImmersionBar;
import com.xcynice.memorykeeper.R;

public class ReleaseCardActivity extends AppCompatActivity {
    private ConstraintLayout mConstraintLayout;
    private TextView mRefreshIv;
    private TextView mTextView5;
    private TextView mTextView6;
    private EditText mEditTextTextMultiLine;
    private TextView mTextView7;
    private EditText mEditTextTextMultiLine2;
    private TextView mTextView8;
    private EditText mEditTextTextMultiLine3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_release_card);
        initView();

    }

    private void initView() {
        mConstraintLayout = findViewById(R.id.constraintLayout);
        mRefreshIv = findViewById(R.id.refresh_iv);
        mTextView5 = findViewById(R.id.textView5);
        mTextView6 = findViewById(R.id.textView6);
        mEditTextTextMultiLine = findViewById(R.id.editTextTextMultiLine);
        mTextView7 = findViewById(R.id.textView7);
        mEditTextTextMultiLine2 = findViewById(R.id.editTextTextMultiLine2);
        mTextView8 = findViewById(R.id.textView8);
        mEditTextTextMultiLine3 = findViewById(R.id.editTextTextMultiLine3);
        ImmersionBar.with(this).titleBar(mConstraintLayout).init();
    }
}