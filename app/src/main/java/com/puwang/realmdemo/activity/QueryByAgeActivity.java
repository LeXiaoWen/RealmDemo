package com.puwang.realmdemo.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.puwang.realmdemo.R;
import com.puwang.realmdemo.adapter.MyPersonQueryAdapter;
import com.puwang.realmdemo.base.BaseActivity;
import com.puwang.realmdemo.bean.Person;
import com.puwang.realmdemo.utils.RealmHelper;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class QueryByAgeActivity extends BaseActivity {

    @BindView(R.id.age_recycler)
    RecyclerView mAgeRecycler;
    @BindView(R.id.query_editor)
    EditText mQueryEditor;
    @BindView(R.id.query_btn)
    Button mQueryBtn;
    @BindView(R.id.back)
    ImageView mBack;
    private RealmHelper mRealmHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initToolBarAsHome("通过年龄查询");

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_query_by_age;
    }

    @OnClick({R.id.query_btn,R.id.back})
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.query_btn:
                String s = mQueryEditor.getText().toString();
                int age = Integer.valueOf(s);
                initData(age);
                break;
            case R.id.back:
                finish();
                break;
            default:
                break;
        }


    }

    private void initData(int age) {
        mRealmHelper = new RealmHelper(this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mAgeRecycler.setLayoutManager(manager);
        List<Person> persons = mRealmHelper.queryByAge(age);
        if (persons.size() == 0) {
            Toast.makeText(this, "没有数据！", Toast.LENGTH_SHORT).show();
        }
        MyPersonQueryAdapter adapter = new MyPersonQueryAdapter(this, persons, R.layout.item_recycler_query);
        mAgeRecycler.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }


}
