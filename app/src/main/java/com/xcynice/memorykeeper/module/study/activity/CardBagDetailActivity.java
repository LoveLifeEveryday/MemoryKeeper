package com.xcynice.memorykeeper.module.study.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.xcynice.memorykeeper.R;
import com.xcynice.memorykeeper.base.BaseActivity;
import com.xcynice.memorykeeper.base.BasePresenter;
import com.xcynice.memorykeeper.bean.CardBag;
import com.xcynice.memorykeeper.bean.UpdateCardBag;

public class CardBagDetailActivity extends BaseActivity {

    private ConstraintLayout mConstraintLayout;
    private ImageView mBackIv;
    private ConstraintLayout mCardBagConstraintLayout;
    private ImageView mItemPortraitImage;
    private TextView mItemCardBagName;
    private TextView mItemCardBagIfPublic;
    private Button mBtnGoStudy;
    private FloatingActionButton mAddCard;

    private  CardBag cardBag;

    public CardBagDetailActivity() {
    }


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
        return R.layout.activity_card_bag_detail;
    }

    /**
     * 初始化布局
     */
    @Override
    protected void initView() {
        mConstraintLayout = findViewById(R.id.constraintLayout);
        mBackIv = findViewById(R.id.back_iv);
        mCardBagConstraintLayout = findViewById(R.id.card_bag_constraintLayout);
        mItemPortraitImage = findViewById(R.id.item_portrait_image);
        mItemCardBagName = findViewById(R.id.item_card_bag_name);
        mItemCardBagIfPublic = findViewById(R.id.item_card_bag_if_public);
        mBtnGoStudy = findViewById(R.id.btn_go_study);
        mAddCard = findViewById(R.id.add_card);
        Bundle bundle = this.getIntent().getExtras();
        if (bundle != null) {
            cardBag = (CardBag) bundle.getSerializable("cardBag");
        }
        mAddCard.setOnClickListener(new View.OnClickListener() {


            /**
             * Called when a view has been clicked.
             *
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("cardBag",cardBag);
//                bundle.putString("id",cardBag.getCardBagId());
                intent.putExtras(bundle);
                intent.setClass(CardBagDetailActivity.this, ReleaseCardActivity.class);
                startActivity(intent);
            }
        });
        mCardBagConstraintLayout.setOnClickListener(new View.OnClickListener() {

            /**
             * Called when a view has been clicked.
             *
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("cardBag",cardBag);
//                bundle.putString("id",cardBag.getCardBagId());
                intent.putExtras(bundle);
                intent.setClass(CardBagDetailActivity.this, CardBagSettingActivity.class);
                startActivity(intent);
            }
        });

        mBtnGoStudy.setOnClickListener(new View.OnClickListener() {

            /**
             * Called when a view has been clicked.
             *
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("cardBag",cardBag);
//                bundle.putString("id",cardBag.getCardBagId());
                intent.putExtras(bundle);
                intent.setClass(CardBagDetailActivity.this, StudyCardActivity.class);
                startActivity(intent);
            }
        });
    }

    /**
     * 初始化数据
     */
    @Override
    protected void initData() {
        mItemCardBagName.setText(cardBag.getName());
        Glide.with(this).load(cardBag.getPic()).into(mItemPortraitImage);

        if (cardBag.isIfPrivate()) {
            mItemCardBagIfPublic.setText( "私有");
        } else {
            mItemCardBagIfPublic.setText( "公有");
        }
    }


}