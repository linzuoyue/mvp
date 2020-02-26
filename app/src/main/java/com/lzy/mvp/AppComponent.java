package com.lzy.mvp;

import dagger.Component;

/**
 * @author 林佐跃 <br/>
 * @since V 1.0 <br/>
 */
@Component
public interface AppComponent {

    void inject(MainActivity mainActivity);

    void inject(ActivityB mainActivity);

}
