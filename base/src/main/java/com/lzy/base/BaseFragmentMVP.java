package com.lzy.base;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * fragment mvp 基类 <br/>
 *
 * @author 林佐跃 <br/>
 * @since V 1.0 <br/>
 */
public abstract class BaseFragmentMVP extends BaseFragment {

    public PresenterSets mPresenterSets;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        getPresenterSets().onCreate(savedInstanceState);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getPresenterSets().onViewCreate(view, savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        getPresenterSets().onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        getPresenterSets().onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        getPresenterSets().onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        getPresenterSets().onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        getPresenterSets().onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getPresenterSets().onDestroy();
        getPresenterSets().onDestroyView();
    }

    private PresenterSets getPresenterSets() {
        if (mPresenterSets == null) {
            mPresenterSets = new PresenterSets();
            presenterInject();
            presenterAttach();
        }
        return mPresenterSets;
    }

    protected abstract void presenterInject();

    protected abstract void presenterAttach();


}
