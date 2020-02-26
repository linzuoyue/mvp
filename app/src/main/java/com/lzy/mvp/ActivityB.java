package com.lzy.mvp;

import android.util.Log;

import com.lzy.apt_annotation.AutoAttach;
import com.lzy.base.BaseActivityMVP;
import com.lzy.mvp.contract.ContractA;
import com.lzy.mvp.contract.ContractB;
import com.lzy.mvp.contract.ContractD;
import com.lzy.mvp.presenter.PresenterA;
import com.lzy.mvp.presenter.PresenterB;
import com.lzy.mvp.presenter.PresenterD;

import javax.inject.Inject;

public class ActivityB extends BaseActivityMVP implements ContractA.View
        , ContractB.View, ContractD.View {


    @Inject
    @AutoAttach
    public PresenterA presenterA;
    @Inject
    @AutoAttach
    public PresenterB presenterB;
    @Inject
    @AutoAttach
    public PresenterD presenterD;

    @Override
    protected int getLayoutId() {
        return R.layout.component_activity_component;
    }

    @Override
    protected void bindData() {
        super.bindData();
        presenterA.getA();
        presenterB.getB();
        presenterD.getD();
    }

    @Override
    protected void presenterInject() {
        DaggerAppComponent.builder().build().inject(this);
    }

    @Override
    protected void presenterAttach() {
        PresenterAutoAttach.attach_activityb(this);
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
    public void showD() {
        Log.e("lzy", "showD");
    }
}
