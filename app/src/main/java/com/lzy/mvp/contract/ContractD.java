package com.lzy.mvp.contract;

import com.lzy.base.IBasePresenter;
import com.lzy.base.IBaseView;

/**
 * @author 林佐跃 <br/>
 * @since V 1.0 <br/>
 */
public interface ContractD {


    interface View extends IBaseView {

        void showD();

    }

    interface Presenter extends IBasePresenter<View> {

        void getD();

    }

}
