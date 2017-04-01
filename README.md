# Realm使用详解

> 数据库Realm，是用来替代sqlite的一种解决方案，它有一套自己的数据库存储引擎，比sqlite更轻量级，拥有更快的速度，并且具有很多现代数据库的特性，比如支持JSON，流式api，数据变更通知，自动数据同步,简单身份验证，访问控制，事件处理，最重要的是跨平台，目前已有Java，Objective C，Swift，React-Native，Xamarin这五种实现。

[Realm官方文档](https://realm.io/docs/java/latest/#getting-started)


## 集成到Android Studio
- Add the class path dependency to the project level build.gradle file.
 
 ``` java
buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath "io.realm:realm-gradle-plugin:3.0.0"
    }
}
 ```
- Apply the realm-android plugin to the top of the application level build.gradle file.

``` java
apply plugin: 'realm-android'
```

## 基本使用
- Realm model classes are created by extending the RealmObject base class.
> 意思说我们的实体类需要继承RealmObject ,并指定一个PrimaryKey.

- Field types
> 其中支持的数据类型有：boolean、short、int、long、float、double、byte[]、String、data、Any RealmObject subclass、RealmList.
> RealmList像是Java的List，是一个容器，我们可以利用它来构建一对多的关系。

- Annotations
1. @PrimaryKey设置主键，主键必须唯一。我们使用了主键后，可以通过copyToRealmOrUpdate()方法去查询对象，如果查询到了则更新，否则新建一个对象来代替。但是有个弊端：使用主键注解后，创建和更新数据会慢一点，查询会快一点。
2. @Required是强制某个字段数据不能为null
3. @lgnore 忽略，即该字段不会被存储到本地
4. @Index，为使用此注解的字段添加一个搜索引擎。插入数据的时候会变慢，查询的速度会变快，适用于优化读取性能的应用场景。

- 增删改查的事务操作
1. 初始化Realm
 > 有两种方式来初始化Realm

``` java
		//默认初始化
		mRealm = Realm.getDefaultInstance();

		//自定义配置
	    RealmConfiguration configuration = new RealmConfiguration.Builder()
                .inMemory()  //数据存在内存中，不写入硬盘，随着应用退出所存数据会被删除
                .schemaVersion(1) //设置数据库的版本号
                .rxFactory(new RealmObservableFactory()) //支持RxJava
                .name("Leo") //数据库名字
                .deleteRealmIfMigrationNeeded()
                .build();


        mRealm = Realm.getInstance(configuration);
```

2. 插入

 ``` java
 public void addPerson(final Person person)
 {
        mRealm.beginTransaction();
        mRealm.copyToRealm(person);
        mRealm.commitTransaction();
    }
 ```
 3. 删除
 
``` java
  public void deletePerson(String id)
  {
        Person person = mRealm.where(Person.class).equalTo("id", id).findFirst();
        mRealm.beginTransaction();
        person.deleteFromRealm();
        mRealm.commitTransaction();
    }
```
 4. 修改

 ``` java

  public void updatePerson(String id, String newName)
   {
        Person person = mRealm.where(Person.class).equalTo("id", id).findFirst();
        mRealm.beginTransaction();
        person.setName(newName);
        mRealm.commitTransaction();
    }

 ```
 5.1 查询所有并排序
          
``` java

         public List<Person> queryAllPerson()
         {
        RealmResults<Person> persons = mRealm.where(Person.class).findAll();
        //增序排列
        persons = persons.sort("id");
      //降序排列
//        persons=persons.sort("id", Sort.DESCENDING);
        return mRealm.copyFromRealm(persons);
    }
    
```

      
 5.2 通过某一个属性查询

 ``` java
    public Person queryPersonById(String id)
       {
        Person person = mRealm.where(Person.class).equalTo("id", id).findFirst();

        return person;
    }

 ```


