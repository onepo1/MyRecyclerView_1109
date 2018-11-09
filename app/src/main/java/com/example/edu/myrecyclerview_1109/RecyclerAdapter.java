package com.example.edu.myrecyclerview_1109;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    ArrayList<HashMap<String,Object>>arrayList = null;
    public RecyclerAdapter(ArrayList<HashMap<String,Object>>arrayList){
//        데이터
//        new ArrayList<HashMap<String,Object>>(); 생성자
        this.arrayList = new ArrayList<HashMap<String,Object>>();
        this.arrayList = arrayList;
    }

    //    inner class
    //getter, setter 의미
    class MyViewHolder extends RecyclerView.ViewHolder{

        public ImageView itemImage;
        TextView itemTitle;
        TextView itemDetail;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage = (ImageView)itemView.findViewById(R.id.item_image);
            itemTitle = (TextView)itemView.findViewById(R.id.item_title);
            itemDetail = (TextView)itemView.findViewById(R.id.item_detail);
        }
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewTYpe) {
//        위제  viewGroup
//        LayoutInflater 웹의 반응형
        LayoutInflater inflate = LayoutInflater.from(parent.getContext());
        View view = inflate.inflate(R.layout.item_cardlayout,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position){
        HashMap<String, Object> hashMap = arrayList.get(position);//position 위젯의 위치값
        myViewHolder.itemTitle.setText((String)hashMap.get("title"));
        myViewHolder.itemImage.setImageResource((Integer)hashMap.get("image"));

        myViewHolder.itemImage.setImageResource((Integer)hashMap.get("image"));
//        myViewHolder.itemTitle.setText("0");
        myViewHolder.itemTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = ((TextView)v).getText().toString();
                Toast.makeText(v.getContext(),text,Toast.LENGTH_SHORT).show();
            }
        }
        );

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


}
