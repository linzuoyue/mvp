package com.lzy.mvp.presenter;

import com.lzy.base.BasePresenter;
import com.lzy.mvp.contract.ContractB;

import javax.inject.Inject;

/**
 * @author 林佐跃 <br/>
 * @since V 1.0 <br/>
 */
public class PresenterB extends BasePresenter<ContractB.View> implements ContractB.Presenter {

    @Inject
    public PresenterB() {

    }

    @Override
    public void getB() {
        mView.showB();
    }
}
