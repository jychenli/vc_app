package cc.chli.vc.mvp.ui.holder;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.jakewharton.rxbinding.widget.RxTextView;

import butterknife.Bind;
import cc.chli.vc.R;
import cc.chli.vc.app.WEApplication;
import cc.chli.vc.mvp.model.entity.User;
import cc.chli.vc.mvp.ui.widget.imageloader.ImageLoader;
import cc.chli.vc.mvp.ui.widget.imageloader.glide.GlideImageConfig;
import rx.Observable;

/**
 * Created by Administrator on 2016/10/26.
 */
public class UserItemHolder extends BaseHolder<User> {

    @Nullable
    @Bind(R.id.iv_avatar)
    ImageView mAvater;
    @Nullable
    @Bind(R.id.tv_name)
    TextView mName;
    //用于加载图片的管理类,默认使用glide,使用策略模式,可替换框架
    private ImageLoader mImageLoader;
    private final WEApplication mApplication;

    public UserItemHolder(View itemView) {
        super(itemView);
        mApplication = (WEApplication) itemView.getContext().getApplicationContext();
        mImageLoader = mApplication.getAppComponent().imageLoader();
    }

    @Override
    public void setData(User data) {
        Observable.just(data.getLogin())
                .subscribe(RxTextView.text(mName));

        mImageLoader.loadImage(mApplication, GlideImageConfig
                .builder()
                .url(data.getAvatarUrl())
                .imagerView(mAvater)
                .build());
    }
}
