package com.example.hp.yogafitnessapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hp.yogafitnessapp.InterFace.ItemClickListner;
import com.example.hp.yogafitnessapp.Model.Exercise;
import com.example.hp.yogafitnessapp.R;
import com.example.hp.yogafitnessapp.ViewExercise;

import java.util.List;

/**
 * Created by hp on 25-07-2018.
 */

class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
{

    public ImageView image;
    public TextView text;
    private ItemClickListner itemClickListner;


    public RecyclerViewHolder(View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.ex_img);
        text = itemView.findViewById(R.id.ex_name);

        itemView.setOnClickListener(this);
    }

    public void setItemClickListner(ItemClickListner itemClickListner) {
        this.itemClickListner = itemClickListner;
    }

    @Override
    public void onClick(View view) {
        itemClickListner.onClick(view,getAdapterPosition());
    }
}

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder>{
    private List<Exercise> exerciseList;
    private Context context;

    public RecyclerViewAdapter(List<Exercise> exerciseList, Context context) {
        this.exerciseList = exerciseList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_exercise, parent,false);

        return new RecyclerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.image.setImageResource(exerciseList.get(position).getImage_id());
        holder.text.setText(exerciseList.get(position).getName());

        holder.setItemClickListner(new ItemClickListner() {
            @Override
            public void onClick(View view, int position) {
              // call to new activity
              Intent i = new Intent(context, ViewExercise.class);
              i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
              i.putExtra("image_id",exerciseList.get(position).getImage_id());
              i.putExtra("name",exerciseList.get(position).getName());
              context.startActivity(i);

                   }
        });
    }

    @Override
    public int getItemCount() {
        return exerciseList.size();
    }
}
