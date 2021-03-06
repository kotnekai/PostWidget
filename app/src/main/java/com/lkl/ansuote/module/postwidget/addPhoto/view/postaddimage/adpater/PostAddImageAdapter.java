package com.lkl.ansuote.module.postwidget.addPhoto.view.postaddimage.adpater;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseViewHolder;
import com.lkl.ansuote.module.postwidget.GlideApp;
import com.lkl.ansuote.module.postwidget.R;
import com.lkl.ansuote.module.postwidget.addPhoto.view.postaddimage.entity.PostAddImageEntity;

import java.util.List;


/**
 * Created by huangdongqiang on 13/09/2017.
 */
public class PostAddImageAdapter extends CustomDragAndMutiAdapter<PostAddImageEntity, BaseViewHolder>{
    private static final String TAG = "PostAddImageAdapter";
    
    public PostAddImageAdapter(List<PostAddImageEntity> data) {
        super(data);
        addItemType(PostAddImageEntity.TYPE_IMAGE, R.layout.item_post_add_image_image);
        addItemType(PostAddImageEntity.TYPE_BUTTON_ADD, R.layout.item_post_add_image_button);
    }

    @Override
    protected void convert(BaseViewHolder helper, PostAddImageEntity item) {

        switch (helper.getItemViewType()) {
            case PostAddImageEntity.TYPE_IMAGE:
                GlideApp.with(mContext)
                        .load(item.getUrl())
                        .placeholder(R.mipmap.ic_default)
                        .error(R.mipmap.ic_default)
                        .into((ImageView)helper.getView(R.id.image));
                break;

            case PostAddImageEntity.TYPE_BUTTON_ADD:
                helper.setImageResource(R.id.btn_add, R.mipmap.btn_post_add);
                //helper.setImageResource(R.id.image, R.mipmap.card_meet);
                break;
            default:
                break;
        }

    }
}
