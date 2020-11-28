package com.xcynice.memorykeeper.module.study.adapter;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;

import com.chad.library.adapter.base.BaseViewHolder;
import com.xcynice.memorykeeper.R;
import com.xcynice.memorykeeper.bean.CardBag;
import com.xcynice.memorykeeper.util.ActivityUtil;

import org.jetbrains.annotations.NotNull;

/**
 * @Description:
 * @Author: Yu ki-r
 * @CreateDate: 2020/11/17 17:19
 */
public class CardBagAdapter extends BaseQuickAdapter<CardBag, BaseViewHolder> {
    String privacyText;

    public CardBagAdapter(int layoutResId) {
        super(layoutResId);
    }

    /**
     * 在此方法中设置 item 数据
     *
     * @param baseViewHolder
     * @param cardBag
     */
    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, CardBag cardBag) {
        baseViewHolder.setText(R.id.item_card_bag_name, cardBag.getName());
        if (cardBag.isIfPrivate()) {
            baseViewHolder.setText(R.id.item_card_bag_if_public, "私有");
        } else {
            baseViewHolder.setText(R.id.item_card_bag_if_public, "公有");
        }
        ImageView imageView = baseViewHolder.getView(R.id.item_portrait_image);
        if (!TextUtils.isEmpty(cardBag.getPic())) {
            Glide.with(ActivityUtil.getCurrentActivity())
                    .load(cardBag.getPic())
                    .into(imageView);
        }

    }
}
