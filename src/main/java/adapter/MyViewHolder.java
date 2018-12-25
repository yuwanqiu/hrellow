package adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.my_qi_yuekao.R;

public class MyViewHolder extends RecyclerView.ViewHolder {

    public ImageView iv;
    public TextView tv;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        iv = itemView.findViewById(R.id.iv);
        tv = itemView.findViewById(R.id.tv);
    }
}
