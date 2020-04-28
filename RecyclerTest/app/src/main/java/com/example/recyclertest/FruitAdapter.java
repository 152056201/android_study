package com.example.recyclertest;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {
    private List<Fruit> mfruitList;

    public FruitAdapter(List<Fruit> fruits) {
        mfruitList = fruits;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        View fruitView;
        ImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            fruitView = itemView;
            imageView = itemView.findViewById(R.id.fruit_image);
            textView = itemView.findViewById(R.id.fruit_name);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fruit_item, viewGroup, false);
        final ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.fruitView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position  = viewHolder.getAdapterPosition();
                Fruit fruit = mfruitList.get(position);
                Toast.makeText(v.getContext(),"121346578",Toast.LENGTH_SHORT).show();
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Fruit fruit = mfruitList.get(i);
        viewHolder.imageView.setImageResource(fruit.getImageId());
        viewHolder.textView.setText(fruit.getName());
    }


    @Override
    public int getItemCount() {
        return mfruitList.size();
    }
}
