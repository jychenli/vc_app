package cc.chli.vc.di.commponent;

import android.app.Application;

import com.google.gson.Gson;

import com.tbruyelle.rxpermissions.RxPermissions;

import javax.inject.Singleton;

import cc.chli.vc.di.module.AppModule;
import cc.chli.vc.di.module.CacheModule;
import cc.chli.vc.di.module.ClientModule;
import cc.chli.vc.di.module.ImageModule;
import cc.chli.vc.di.module.ServiceModule;
import cc.chli.vc.mvp.model.api.cache.CacheManager;
import cc.chli.vc.mvp.model.api.service.ServiceManager;
import cc.chli.vc.mvp.ui.widget.imageloader.ImageLoader;
import dagger.Component;
import okhttp3.OkHttpClient;

/**
 * Created by Administrator on 2016/10/25.
 */
@Singleton
@Component(modules = {AppModule.class, ClientModule.class,
        ServiceModule.class, ImageModule.class, CacheModule.class})
public interface AppComponent {

    Application Application();

    //服务管理器,retrofitApi
    ServiceManager serviceManager();

    //缓存管理器
    CacheManager cacheManager();

    //Rxjava错误处理管理类
    RxErrorHandler rxErrorHandler();

    //用于请求权限,适配6.0的权限管理
    RxPermissions rxPermissions();

    OkHttpClient okHttpClient();

    //图片管理器,用于加载图片的管理类,默认使用glide,使用策略模式,可替换框架
    ImageLoader imageLoader();

    //gson
    Gson gson();
}
