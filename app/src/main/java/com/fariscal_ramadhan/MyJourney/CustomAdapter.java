package com.fariscal_ramadhan.MyJourney;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fariscal_ramadhan.R;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>{

    private Context context;
    private ArrayList<String> id, title, description;

    CustomAdapter(Context context,
                  ArrayList<String> id,
                  ArrayList<String> title,
                  ArrayList<String> description){
        this.context = context;
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView id, title, description;
        LinearLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.id);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        holder.id.setText(id.get(position));
        holder.title.setText(title.get(position));
        holder.description.setText(description.get(position));
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentPosition = holder.getAdapterPosition();
                Intent intent = new Intent(context, UpdateJourney.class);
                intent.putExtra("id", id.get(currentPosition));
                intent.putExtra("title", title.get(currentPosition));
                intent.putExtra("description", description.get(currentPosition));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return id.size();
    }
}
