package com.puwang.realmdemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.puwang.realmdemo.R;
import com.puwang.realmdemo.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class QueryActivity extends BaseActivity {

    @BindView(R.id.all_query)
    Button mAllQuery;
    @BindView(R.id.condition_query)
    Button mConditionQuery;
    @BindView(R.id.other_query)
    Button mOtherQuery;
    @BindView(R.id.back)
    ImageView mBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initToolBarAsHome("查询");
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_query;
    }

    @OnClick({R.id.all_query, R.id.condition_query, R.id.other_query,R.id.back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.all_query:
                startActivity(new Intent(QueryActivity.this, AllQueryActivity.class));
                break;
            case R.id.condition_query:
                startActivity(new Intent(QueryActivity.this, QueryByAgeActivity.class
                ));
                break;
            case R.id.other_query:
                startActivity(new Intent(QueryActivity.this,OtherQueryActivity.class));
                break;
            case R.id.back:
                finish();
                break;
        }
    }


}
