package com.delsart.bookdownload.custom;

import android.content.Context;
import android.view.View;

import com.danielstone.materialaboutlibrary.holders.MaterialAboutItemViewHolder;
import com.danielstone.materialaboutlibrary.items.MaterialAboutActionItem;
import com.danielstone.materialaboutlibrary.items.MaterialAboutItem;
import com.danielstone.materialaboutlibrary.items.MaterialAboutTitleItem;
import com.danielstone.materialaboutlibrary.util.ViewTypeManager;
import com.delsart.bookdownload.R;


/**
 * Created by Delsart on 2017/7/24.
 */
public class MyViewTypeManager extends ViewTypeManager {
    public static final int ACTION_ITEM = ViewTypeManager.ItemType.ACTION_ITEM;
    public static final int TITLE_ITEM = ViewTypeManager.ItemType.TITLE_ITEM;
    public static final int CUSTOM_ITEM = 10;
    public static final int ACTION_LAYOUT = ViewTypeManager.ItemLayout.ACTION_LAYOUT;
    public static final int TITLE_LAYOUT = ViewTypeManager.ItemLayout.TITLE_LAYOUT;
    public static final int CUSTOM_LAYOUT = R.layout.item_custom;


    public int getLayout(int itemType) {
        switch (itemType) {
            case ACTION_ITEM:
                return ACTION_LAYOUT;
            case TITLE_ITEM:
                return TITLE_LAYOUT;
            case CUSTOM_ITEM:
                return CUSTOM_LAYOUT;
            default:
                return -1;
        }
    }

    public MaterialAboutItemViewHolder getViewHolder(int itemType, View view) {
        switch (itemType) {
            case ACTION_ITEM:
                return MaterialAboutActionItem.getViewHolder(view);
            case TITLE_ITEM:
                return MaterialAboutTitleItem.getViewHolder(view);
            case CUSTOM_ITEM:
                return MyCustomItem.getViewHolder(view);
            default:
                return null;
        }
    }

    public void setupItem(int itemType, MaterialAboutItemViewHolder holder, MaterialAboutItem item, Context context) {
        switch (itemType) {
            case ACTION_ITEM:
                MaterialAboutActionItem.setupItem((MaterialAboutActionItem.MaterialAboutActionItemViewHolder) holder, (MaterialAboutActionItem) item, context);
                break;
            case TITLE_ITEM:
                MaterialAboutTitleItem.setupItem((MaterialAboutTitleItem.MaterialAboutTitleItemViewHolder) holder, (MaterialAboutTitleItem) item, context);
                break;
            case CUSTOM_ITEM:
                MyCustomItem.setupItem((MyCustomItem.MyCustomItemViewHolder) holder, (MyCustomItem) item, context);
                break;
        }
    }
}