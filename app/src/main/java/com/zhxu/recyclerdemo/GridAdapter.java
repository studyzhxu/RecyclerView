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
public class GridAdapter extends RecyclerView.Adapter<GridAdapter.GridViewHold> {

    private Context mContext ;
    private List<DataBean> mList ;
    public GridAdapter(Context context, List<DataBean> list ){
        mContext = context ;
        mList = list ;
    }


    @Override
    public GridViewHold onCreateViewHolder(ViewGroup parent, int viewType) {

        //viewhold创建时的回调
        View view = View.inflate(mContext,R.layout.item_grid,null) ;
        return new GridViewHold(view);
    }

    @Override
    public void onBindViewHolder(GridViewHold holder, int position) {
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

    public class GridViewHold extends RecyclerView.ViewHolder {

        public ImageView iconView ;
        public TextView  tvName ;

        public GridViewHold(View itemView) {
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
