package com.lzy.base;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * Presenter 集合 <br/>
 *
 * @author 林佐跃 <br/>
 * @since V 1.0 <br/>
 */
public class PresenterSets implements IBasePresenter<IBaseView> {

    @NonNull
    private final List<IBasePresenter> presenters = new ArrayList<>();


    public void addPresenter(IBasePresenter<? extends IBaseView> iBasePresenter) {
        presenters.add(iBasePresenter);
    }

    @Override
    public void attachView(@NonNull IBaseView view) {
        for (IBasePresenter iBasePresenter : presenters) {
            iBasePresenter.attachView(view);
        }
    }

    @Override
    public void detachView() {
        for (IBasePresenter iBasePresenter : presenters) {
            iBasePresenter.detachView();
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceStat) {
        for (IBasePresenter iBasePresenter : presenters) {
            iBasePresenter.onCreate(savedInstanceStat);
        }
    }

    @Override
    public void onViewCreate(View view, Bundle savedInstanceState) {
        for (IBasePresenter iBasePresenter : presenters) {
            iBasePresenter.onViewCreate(view, savedInstanceState);
        }
    }

    @Override
    public void onStart() {
        for (IBasePresenter iBasePresenter : presenters) {
            iBasePresenter.onStart();
        }
    }

    @Override
    public void onResume() {
        for (IBasePresenter iBasePresenter : presenters) {
            iBasePresenter.onResume();
        }
    }

    @Override
    public void onPause() {
        for (IBasePresenter iBasePresenter : presenters) {
            iBasePresenter.onPause();
        }
    }

    @Override
    public void onStop() {
        for (IBasePresenter iBasePresenter : presenters) {
            iBasePresenter.onStop();
        }
    }

    @Override
    public void onDestroyView() {
        for (IBasePresenter iBasePresenter : presenters) {
            iBasePresenter.onDestroyView();
        }
    }

    @Override
    public void onDestroy() {
        for (IBasePresenter iBasePresenter : presenters) {
            iBasePresenter.onDestroy();
        }
    }
}
