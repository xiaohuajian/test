package com.sjh.myapplication.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.sjh.myapplication.BR;

public class User extends BaseObservable{
    /**
     * 这个bindable 在属性里加上或者在getter方法中加上，都会在BR类中生成相应的int 字段变量
     */
    @Bindable
    private String firstName;
    @Bindable
    private String lastName;

    private boolean isStudent;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        notifyPropertyChanged(BR.lastName);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        // 通过Observable 中去回调变化
        notifyPropertyChanged(BR.firstName);
    }

    public boolean isStudent() {
        return isStudent;
    }

    public void setStudent(boolean student) {
        isStudent = student;
    }
}
