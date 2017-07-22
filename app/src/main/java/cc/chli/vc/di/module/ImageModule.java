package cc.chli.vc.di.module;



import javax.inject.Singleton;

import cc.chli.vc.mvp.ui.widget.imageloader.BaseImageLoaderStrategy;
import cc.chli.vc.mvp.ui.widget.imageloader.ImageLoader;
import cc.chli.vc.mvp.ui.widget.imageloader.glide.GlideImageLoaderStrategy;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2016/10/24.
 */
@Module
public class ImageModule {

    @Singleton
    @Provides
    public BaseImageLoaderStrategy provideImageLoaderStrategy() {
        return new GlideImageLoaderStrategy();
    }

    @Singleton
    @Provides
    public ImageLoader provideImageLoader(BaseImageLoaderStrategy strategy) {
        return new ImageLoader(strategy);
    }
}
