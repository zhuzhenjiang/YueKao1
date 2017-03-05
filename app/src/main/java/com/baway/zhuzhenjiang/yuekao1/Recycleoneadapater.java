package com.baway.zhuzhenjiang.yuekao1;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * 作者：朱振江 on 2017/3/4 0004 09:39
 * 邮箱：zzjdys@Gmail.com
 * 类用途:
 */


public class Recycleoneadapater extends RecyclerView.Adapter<Recycleoneadapater.myviewhord> implements View.OnClickListener{

    private List<Bean.RsBean> mList;
    private Context mContext;
    private RecyclerView mRecyclerView;
    private OnietmClickListener_ mOnietmClickListener_;
    
    public Recycleoneadapater(List<Bean.RsBean> list, Context context) {
        mList = list;
        mContext = context;
    }

 

    
    public interface OnietmClickListener_
    {
        void onClick_(int position);
    }


    public void setOnietmClickListener_(OnietmClickListener_ onietmClickListener_) {
        this.mOnietmClickListener_ = onietmClickListener_;
    }

    @Override
    public myviewhord onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.recycle_list_one,parent,false);
        myviewhord myviewhord=new myviewhord(view);
        view.setOnClickListener(this);
        return myviewhord;
    }
    
    @Override
    public void onBindViewHolder(myviewhord holder, int position) {
        String dirName = mList.get(position).getDirName();
        int listid=Myapp.list_id;
        
        holder.mTextView.setText(dirName);
        
        if (listid==position)
        {
            holder.mTextView.setTextColor(Color.GREEN);
            holder.mTextView.setBackgroundColor(Color.WHITE);
        }
        else 
        {
            holder.mTextView.setTextColor(Color.BLACK);
            holder.mTextView.setBackgroundColor(Color.parseColor("#F2F2F2"));
        }
        
        
    }
    //绑定
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
           this.mRecyclerView=recyclerView;     
            
    }
    //解绑
    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.mRecyclerView=null;
    }
    @Override
    public void onClick(View v) {
        if(mOnietmClickListener_ != null){
            int position = mRecyclerView.getChildAdapterPosition(v);
            mOnietmClickListener_.onClick_(position);
        }

    }
    @Override
    public int getItemCount() {
        return mList.size();
    }

    


    class myviewhord extends RecyclerView.ViewHolder
    {
        private TextView mTextView;        
        public myviewhord(View itemView) {
            super(itemView);
            mTextView= (TextView) itemView.findViewById(R.id.cecycle_list_text);
        }
    }
    
}
