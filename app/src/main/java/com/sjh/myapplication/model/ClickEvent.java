package com.sjh.myapplication.model;

import android.view.View;
import android.widget.Toast;

/**
 * 点击事件处理逻辑的地方
 * 这里和以往的点击事件并不一样，把点击事件移到activity外面了
 */
public class ClickEvent {

    public void dealWithClickEvent(View view){
        Toast.makeText(view.getContext(), "点击事件", Toast.LENGTH_LONG).show();
    }


}
