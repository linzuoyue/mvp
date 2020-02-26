package com.lzy.component.presenter;

import com.lzy.base.BasePresenter;
import com.lzy.component.contract.ContractC;

import javax.inject.Inject;

/**
 * @author 林佐跃 <br/>
 * @since V 1.0 <br/>
 */
public class PresenterC extends BasePresenter<ContractC.View> implements ContractC.Presenter {

    @Inject
    public PresenterC() {

    }

    @Override
    public void getC() {
        mView.showC();
    }

}
