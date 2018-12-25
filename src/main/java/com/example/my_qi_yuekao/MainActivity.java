package com.example.my_qi_yuekao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.List;

import adapter.MyRecyclerViewAdapter;
import bean.Bean;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import server.Server;

public class MainActivity extends AppCompatActivity {

    private RecyclerView re;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        //http://qf.56.com/home/v4/moreAnchor.android?&type=0&index=0
        Retrofit retrofit = new Retrofit.Builder()//请求网络
                .baseUrl("http://qf.56.com/home/v4/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Server server = retrofit.create(Server.class);
        Call<Bean> beanCall = server.onReset();
        beanCall.enqueue(new Callback<Bean>() {//得到数据
            @Override
            public void onResponse(Call<Bean> call, Response<Bean> response) {
                Bean body = response.body();
                List<Bean.MessageBean.AnchorsBean> anchors = body.getMessage().getAnchors();//得到适配器并吧已经解析好的数据传入适配器
                MyRecyclerViewAdapter myRecyclerViewAdapter = new MyRecyclerViewAdapter(MainActivity.this, anchors);
                re.setAdapter(myRecyclerViewAdapter);
            }

            @Override
            public void onFailure(Call<Bean> call, Throwable t) {


            }
        });
    }

    private void initView() {
        re = (RecyclerView) findViewById(R.id.re);
        re.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
    }
}
