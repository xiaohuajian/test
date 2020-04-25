package com.sjh.myapplication;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.sjh.myapplication.databinding.MainBinding;
import com.sjh.myapplication.model.ClickEvent;
import com.sjh.myapplication.model.ObservableFiledUser;
import com.sjh.myapplication.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试master 提交
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    
    /**
     *
     * 这是编译产生的最后的文件 路径：DataBindingDemo\app\build\intermediates\classes\debug\com\sjh\databindingdemo\databinding
     * 这是系统生成的类 由aapt完成的 D:\androidProject\DataBindingDemo\app\build\generated\source\apt\debug\com\sjh\databindingdemo\databinding\ActivityMainBinding.java
     */
    private MainBinding mDataBinding;
    private RecyclerView mRecycleView;
    MyAdapter adapter;

    User user;
    ObservableFiledUser mObservableFiledUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        mDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        user = new User("Micheal", "Jack2");
        mDataBinding.setUser(user);
        user.setStudent(true);

        ImageLoaderConfiguration configuration = ImageLoaderConfiguration.createDefault(this);
        ImageLoader.getInstance().init(configuration);
        //这里和user一样，variable 定义了 imageUrl的viewModel 然后生成了set/get方法，
        mDataBinding.setImageUrl("https://www.baidu.com/img/bd_logo1.png");

        // 设置点击事件
        mDataBinding.setClickEvent(new ClickEvent());
        mDataBinding.setMainActivityClickEvent(this);

        mObservableFiledUser = new ObservableFiledUser();
        mObservableFiledUser.firstName.set("firstName ObservableFiled");
        mDataBinding.setObservableFiledUser(mObservableFiledUser);

        List<ObservableFiledUser> data = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ObservableFiledUser user2 = new ObservableFiledUser();
            user2.age.set(30);
            user2.firstName.set("Micheal " + i);
            user2.lastName.set("Jack " + i);
            data.add(user2);
        }
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                this, LinearLayoutManager.VERTICAL, false);
        //下面findViewById可以执行，因为DataBindingUtil.setContentView代码其实就是执行了setContentView 只不过换了形式而已
        mRecycleView = findViewById(R.id.recycleView);
        mRecycleView.setLayoutManager(layoutManager);
        adapter = new MyAdapter(data);
        mRecycleView.setAdapter(adapter);


    }

    public void setUserIsStudent(View view){
        user.setStudent(true);
        Log.d(TAG, "setUserIsStudent: 为true");
        // TODO: 2018/7/29 通过点击事件来改变user的student的值，但xml只加载一次，后续没有加载了，
        // TODO: 所以需要调用setUser 去刷新界面
        mDataBinding.setUser(user);
    }

    public void setUserNotIsStudent(View view){
        user.setStudent(false);
        Log.d(TAG, "setUserIsStudent: 为false");
        mDataBinding.setUser(user);
    }

    public void changeValueBySet(View view){
        user.setLastName("new name");
    }

    public void toLiveData(View view){

    }
}
