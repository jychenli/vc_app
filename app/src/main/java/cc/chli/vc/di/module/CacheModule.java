package cc.chli.vc.di.module;



import javax.inject.Singleton;

import cc.chli.vc.mvp.model.api.cache.CommonCache;
import dagger.Module;
import dagger.Provides;
import io.rx_cache.internal.RxCache;

/**
 * Created by Administrator on 2016/10/25.
 */
@Module
public class CacheModule {

    @Singleton
    @Provides
    CommonCache provideCommonService(RxCache rxCache) {
        return rxCache.using(CommonCache.class);
    }


}
