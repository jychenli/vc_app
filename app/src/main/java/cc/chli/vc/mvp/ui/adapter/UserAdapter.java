package cc.chli.vc.mvp.ui.adapter;

import android.view.View;


import java.util.List;

import cc.chli.vc.R;
import cc.chli.vc.mvp.model.entity.User;
import cc.chli.vc.mvp.ui.holder.BaseHolder;
import cc.chli.vc.mvp.ui.holder.UserItemHolder;

/**
 * Created by Administrator on 2016/10/26.
 */
public class UserAdapter extends DefaultAdapter<User> {
    public UserAdapter(List<User> infos) {
        super(infos);
    }

    @Override
    public BaseHolder<User> getHolder(View v) {
        return new UserItemHolder(v);
    }

    @Override
    public int getLayoutId() {
        return R.layout.recycle_list;
    }
}