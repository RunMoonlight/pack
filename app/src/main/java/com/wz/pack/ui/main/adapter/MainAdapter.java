package com.wz.pack.ui.main.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wz.pack.R;
import com.wz.pack.bean.MainBean;

import java.util.List;

/**
 - @Author:  wang_zhen1
 - @Time:  2018/1/15 0015 15:26
 - @Description:
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.viewHolder> {

    private List<MainBean.ResultsBean> list;
    private Context context;

    public MainAdapter(List<MainBean.ResultsBean> list) {
        this.list = list;
    }

    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new viewHolder(LayoutInflater.from(context).inflate(R.layout.item_test, parent, false));
    }

    @Override
    public void onBindViewHolder(viewHolder holder, int position) {
        if (list.get(position).getImages()!=null && list.get(position).getImages().size()>0){

            Glide.with(context).load(list.get(position).getImages().get(0)).crossFade().into(holder.imageView);
        }else {
            holder.imageView.setVisibility(View.GONE);
        }
        holder.textView.setText(list.get(position).getDesc());
        holder.textView1.setText("2017-9-7 12:00");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class viewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView textView, textView1;

        public viewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.image);
            textView = (TextView) itemView.findViewById(R.id.text);
            textView1 = (TextView) itemView.findViewById(R.id.text1);
        }
    }
}
