package com.lzy.component.contract;

import com.lzy.base.IBasePresenter;
import com.lzy.base.IBaseView;

/**
 * @author 林佐跃 <br/>
 * @since V 1.0 <br/>
 */
public interface ContractA {


    interface View extends IBaseView {

        void showA();

    }

    interface Presenter extends IBasePresenter<View> {

        void getA();

    }


}
