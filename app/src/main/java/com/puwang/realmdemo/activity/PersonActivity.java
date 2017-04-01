package com.puwang.realmdemo.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.puwang.realmdemo.R;
import com.puwang.realmdemo.adapter.MyPersonAdapter;
import com.puwang.realmdemo.base.BaseActivity;
import com.puwang.realmdemo.bean.Job;
import com.puwang.realmdemo.bean.Person;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class PersonActivity extends BaseActivity {
    @BindView(R.id.person_recycler)
    RecyclerView mPersonRecycler;
    @BindView(R.id.back)
    ImageView mBack;
    private List<Person> mPersons = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initToolBarAsHome("增删操作");
        initData();
        initRecycler();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_person;
    }

    private void initData() {

//        Test test = new Test();

        Person person1 = new Person();
        person1.setName("Leo");
        person1.setAge(18);
        person1.setId("001");
        Job job1 = new Job();
        job1.setJobName("android");
        job1.setMoney("5k");
//        person1.getJob().add(job1);


        Person person2 = new Person();
        person2.setName("Jack");
        person2.setAge(16);
        person2.setId("002");
        Job job2 = new Job();
        job2.setJobName("ios");
        job2.setMoney("5.6k");
//        person2.getJob().add(job2);


        Person person3 = new Person();
        person3.setName("Jimmy");
        person3.setAge(20);
        person3.setId("003");
        Job job3 = new Job();
        job3.setMoney("4.5k");
        job3.setJobName("java");
//        person3.getJob().add(job3);


        Person person4 = new Person();
        person4.setName("Tom");
        person4.setAge(20);
        person4.setId("004");
        Job job4 = new Job();
        job4.setJobName("python");
        job4.setMoney("5.5k");
//        person4.getJob().add(job4);


        Person person5 = new Person();
        person5.setName("Cree");
        person5.setAge(18);
        person5.setId("005");
        Job job5 = new Job();
        job5.setJobName("php");
        job5.setMoney("7k");
//        person5.getJob().add(job5);


        Person person6 = new Person();
        person6.setName("Brian");
        person6.setAge(16);
        person6.setId("006");
        Job job6 = new Job();
        job6.setJobName("ruby");
        job6.setMoney("6k");
//        person6.getJob().add(job6);


        Person person7 = new Person();
        person7.setName("David");
        person7.setAge(21);
        person7.setId("007");
        Job job7 = new Job();
        job7.setJobName("ios");
        job7.setMoney("8k");
//        person7.getJob().add(job7);


        mPersons.add(person1);
        mPersons.add(person2);
        mPersons.add(person3);
        mPersons.add(person4);
        mPersons.add(person5);
        mPersons.add(person6);
        mPersons.add(person7);

    }

    private void initRecycler() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mPersonRecycler.setLayoutManager(manager);
        MyPersonAdapter adapter = new MyPersonAdapter(this, mPersons, R.layout.item_recycler);
        mPersonRecycler.setAdapter(adapter);
    }

    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }
}
