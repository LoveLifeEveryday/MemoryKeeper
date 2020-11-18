package com.xcynice.memorykeeper.module.mine.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xcynice.memorykeeper.R;
import com.xcynice.memorykeeper.bean.CardBag;

import org.jetbrains.annotations.NotNull;

/**
 * @author : xucanyou666
 * @date : 2020/11/18 16:10
 * @github : https://github.com/LoveLifeEveryday
 * @juejin : https://juejin.im/user/325111175192590/posts
 * @description : 卡包的adapter
 */
public class MineCardBagAdapter extends BaseQuickAdapter<CardBag, BaseViewHolder> {
    public MineCardBagAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder helper, CardBag cardBag) {
        helper.setText(R.id.item_card_bag_name, cardBag.getName());
        if (cardBag.isIfPrivate()) {
            helper.setText(R.id.item_card_bag_if_public, "私有");
        } else {
            helper.setText(R.id.item_card_bag_if_public, "公有");
        }

    }
}
