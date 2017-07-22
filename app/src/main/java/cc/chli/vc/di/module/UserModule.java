package cc.chli.vc.di.module;



import cc.chli.vc.contract.UserContract;
import cc.chli.vc.di.scope.ActivityScope;
import cc.chli.vc.mvp.model.UserModel;
import cc.chli.vc.mvp.model.api.cache.CacheManager;
import cc.chli.vc.mvp.model.api.service.ServiceManager;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2016/10/25.
 */
@Module
public class UserModule {
    private UserContract.View view;

    /**
     * 构建UserModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     * @param view
     */
    public UserModule(UserContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    UserContract.View provideUserView(){
        return this.view;
    }

    @ActivityScope
    @Provides
    UserContract.Model provideUserModel(ServiceManager serviceManager, CacheManager cacheManager){
        return new UserModel(serviceManager,cacheManager);
    }

}

