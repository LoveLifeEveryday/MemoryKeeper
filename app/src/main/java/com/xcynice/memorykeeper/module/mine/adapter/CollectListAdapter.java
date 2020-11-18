package com.xcynice.memorykeeper.module.mine.adapter;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xcynice.memorykeeper.R;
import com.xcynice.memorykeeper.bean.CollectList;

/**
 * @author : xucanyou666
 * @date : 2020/11/18 17:33
 * @github : https://github.com/LoveLifeEveryday
 * @juejin : https://juejin.im/user/325111175192590/posts
 * @description :
 */
public class CollectListAdapter extends BaseQuickAdapter<CollectList.ListBean, BaseViewHolder> {
    public CollectListAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, CollectList.ListBean item) {
        helper.setText(R.id.tv_card_bag_id, "卡包ID:" + item.getCardBagId());
        helper.setText(R.id.tv_collect_time, "收藏时间:" + item.getCollectionTime());
    }
}
