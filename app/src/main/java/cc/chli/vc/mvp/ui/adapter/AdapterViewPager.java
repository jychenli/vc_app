package cc.chli.vc.mvp.ui.adapter;

import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.View;
import android.view.ViewGroup;


import java.util.List;

import cc.chli.vc.mvp.ui.fragment.BaseFragment;

/**
 * Created by Administrator on 2016/10/24.
 */
public class AdapterViewPager extends FragmentStatePagerAdapter {
    private List<BaseFragment> list;
    private String[] mLitles;

    public AdapterViewPager(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    public void bindData(List<BaseFragment> list) {
        this.list = list;
        notifyDataSetChanged();
    }
    public void bindData(List<BaseFragment> list, String[] titles) {
        this.list = list;
        this.mLitles = titles;
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (mLitles!=null){
            return mLitles[position];
        }
        return super.getPageTitle(position);
    }

    @Override
    public int  getCount() {
        return list.size();
    }

    @Override
    public Parcelable saveState() {
        return null;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Fragment f = (Fragment) super.instantiateItem(container, position);
        View view = f.getView();
        if (view != null)
            container.addView(view);
        return f;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = list.get(position).getView();
        if (view != null)
            container.removeView(view);
    }
}

