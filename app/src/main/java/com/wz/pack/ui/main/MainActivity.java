package com.wz.pack.ui.main;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

import com.wz.baselib.mvpbase.baseImpl.BaseActivity;
import com.wz.pack.R;
import com.wz.pack.ui.login.activity.LoginActivity;
import com.wz.pack.ui.main.adapter.MainAdapter;
import com.wz.pack.ui.main.bean.MainBean;
import com.wz.pack.ui.main.contact.MainContact;
import com.wz.pack.ui.main.presenter.MainPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<MainContact.presenter> implements MainContact.MainView {

    @BindView(R.id.tl_custom)
    Toolbar mToolbar;
    @BindView(R.id.fab_plus)
    FloatingActionButton fabPlus;
    @BindView(R.id.dl_left)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.iv_vatar)
    ImageView ivVatar;
    @BindView(R.id.rv_layout)
    RecyclerView mRecyclerView;
    @BindView(R.id.coordinator_layout)
    CoordinatorLayout mCoordinatorLayout;


    private ActionBarDrawerToggle mDrawerToggle;
    //数据
    private List<MainBean.ResultsBean> mResultsBean = new ArrayList<>();
    private MainAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
        initData();
        presenter.getData();
    }

    private void initData() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new MainAdapter(mResultsBean);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public MainContact.presenter initPresenter() {
        return new MainPresenter(this);
    }


    private void init() {
        //设置Toolbar标题
        mToolbar.setTitle(getResources().getString(R.string.app_name));
        //设置标题颜色
        mToolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(mToolbar);
        //设置返回键可用
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //创建返回键，并实现打开关/闭监听
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.open, R.string.close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);

            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);

            }
        };
        mDrawerToggle.syncState();
        mDrawerLayout.addDrawerListener(mDrawerToggle);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public void setData(MainBean dataList) {
        if (dataList != null && dataList.getResults() != null) {
            mResultsBean.addAll(dataList.getResults());
            mAdapter.notifyDataSetChanged();
        }
    }


    @OnClick({R.id.fab_plus, R.id.iv_vatar})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fab_plus:
                Snackbar.make(mCoordinatorLayout, "sdfs", Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.iv_vatar:
                startActivity(LoginActivity.class);
                break;
        }
    }
}
