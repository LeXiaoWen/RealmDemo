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

public class MyPersonAdapter extends BaseAdapter<Person>{

    private final RealmHelper mRealmHelper;

    public MyPersonAdapter(Context mContext, List<Person> mDatas, int mLayoutId) {
        super(mContext, mDatas, mLayoutId);
        mRealmHelper = new RealmHelper(mContext);
    }

    @Override
    protected void convert(Context mContext, BaseViewHolder holder, final Person person) {
        holder.setText(R.id.tv_name, person.getName())
                .setText(R.id.tv_id, person.getId());

        final ImageView iv = holder.getView(R.id.iv_like);

        if (mRealmHelper.isPersonExist(person.getId())) {
            iv.setSelected(true);
        } else {
            iv.setSelected(false);
        }


        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (iv.isSelected()) {
                    iv.setSelected(false);
                    mRealmHelper.deletePerson(person.getId());

                } else {
                    iv.setSelected(true);
                    mRealmHelper.addPerson(person);
                }
            }
        });
    }
}
