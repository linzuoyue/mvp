package com.lzy.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Activity 基类 <br/>
 *
 * @author 林佐跃 <br/>
 * @since V 1.0 <br/>
 */
public abstract class BaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initView();
        bindData();
    }

    protected void initView() {

    }

    protected void bindData() {

    }

    protected abstract int getLayoutId();
}
