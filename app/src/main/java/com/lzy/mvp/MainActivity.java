package com.lzy.mvp;

import com.lzy.apt_annotation.AutoAttach;
import com.lzy.base.BaseActivityMVP;
import com.lzy.mvp.contract.ContractA;
import com.lzy.mvp.contract.ContractB;
import com.lzy.mvp.contract.ContractC;
import com.lzy.mvp.presenter.PresenterA;
import com.lzy.mvp.presenter.PresenterB;
import com.lzy.mvp.presenter.PresenterC;
import com.lzy.mvp.test.ViewPath;

import android.util.Log;

import javax.inject.Inject;

public class MainActivity extends BaseActivityMVP implements ContractA.View
        , ContractB.View, ContractC.View {


    @Inject
    @AutoAttach
    public PresenterA presenterA;
    @Inject
    @AutoAttach
    public PresenterB presenterB;
    @Inject
    @AutoAttach
    public PresenterC presenterC;

    @Override
    protected int getLayoutId() {
        return R.layout.component_activity_component;
    }

    @Override
    protected void bindData() {
        super.bindData();

        presenterA.getA();
        presenterB.getB();
        presenterC.getC();
    }

    @Override
    protected void presenterInject() {
        DaggerAppComponent.builder().build().inject(this);
    }

    @Override
    protected void presenterAttach() {
        PresenterAutoAttach.attach_mainactivity(this);
    }

    @Override
    public void showA() {
        Log.e("lzy", "showA");
    }

    @Override
    public void showB() {
        Log.e("lzy", "showB");
    }

    @Override
    public void showC() {
        Log.e("lzy", "showC");
    }
}