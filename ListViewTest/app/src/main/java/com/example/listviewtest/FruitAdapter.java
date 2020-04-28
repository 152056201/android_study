package com.example.listviewtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.customview.widget.ViewDragHelper;

import java.util.List;

public class FruitAdapter extends ArrayAdapter<Fruit> {
    private int resourceId;
    public FruitAdapter(Context context, int textViewResourceId, List<Fruit> objects){
        super(context,textViewResourceId,objects);
        resourceId = textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Fruit fruit = getItem(position); //获取Fruit实例
        View view;
        ViewHolder viewHolder;
        //convertView参数用于加载之前的布局进行缓存，提高效率
        if(convertView==null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.imageView = view.findViewById(R.id.image_view);
            viewHolder.textView = view.findViewById(R.id.fruit_name);
            view.setTag(viewHolder);
        }else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        /*ImageView imageView = (ImageView) view.findViewById(R.id.image_view);
        TextView textView = (TextView) view.findViewById(R.id.fruit_name);
        imageView.setImageResource(fruit.getImageId());
        textView.setText(fruit.getName());*/
        viewHolder.imageView.setImageResource(fruit.getImageId());
        viewHolder.textView.setText(fruit.getName());
        return view;
    }
    //新增一个内部类对控件实例进行缓存
    class ViewHolder{
        ImageView imageView;
        TextView textView;
    }

}
