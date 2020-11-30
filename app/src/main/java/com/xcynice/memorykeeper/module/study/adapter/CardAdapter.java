package com.xcynice.memorykeeper.module.study.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xcynice.memorykeeper.R;
import com.xcynice.memorykeeper.bean.Card;
import com.xcynice.memorykeeper.bean.CardBag;
import com.xcynice.memorykeeper.bean.CardList;
import com.xcynice.memorykeeper.bean.ResponseCard;
import com.xcynice.memorykeeper.util.LogUtil;

import java.util.List;

/**
 * @Description:
 * @Author: Yu ki-r
 * @CreateDate: 2020/11/30 22:57
 */
public class CardAdapter extends BaseQuickAdapter<ResponseCard, BaseViewHolder> {


    public CardAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder baseViewHolder, ResponseCard card) {
        baseViewHolder.setText(R.id.item_question,card.getQuestion());
        LogUtil.d("CardAdapter",card.getQuestion());
    }
}
