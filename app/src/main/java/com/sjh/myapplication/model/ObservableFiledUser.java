package com.sjh.myapplication.model;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;

/**
 * bindable 和 notifyPropertyChanged的替代方式
 */
public class ObservableFiledUser {

    public  ObservableField<String> firstName = new ObservableField<>();
    public  ObservableField<String> lastName = new ObservableField<>();
    public  ObservableInt age = new ObservableInt();
    public  ObservableBoolean isStudent = new ObservableBoolean();


}
