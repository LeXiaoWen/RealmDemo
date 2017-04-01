package com.puwang.realmdemo.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.puwang.realmdemo.R;
import com.puwang.realmdemo.base.BaseAdapter;
import com.puwang.realmdemo.base.BaseViewHolder;
import com.puwang.realmdemo.bean.Person;
import com.puwang.realmdemo.utils.RealmHelper;

import java.util.List;

/**
 * Created by Leo on 2017/3/31.
 */

public class MyPersonQueryAdapter extends BaseAdapter<Person>{

    private final RealmHelper mRealmHelper;

    public MyPersonQueryAdapter(Context mContext, List<Person> mDatas, int mLayoutId) {
        super(mContext, mDatas, mLayoutId);
        mRealmHelper = new RealmHelper(mContext);
    }

    @Override
    protected void convert(Context mContext, BaseViewHolder holder, final Person person) {
        holder.setText(R.id.tv_name, person.getName())
                .setText(R.id.tv_id, person.getId());



    }
}
