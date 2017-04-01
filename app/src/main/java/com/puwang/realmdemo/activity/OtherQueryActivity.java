package com.puwang.realmdemo.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.puwang.realmdemo.R;
import com.puwang.realmdemo.adapter.MyPersonQueryAdapter;
import com.puwang.realmdemo.base.BaseActivity;
import com.puwang.realmdemo.bean.Person;
import com.puwang.realmdemo.utils.RealmHelper;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class OtherQueryActivity extends BaseActivity {

    @BindView(R.id.back)
    ImageView mBack;

    @BindView(R.id.query_in)
    Button mQueryIn;
    @BindView(R.id.query_sort)
    Button mQuerySort;
    @BindView(R.id.query_contains)
    Button mQueryContains;
    @BindView(R.id.query_between)
    Button mQueryBetween;
    @BindView(R.id.query_group)
    Button mQueryGroup;
    @BindView(R.id.recycler)
    RecyclerView mRecycler;
    private RealmHelper mRealmHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initToolBarAsHome("其他方式查询");
        mRealmHelper = new RealmHelper(this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecycler.setLayoutManager(manager);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_other_query;
    }


    @OnClick({R.id.back, R.id.query_in, R.id.query_sort, R.id.query_contains, R.id.query_between, R.id.query_group})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.query_in:
                List<Person> in = mRealmHelper.queryInOther();
                mRecycler.setAdapter(getAdapter(in));
                break;
            case R.id.query_sort:
                List<Person> sort = mRealmHelper.queryAllPerson();
                mRecycler.setAdapter(getAdapter(sort));
                break;
            case R.id.query_contains:
                List<Person> contains = mRealmHelper.queryContains();
                mRecycler.setAdapter(getAdapter(contains));
                break;
            case R.id.query_between:
                List<Person> between = mRealmHelper.queryBetween();
                mRecycler.setAdapter(getAdapter(between));
                break;
            case R.id.query_group:
                List<Person> group = mRealmHelper.queryGroup();
                mRecycler.setAdapter(getAdapter(group));
                break;
        }
    }

    private MyPersonQueryAdapter getAdapter(List<Person> persons) {
        MyPersonQueryAdapter adapter = new MyPersonQueryAdapter(this, persons, R.layout.item_recycler_query);
        return adapter;
    }
}
