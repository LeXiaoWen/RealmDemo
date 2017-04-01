package com.puwang.realmdemo.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.puwang.realmdemo.R;
import com.puwang.realmdemo.adapter.MyPersonQueryAdapter;
import com.puwang.realmdemo.base.BaseActivity;
import com.puwang.realmdemo.bean.Person;
import com.puwang.realmdemo.utils.RealmHelper;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class AllQueryActivity extends BaseActivity {

    @BindView(R.id.all_query_recycler)
    RecyclerView mAllQueryRecycler;
    @BindView(R.id.back)
    ImageView mBack;
    private RealmHelper mRealmHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initToolBarAsHome("Query All");

        initData();

    }

    private void initData() {
        mRealmHelper = new RealmHelper(this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mAllQueryRecycler.setLayoutManager(manager);
        List<Person> persons = mRealmHelper.queryAllPerson();
        MyPersonQueryAdapter adapter = new MyPersonQueryAdapter(this, persons, R.layout.item_recycler_query);
        mAllQueryRecycler.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_all_query;
    }

    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }
}
