package com.example.shuiai.typerecycleview;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.shuiai.typerecycleview.Adapter.HeadFootAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shuiai@dianjia.io
 * @date 2016/10/14
 */

public class HeaderFooterActivity extends BaseActivity {
    private RecyclerView headFootRecyclerView;
    private List<String> list = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.head_foot_activity);
        headFootRecyclerView = (RecyclerView) findViewById(R.id.headFootRecyclerView);
        initData();
        final GridLayoutManager grid = new GridLayoutManager(this, 4);
        headFootRecyclerView.setLayoutManager(grid);
        final HeadFootAdapter adapter = new HeadFootAdapter(this, list);
        headFootRecyclerView.setAdapter(adapter);
        grid.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {

            @Override
            public int getSpanSize(int position) {
                return (adapter.isHeaderView(position)||adapter.isBottomView(position))?grid.getSpanCount():1;
            }
        });
    }

    /**
     * 初始化数据
     */
    private void initData() {
        for (int i = 0; i < 41; i++) {
            list.add("第" + i + "个位置");
        }
    }
}
