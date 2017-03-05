package com.baway.zhuzhenjiang.yuekao1;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * 作者：朱振江 on 2017/3/4 0004 14:42
 * 邮箱：zzjdys@Gmail.com
 * 类用途:
 */


public class GridViewadapter extends BaseAdapter {
   // private List<Bean.RsBean.ChildrenBeanX.ChildrenBean> mList;
    private Context mContext;
    private  ImageLoader mImageLoader;
    private  DisplayImageOptions mOptions;
    List<Bean.RsBean.ChildrenBeanX.ChildrenBean> list;

    public GridViewadapter(Context context,List<Bean.RsBean.ChildrenBeanX.ChildrenBean> list) {
        mContext = context;
        mImageLoader = ImageLoader.getInstance();
        mOptions = ImageLoaderutils.initOptions();
        this.list = list;
    }

    /*public void setData(List<Bean.RsBean.ChildrenBeanX.ChildrenBean> list) {
        mList = list;
        //this.notifyDataSetChanged();
    }*/

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        viewhord v;
        if (convertView==null)
        {
            v=new viewhord();
            convertView=View.inflate(mContext,R.layout.gridview_item,null);
            v.mImageView= (ImageView) convertView.findViewById(R.id.item_image);
            v.mTextView= (TextView) convertView.findViewById(R.id.item_text);
            convertView.setTag(v);
        }else 
        {
            v= (viewhord) convertView.getTag();
        }

        //mImageLoader =ImageLoader.getInstance();
        mImageLoader.displayImage(list.get(position).getImgApp(),v.mImageView,mOptions);
        
        v.mTextView.setText(list.get(position).getDirName());
        
        return convertView;
    }
    
    class viewhord
    {
        ImageView mImageView;
        TextView mTextView;
    }
    
}
