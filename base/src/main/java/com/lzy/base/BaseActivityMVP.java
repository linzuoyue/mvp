package com.lzy.base;

import android.os.Bundle;

import androidx.annotation.Nullable;

/**
 * mvp Activity 基类 <br/>
 *
 * @author 林佐跃 <br/>
 * @since V 1.0 <br/>
 */
public abstract class BaseActivityMVP extends BaseActivity {

    public PresenterSets mPresenterSets;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        getPresenterSets().onCreate(savedInstanceState);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        getPresenterSets().onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        getPresenterSets().onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        getPresenterSets().onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        getPresenterSets().onStop();
    }

    @Override
    protected void onDestroy() {
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
