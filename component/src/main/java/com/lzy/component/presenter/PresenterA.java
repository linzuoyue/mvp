package com.lzy.component.presenter;

import com.lzy.base.BasePresenter;
import com.lzy.component.contract.ContractA;

import javax.inject.Inject;

/**
 * @author 林佐跃 <br/>
 * @since V 1.0 <br/>
 */
public class PresenterA extends BasePresenter<ContractA.View> implements ContractA.Presenter {

    @Inject
    public PresenterA() {

    }

    @Override
    public void getA() {
        mView.showA();
    }
}
