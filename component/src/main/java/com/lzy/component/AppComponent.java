package com.lzy.component;

import dagger.Component;

/**
 * @author 林佐跃 <br/>
 * @since V 1.0 <br/>
 */
@Component
public interface AppComponent {

    void inject(ComponentActivity activity);


}
