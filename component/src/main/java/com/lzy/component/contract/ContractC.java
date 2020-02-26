package com.lzy.component.contract;

import com.lzy.base.IBasePresenter;
import com.lzy.base.IBaseView;

/**
 * @author 林佐跃 <br/>
 * @since V 1.0 <br/>
 */
public interface ContractC {


    interface View extends IBaseView {

        void showC();

    }

    interface Presenter extends IBasePresenter<View> {

        void getC();

    }


}
