package com.puwang.realmdemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.puwang.realmdemo.R;
import com.puwang.realmdemo.base.BaseActivity;


import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {


    @BindView(R.id.update)
    Button mUpdate;
    @BindView(R.id.query)
    Button mQuery;
    @BindView(R.id.recycler)
    RecyclerView mRecycler;
    @BindView(R.id.add_delete)
    Button mAddDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initToolBarAsHome("RealmDemo");
    }


    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }


    @OnClick({R.id.add_delete, R.id.update, R.id.query})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.add_delete:
                startActivity(new Intent(MainActivity.this,PersonActivity.class));
                break;
            case R.id.update:
                startActivity(new Intent(MainActivity.this,UpdateActivity.class));
                break;
            case R.id.query:
                startActivity(new Intent(MainActivity.this,QueryActivity.class));
                break;
        }
    }
}
