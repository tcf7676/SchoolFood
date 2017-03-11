package com.ealgles.cmf.daeyoung;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by TCF on 2017-01-30.
 */

public class Adapter1 extends RecyclerView.Adapter<Adapter1.ViewHolder>{
    private ArrayList <AdapterModel1> ArrayList1 = new ArrayList<>();

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.mainlistly1, parent, false);

        return new ViewHolder(v2);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
    ArrayList1.get(position);
    holder.imageview.setImageDrawable(ArrayList1.get(position).getImage());
    holder.textview.setText(ArrayList1.get(position).getTitle());
        //포지션에 대한 어레이리스트의 데이터를 불러온다

    }

    @Override
    public int getItemCount() {
        return ArrayList1.size();


    }

    public void AddItem(String string2, Drawable drawable1){
        AdapterModel1 item = new AdapterModel1();
        item.setTitle(string2);
        item.setImage(drawable1);
        ArrayList1.add(item);
    }
    public AdapterModel1 getitem(int position){
        return ArrayList1.get(position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView textview;
        ImageView imageview;
        ViewHolder(View v1)
        {super (v1);
        textview = (TextView) v1.findViewById(R.id.textView);
        imageview = (ImageView) v1.findViewById(R.id.imageView);

        }


    }
}
