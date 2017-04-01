package com.puwang.realmdemo.utils;

import android.content.Context;

import com.puwang.realmdemo.bean.Person;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import io.realm.Sort;

/**
 * Created by Leo on 2017/3/31.
 */

public class RealmHelper {
    public static final String DB_NAME = "Leo";
    private Realm mRealm;

    public RealmHelper(Context context) {
        mRealm = Realm.getDefaultInstance();
        mRealm.asObservable();
    }


    public boolean isPersonExist(String id) {
        Person person = mRealm.where(Person.class).equalTo("id", id).findFirst();
        if (person == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * add （增）
     */
    public void addPerson(final Person person) {
        mRealm.beginTransaction();
        mRealm.copyToRealm(person);
        mRealm.commitTransaction();

//
//        mRealm.executeTransaction(new Realm.Transaction() {
//            @Override
//            public void execute(Realm realm) {
//
//                realm.copyToRealm(person);
//            }
//        });

    }

    /**
     * delete （删）
     */
    public void deletePerson(String id) {
        Person dog = mRealm.where(Person.class).equalTo("id", id).findFirst();
        mRealm.beginTransaction();
        dog.deleteFromRealm();
        mRealm.commitTransaction();

    }

    /**
     * 查询全部，并排序
     *
     * @author 乐文
     * created at 2017/3/31 上午10:17
     */
    public List<Person> queryAllPerson() {
        RealmResults<Person> persons = mRealm.where(Person.class).findAll();

        //增序排列
        RealmResults<Person> results = persons.sort("id");
        //降序排列
        RealmResults<Person> results1 = persons.sort("id", Sort.DESCENDING);

        return results;
    }


    public List<Person> queryByAge(int age) {
        RealmResults<Person> persons = mRealm
                .where(Person.class)
                .equalTo("age", age)
                .findAll();


        return persons;
    }


    /**
     * 在数组的范围中查询符合条件的数据
     *
     * @author 乐文
     * created at 2017/3/31 下午2:52
     */
    public List<Person> queryInOther() {
        RealmResults<Person> persons = mRealm.where(Person.class)
                .findAll();
        Integer[] integers = new Integer[]{12, 23, 22, 18, 19, 20};
        RealmResults<Person> age = mRealm.where(Person.class).in("age", integers).findAll();
        return age;
    }


    /**
     * 模糊查询
     *
     * @author 乐文
     * created at 2017/3/31 下午2:53
     */
    public List<Person> queryContains() {

        RealmResults<Person> persons = mRealm.where(Person.class).contains("name", "J").findAll();
        return persons;
    }


    /**
     * 查找10岁到20岁之前的person
     *
     * @author 乐文
     * created at 2017/3/31 下午4:38
     */
    public List<Person> queryBetween() {
        RealmResults<Person> age = mRealm.where(Person.class).between("age", 10, 20).findAll();
        return age;
    }

    /**
     * 分组查询
     *
     * @author 乐文
     * created at 2017/3/31 下午4:39
     */
    public List<Person> queryGroup() {
        RealmResults<Person> r = mRealm.where(Person.class)
                .greaterThan("age", 10)  // implicit AND
                .beginGroup()
                .equalTo("name", "Jack")
                .or()
                .contains("name", "Leo")
                .endGroup()
                .findAll();
        return r;
    }


    /**
    * 迭代
    *
    *@author 乐文
    *created at 2017/3/31 下午4:43
    */

    public void queryIterations() {
        RealmResults<Person> all = mRealm.where(Person.class).findAll();
        for (Person p : all) {

        }
    }


    /**
     * update （改）
     */
    public void updatePerson(String id, String newName) {
        Person person = mRealm.where(Person.class).equalTo("id", id).findFirst();
        mRealm.beginTransaction();
        person.setName(newName);
        mRealm.commitTransaction();
    }



}
