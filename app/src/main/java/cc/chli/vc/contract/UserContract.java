package cc.chli.vc.contract;



import java.util.List;

import cc.chli.vc.mvp.model.entity.User;
import cc.chli.vc.mvp.ui.adapter.DefaultAdapter;
import cc.chli.vc.mvp.ui.viewbase.BaseView;
import rx.Observable;

/**
 * Created by LYB on 2016/10/25.
 */
public interface UserContract {
    //对于经常使用的关于UI的方法可以定义到BaseView中,如显示隐藏进度条,和显示文字消息
    interface View extends BaseView {
        void setAdapter(DefaultAdapter adapter);
        void startLoadMore();
        void endLoadMore();
    }
    //Model层定义接口,外部只需关心model返回的数据,无需关心内部细节,及是否使用缓存
    interface Model {
        Observable<List<User>> getUsers(int lastIdQueried, boolean update);
    }
}