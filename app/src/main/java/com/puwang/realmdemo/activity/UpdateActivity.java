package com.puwang.realmdemo.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.puwang.realmdemo.R;
import com.puwang.realmdemo.base.BaseActivity;
import com.puwang.realmdemo.utils.RealmHelper;

import butterknife.BindView;
import butterknife.OnClick;

public class UpdateActivity extends BaseActivity {

    @BindView(R.id.back)
    ImageView mBack;
    @BindView(R.id.et_name)
    EditText mEtName;
    @BindView(R.id.btn_update)
    Button mBtnUpdate;
    private RealmHelper mRealmHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initToolBarAsHome("更新");
        mRealmHelper = new RealmHelper(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_update;
    }


    @OnClick({R.id.back, R.id.btn_update})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.btn_update:
                String s = mEtName.getText().toString();
                mRealmHelper.updatePerson("001",s);
                Toast.makeText(this, "更新成功！", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
