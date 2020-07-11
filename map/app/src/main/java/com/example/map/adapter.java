package com.example.map;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class adapter extends RecyclerView.Adapter<adapter.MyviewHolder> {
    private List<Team> list;
    private View inflater;

    public adapter(List<Team>teamList) {
        this.list = teamList;
    }
    @NonNull
    @Override
    public adapter.MyviewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        //创建viewholder,返回每一项的布局
        inflater = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        MyviewHolder myviewHolder = new MyviewHolder(inflater);
        return myviewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {
        //将数据和控件绑定
        Team team = list.get(position);
        holder.teamImage.setImageResource(team.getImageid());

    }



    @Override
    public int getItemCount() {
        //返回item总条数
        return list.size();
    }

    //内部类，绑定控件
    class MyviewHolder extends RecyclerView.ViewHolder{

        View teamView;
        ImageView teamImage;
        public MyviewHolder(View itemView){
            super(itemView);
            teamView = itemView;
            teamImage = itemView.findViewById(R.id.imageView);
        }
    }
}
