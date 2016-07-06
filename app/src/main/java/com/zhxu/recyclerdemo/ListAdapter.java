package com.zhxu.recyclerdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by xzhang on 2016/6/28.
 */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHold> {

    private Context mContext ;
    private List<DataBean> mList ;
    public ListAdapter(Context context,List<DataBean> list ){
        mContext = context ;
        mList = list ;
    }


    @Override
    public ListViewHold onCreateViewHolder(ViewGroup parent, int viewType) {

        //viewhold创建时的回调
        View view = View.inflate(mContext,R.layout.item_list,null) ;
        return new ListViewHold(view);
    }

    @Override
    public void onBindViewHolder(ListViewHold holder, int position) {
        //viewhold绑定数据时的回调
        DataBean bean = mList.get(position) ;
        holder.setData(bean) ;
    }

    @Override
    public int getItemCount() {
        if(mList != null){
            return mList.size() ;
        }
        return 0;
    }

    public class ListViewHold extends RecyclerView.ViewHolder {

        public ImageView iconView ;
        public TextView  tvName ;

        public ListViewHold(View itemView) {
            super(itemView);
            iconView = (ImageView) itemView.findViewById(R.id.item_list_iv_icon);
            tvName = (TextView) itemView.findViewById(R.id.item_list_iv_name);
        }

        public void setData(DataBean bean) {
            //TODO
            iconView.setImageResource(bean.icon);
            tvName.setText(bean.name);
        }
    }
}
