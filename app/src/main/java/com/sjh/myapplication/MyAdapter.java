package com.sjh.myapplication;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.sjh.myapplication.databinding.RecycleItemBinding;
import com.sjh.myapplication.model.ObservableFiledUser;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {
    
    private List<ObservableFiledUser> mData ;

    public MyAdapter(List<ObservableFiledUser> data) {
        this.mData = data;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return MyHolder.create(LayoutInflater.from(parent.getContext()), parent);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.bindTo(mData.get(position));
    }

    @Override
    public int getItemCount() {
        if (mData == null)
            return 0;
        return mData.size();
    }

    static class MyHolder extends RecyclerView.ViewHolder {
        // RecylceItemBinding 这个类的名字来源是 布局的名称 因为布局是recycle_item
        // 所以名字规则 布局名字 + Binging 则为生成的类名
        private RecycleItemBinding mBinding;

        static MyHolder create(LayoutInflater inflater, ViewGroup parent) {
            RecycleItemBinding binding = DataBindingUtil.inflate(inflater, R.layout.recycle_item, parent, false);
            return new MyHolder(binding);
        }

        private MyHolder(RecycleItemBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        public void bindTo(ObservableFiledUser user) {
            mBinding.setUser2(user);
            mBinding.executePendingBindings();
        }

    }
}
