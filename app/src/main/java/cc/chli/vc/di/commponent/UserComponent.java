package cc.chli.vc.di.commponent;


import cc.chli.vc.di.module.UserModule;
import cc.chli.vc.di.scope.ActivityScope;
import cc.chli.vc.mvp.ui.activity.MainActivity;
import dagger.Component;

/**
 * Created by Administrator on 2016/10/26.
 */
@ActivityScope
@Component(modules = UserModule.class,dependencies = AppComponent.class)
public interface UserComponent {
    void inject(MainActivity activity);
}

