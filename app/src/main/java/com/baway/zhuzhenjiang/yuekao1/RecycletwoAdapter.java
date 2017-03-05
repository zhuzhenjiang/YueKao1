package com.baway.zhuzhenjiang.yuekao1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * 作者：朱振江 on 2017/3/4 0004 14:06
 * 邮箱：zzjdys@Gmail.com
 * 类用途:
 */


public class RecycletwoAdapter extends RecyclerView.Adapter<RecycletwoAdapter.myviewhord> {
    private List<Bean.RsBean.ChildrenBeanX> mList;
    private Context mContext;
    private RecyclerView mRecyclerView;



    public RecycletwoAdapter(List<Bean.RsBean.ChildrenBeanX> list, Context context) {
        mList = list;
        mContext = context;
    }

    @Override
    public myviewhord onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.recycle_list_two,parent,false);
        myviewhord myviewhord=new myviewhord(view);
        return myviewhord;
    }

    @Override
    public void onBindViewHolder(myviewhord holder, int position) {
        Log.i("TAG", "onBindViewHolder: dddddddddd"+mList.get(position).getDirName());
        holder.mTextView.setText(mList.get(position).getDirName());
       
       // mViewadapter.setData(mList.get(position).getChildren()); 
        GridViewadapter gridViewadapter = new GridViewadapter(mContext,mList.get(position).getChildren());
        holder.mGridView.setAdapter(gridViewadapter);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class myviewhord extends RecyclerView.ViewHolder
    {
        private MyGridView mGridView;
        private TextView mTextView;
        public myviewhord(View itemView) {
            super(itemView);
            mTextView= (TextView) itemView.findViewById(R.id.two_text);
            mGridView = (MyGridView) itemView.findViewById(R.id.two_grid);
        }
    }
}
