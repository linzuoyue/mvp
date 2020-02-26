package com.lzy.base;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * presenter 接口基类 <br/>
 *
 * @author : 林佐跃 <br/>
 * @since V 1.0 <br/>
 */
public interface IBasePresenter<T extends IBaseView> {

    void attachView(@NonNull T view);

    void detachView();

    void onCreate(@Nullable Bundle savedInstanceStat);

    void onStart();

    void onResume();

    void onPause();

    void onStop();

    void onDestroy();

    void onViewCreate(View view, Bundle savedInstanceState);

    void onDestroyView();
}
