package com.lzy.component;

import com.lzy.apt_annotation.AutoAttach;
import com.lzy.base.BaseActivityMVP;
import com.lzy.component.contract.ContractA;
import com.lzy.component.contract.ContractC;
import com.lzy.component.presenter.PresenterA;
import com.lzy.component.presenter.PresenterC;

import javax.inject.Inject;

/**
 * @author 林佐跃 <br/>
 * @since V 1.0 <br/>
 */
public class ComponentActivity extends BaseActivityMVP implements ContractA.View, ContractC.View {

    @AutoAttach
    @Inject
    PresenterA presenterA;
    @AutoAttach
    @Inject
    PresenterC presenterC;

    @Override
    protected int getLayoutId() {
        return R.layout.component_activity_component;
    }

    @Override
    public void showA() {
    }

    @Override
    public void showC() {

    }

    @Override
    protected void presenterInject() {
        DaggerAppComponent.builder().build().inject(this);
    }

    @Override
    protected void presenterAttach() {
        PresenterAutoAttach.attach_componentactivity(this);
    }
}
