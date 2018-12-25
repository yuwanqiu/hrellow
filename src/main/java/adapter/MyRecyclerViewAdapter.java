package adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.my_qi_yuekao.Main2Activity;
import com.example.my_qi_yuekao.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import bean.Bean;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private Context context;
    private List<Bean.MessageBean.AnchorsBean> data;

    public MyRecyclerViewAdapter(Context context, List<Bean.MessageBean.AnchorsBean> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.list_item, null);
        MyViewHolder myViewHolder = new MyViewHolder(inflate);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        Picasso.with(context).load(data.get(i).getPic51()).into(myViewHolder.iv);
        myViewHolder.tv.setText(data.get(i).getName());
        myViewHolder.iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, Main2Activity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
