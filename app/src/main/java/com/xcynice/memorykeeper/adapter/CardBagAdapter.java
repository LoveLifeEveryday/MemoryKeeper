package com.xcynice.memorykeeper.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.xcynice.memorykeeper.R;
import com.xcynice.memorykeeper.bean.CardBag;

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
     * @param baseViewHolder
     * @param cardBag
     */
    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, CardBag cardBag) {
        if (cardBag.isIfPrivate()){
            privacyText = "私有";
        }else{
            privacyText = "公开";
        }
        baseViewHolder.setText(R.id.item_card_bag_name,cardBag.getName());
        baseViewHolder.setText(R.id.item_card_bag_if_public,privacyText);
//        baseViewHolder.setImageDrawable(R.id.item_portrait_image,);

    }
}
