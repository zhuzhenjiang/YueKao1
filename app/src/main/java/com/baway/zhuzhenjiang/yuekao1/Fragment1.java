package com.baway.zhuzhenjiang.yuekao1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
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


public class Fragment1 extends Fragment{
    private View mView;
    private RecyclerView mRecycle_one;
    private List<Bean.RsBean> mList=new ArrayList<>();
    private Recycleoneadapater mRecycleoneadapater;
    private FragmentManager mManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragment_1,container,false);

        return mView;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mRecycle_one = (RecyclerView) mView.findViewById(R.id.Recycle_one);
        mManager = getActivity().getSupportFragmentManager();
        initData();
    }

    private void initData() {
        OkHttpManager.getAsync("http://mock.eoapi.cn/success/4q69ckcRaBdxhdHySqp2Mnxdju5Z8Yr4", new OkHttpManager.DataCallBack() {
            @Override
            public void requestFailure(Request request, IOException e) {
                
            }

            @Override
            public void requestSuccess(String result) throws Exception {
                Gson gson=new Gson();
                Bean bean = gson.fromJson(result, Bean.class);
                List<Bean.RsBean> rs = bean.getRs();    
                mList.addAll(rs);
                mRecycleoneadapater = new Recycleoneadapater(mList,getActivity());
                mRecycle_one.setLayoutManager(new LinearLayoutManager(getActivity()));
                mRecycle_one.setItemAnimator(new DefaultItemAnimator());
                mRecycle_one.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));

                mRecycle_one.setAdapter(mRecycleoneadapater);
                Fragment2 fragment2=Fragment2.getData(0);
                mManager.beginTransaction().add(R.id.fragment_,fragment2).commit();
                mRecycleoneadapater.setOnietmClickListener_(new Recycleoneadapater.OnietmClickListener_() {
                    @Override
                    public void onClick_(int position) {
                        Myapp.list_id=position;
                        mRecycleoneadapater.notifyDataSetChanged();
                        
                        Fragment2 fragment2=Fragment2.getData(position);
                        mManager.beginTransaction().replace(R.id.fragment_,fragment2).commit();
                        
                        
                        
                    }
                });
            }
        });
    
    
    }
  
}
