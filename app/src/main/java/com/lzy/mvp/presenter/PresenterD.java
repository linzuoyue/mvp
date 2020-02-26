package com.lzy.mvp.presenter;

import com.lzy.base.BasePresenter;
import com.lzy.mvp.contract.ContractD;

import javax.inject.Inject;

/**
 * @author 林佐跃 <br/>
 * @since V 1.0 <br/>
 */
public class PresenterD extends BasePresenter<ContractD.View> implements ContractD.Presenter {

    @Inject
    public PresenterD() {

    }

    @Override
    public void getD() {
        mView.showD();
    }

}
