package com.baway.zhuzhenjiang.yuekao1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Request;

/**
 * 作者：朱振江 on 2017/3/3 0003 20:17
 * 邮箱：zzjdys@Gmail.com
 * 类用途:
 */


public class Fragment2 extends Fragment {
    private View mView;
    private RecyclerView mRecycle_two;
    private RecycletwoAdapter mRecycletwoAdapter;
    private int mNum;
    private List<Bean.RsBean.ChildrenBeanX> mList=new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragment_2,container,false);

        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle arguments = getArguments();
        int num = arguments.getInt("num");
//        int mNum = getArguments().getInt("num");
        mRecycle_two = (RecyclerView) mView.findViewById(R.id.Recycle_two);
        
        initData(num);
        
        
       
        
    
    }
    
    public static Fragment2 getData(int id)
    {
        Fragment2 fragment2=new Fragment2();
        Bundle bundle=new Bundle();
        bundle.putInt("num",id);
        fragment2.setArguments(bundle);
        return fragment2;
    }

    private void initData(final int num) {
    OkHttpManager.getAsync("http://mock.eoapi.cn/success/4q69ckcRaBdxhdHySqp2Mnxdju5Z8Yr4", new OkHttpManager.DataCallBack() {
        @Override
        public void requestFailure(Request request, IOException e) {
            
        }

        @Override
        public void requestSuccess(String result) throws Exception {
            Gson gson=new Gson();
            Bean bean = gson.fromJson(result, Bean.class);
            Bean.RsBean rsBean = bean.getRs().get(num);
            List<Bean.RsBean.ChildrenBeanX> children = rsBean.getChildren();
            mList.addAll(children);
            mRecycletwoAdapter = new RecycletwoAdapter(mList,getActivity());
            mRecycle_two.setLayoutManager(new LinearLayoutManager(getActivity()));
           // mRecycle_two.setItemAnimator(new DefaultItemAnimator());
            //mRecycle_two.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.HORIZONTAL));
            mRecycle_two.setAdapter(mRecycletwoAdapter);
        }
    });
    
    
    
    }
}
