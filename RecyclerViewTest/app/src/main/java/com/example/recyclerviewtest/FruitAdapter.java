package com.example.recyclerviewtest;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {
    private List<Fruit> mFruitLIst;

    public FruitAdapter(List<Fruit> fruits) {
        mFruitLIst = fruits;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fruit_item_activity, viewGroup, false);
        final ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.fruitView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getAdapterPosition();
                Fruit fruit = mFruitLIst.get(position);
                Toast.makeText(v.getContext(), "you click view" + fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        viewHolder.fruitImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getAdapterPosition();
                Fruit fruit = mFruitLIst.get(position);
                Toast.makeText(v.getContext(), "you click image" + fruit.getImageId(), Toast.LENGTH_SHORT).show();
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Fruit fruit = mFruitLIst.get(i);
        viewHolder.fruitImage.setImageResource(fruit.getImageId());
        viewHolder.fruitName.setText(fruit.getName());
    }

    @Override
    public int getItemCount() {
        return mFruitLIst.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        View fruitView;
        ImageView fruitImage;
        TextView fruitName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            fruitView = itemView;
            fruitImage = (ImageView) itemView.findViewById(R.id.fruit_image);
            fruitName = (TextView) itemView.findViewById(R.id.fruit_name);
        }
    }
}
