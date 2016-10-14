package com.example.shuiai.typerecycleview.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.shuiai.typerecycleview.R;

import java.util.List;

/**
 * @author shuiai@dianjia.io
 * @Company 杭州木瓜科技有限公司
 * @date 2016/10/14
 */

public class HeadFootAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    /**
     * ITEM的类型
     */
    private static final int HEAD_TYPE = 0;
    private static final int FOOT_TYPE = 1;
    private static final int CONTENT_TYPE = 2;
    private Context context;
    private List<String> list;
    /**
     * 头布局的数量
     */
    private int HEAD_COUNT = 1;
    /**
     * 脚布局的数量
     */
    private int FOOT_COUNT = 1;

    public HeadFootAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    //判断当前item是否是HeadView
    public boolean isHeaderView(int position) {
        return HEAD_COUNT != 0 && position < HEAD_COUNT;
    }

    //判断当前item是否是FooterView
    public boolean isBottomView(int position) {
        return FOOT_COUNT != 0 && position >= (HEAD_COUNT + list.size());
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == HEAD_TYPE) {
            return new HeadViewHolder(View.inflate(context, R.layout.item_head, null));
        } else if (viewType == FOOT_TYPE) {
            return new FootViewHolder(View.inflate(context, R.layout.item_foot, null));
        } else {
            return new ContentViewHolder(View.inflate(context, R.layout.item_head_foot, null));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof HeadViewHolder) {//头布局

        } else if (holder instanceof FootViewHolder) {//            脚布局

        } else {
            ((ContentViewHolder) holder).txtContent.setText(list.get(position-1));
        }
    }

    @Override
    public int getItemCount() {
        return HEAD_COUNT + list.size() + FOOT_COUNT;
    }

    @Override
    public int getItemViewType(int position) {
        int dataCount = list.size();
        if (HEAD_COUNT != 0 && position < HEAD_COUNT) {
            return HEAD_TYPE;
        } else if (FOOT_COUNT != 0 && position >= (HEAD_COUNT + dataCount)) {
            return FOOT_TYPE;
        } else {
            return CONTENT_TYPE;
        }
    }

/**
 * 内容的VIEWHOLDER
 */
public static class ContentViewHolder extends RecyclerView.ViewHolder {
    public TextView txtContent;

    public ContentViewHolder(View itemView) {
        super(itemView);
        txtContent = get(itemView, R.id.txt_content);
    }

    private static <T extends View> T get(View view, int id) {
        SparseArray<View> viewholder = (SparseArray<View>) view.getTag();
        if (viewholder == null) {
            viewholder = new SparseArray<View>();
            view.setTag(viewholder);
        }
        View chicldView = viewholder.get(id);
        if (chicldView == null) {
            chicldView = view.findViewById(id);
            viewholder.put(id, chicldView);
        }
        return (T) chicldView;
    }
}

/**
 * 头布局的VIEWHOLDER
 */
public static class HeadViewHolder extends RecyclerView.ViewHolder {

    public HeadViewHolder(View itemView) {
        super(itemView);
    }

    private static <T extends View> T get(View view, int id) {
        SparseArray<View> viewholder = (SparseArray<View>) view.getTag();
        if (viewholder == null) {
            viewholder = new SparseArray<View>();
            view.setTag(viewholder);
        }
        View chicldView = viewholder.get(id);
        if (chicldView == null) {
            chicldView = view.findViewById(id);
            viewholder.put(id, chicldView);
        }
        return (T) chicldView;
    }
}

/**
 * 脚布局的VIEWHOLDER
 */
public static class FootViewHolder extends RecyclerView.ViewHolder {

    public FootViewHolder(View itemView) {
        super(itemView);
    }

    private static <T extends View> T get(View view, int id) {
        SparseArray<View> viewholder = (SparseArray<View>) view.getTag();
        if (viewholder == null) {
            viewholder = new SparseArray<View>();
            view.setTag(viewholder);
        }
        View chicldView = viewholder.get(id);
        if (chicldView == null) {
            chicldView = view.findViewById(id);
            viewholder.put(id, chicldView);
        }
        return (T) chicldView;
    }
}
}
