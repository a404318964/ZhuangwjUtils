package com.zwj.zhuangwjutils.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;
import com.zwj.zhuangwjutils.R;
import com.zwj.zhuangwjutils.activity.adapterdemo.CommonAdapterDemoActivity;
import com.zwj.zhuangwjutils.activity.appmanager.TestAActivity;
import com.zwj.zhuangwjutils.activity.base.BaseAutoLayoutCommonActivity;
import com.zwj.zhuangwjutils.activity.customviewdemo.CustomViewDemoActivity;
import com.zwj.zhuangwjutils.activity.gesturelock.SetPatternDemo2Activity;
import com.zwj.zhuangwjutils.activity.network.NetMangerDemoActivity;
import com.zwj.zhuangwjutils.activity.qrcode.QRCodeDemoActivity;
import com.zwj.zhuangwjutils.bean.ViewBean;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseAutoLayoutCommonActivity {
    private RecyclerView rv;
    private CommonAdapter<ViewBean> adapter;
    private List<ViewBean> viewBeenList;


    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void findViews() {
        rv = getView(R.id.rv);
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        initViewBeenList();

        rv.setLayoutManager(new LinearLayoutManager(mContext));
        rv.setHasFixedSize(true);

        adapter = new CommonAdapter<ViewBean>(mContext, R.layout.item, viewBeenList) {
            @Override
            protected void convert(ViewHolder holder, ViewBean item, int position) {
                holder.setText(R.id.btn, item.getName());
            }
        };

        adapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener<ViewBean>() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, ViewBean item, int position) {
                startActivity(new Intent(mContext, item.getClazz()));
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, ViewBean item, int position) {
                return false;
            }
        });

        rv.setAdapter(adapter);
        rv.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    protected void setListener() {

    }

    private void initViewBeenList() {
        viewBeenList = new ArrayList<>();
        viewBeenList.add(new ViewBean(NetMangerDemoActivity.class));
        viewBeenList.add(new ViewBean(CustomViewDemoActivity.class, "自定义控件demo"));
        viewBeenList.add(new ViewBean(EncryptionDemoActivity.class));
        viewBeenList.add(new ViewBean(LoadMoreDemoActivity.class));
        viewBeenList.add(new ViewBean(CommonAdapterDemoActivity.class));
        viewBeenList.add(new ViewBean(ImageBuilderDemoActivity.class, "图片加载工具demo"));
        viewBeenList.add(new ViewBean(FileUtilsDemoActivity.class, "文件读写工具demo"));
        viewBeenList.add(new ViewBean(QRCodeDemoActivity.class, "二维码demo"));
        viewBeenList.add(new ViewBean(SetPatternDemo2Activity.class, "手势密码demo"));
        viewBeenList.add(new ViewBean(GreenDaoDemoActivity.class, "greendao demo"));
        viewBeenList.add(new ViewBean(TestAActivity.class, "AppManager demo"));
    }

}
