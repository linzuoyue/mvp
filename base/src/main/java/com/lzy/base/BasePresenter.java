package com.lzy.base;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * presenter 基类 <br/>
 *
 * @author 林佐跃 <br/>
 * @since V 1.0 <br/>
 */
public class BasePresenter<T extends IBaseView> implements IBasePresenter<T> {

    protected T mView;

    @Override
    public void attachView(@NonNull T view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceStat) {

    }

    @Override
    public void onViewCreate(View view, Bundle savedInstanceState) {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroyView() {

    }

    @Override
    public void onDestroy() {

    }
}
