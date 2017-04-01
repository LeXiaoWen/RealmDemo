package com.puwang.realmdemo.api;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.puwang.realmdemo.utils.RealmHelper;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Leo on 2017/3/31.
 */

public class MyApp extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
        Realm.init(this);
        RealmConfiguration configuration = new RealmConfiguration.Builder()
                .name(RealmHelper.DB_NAME)
//                .inMemory()
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(configuration);
    }
}
