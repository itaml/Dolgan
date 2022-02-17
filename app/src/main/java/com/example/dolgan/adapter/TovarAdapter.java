package com.example.dolgan.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dolgan.R;
import com.example.dolgan.TovarPage;
import com.example.dolgan.model.Tovar;

import java.util.List;

public class TovarAdapter extends RecyclerView.Adapter<TovarAdapter.TovarViewHolder> {

    Context context;
    List<Tovar> tovars;

    public TovarAdapter(Context context, List<Tovar> tovars){
        this.context = context;
        this.tovars = tovars;
    }

    @NonNull
    @Override
    public TovarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View tovarItems = LayoutInflater.from(context).inflate(R.layout.tovar_item,parent, false);
        return new TovarAdapter.TovarViewHolder(tovarItems);
    }

    @Override
    public void onBindViewHolder(@NonNull TovarAdapter.TovarViewHolder holder, @SuppressLint("RecyclerView") int position) {
        int imageId = context.getResources().getIdentifier(tovars.get(position).getImg(),"drawable",context.getPackageName());
        holder.tovarImage.setImageResource(imageId);

        holder.tovarTitle.setText(tovars.get(position).getTitle());
        holder.tovarInfo.setText(tovars.get(position).getInfo());
        holder.tovarPrice.setText(tovars.get(position).getPrice());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, TovarPage.class);

                intent.putExtra("tovarImage", imageId);
                intent.putExtra("tovarTitle", tovars.get(position).getTitle());
                intent.putExtra("tovarInfo", tovars.get(position).getInfo());
                intent.putExtra("tovarPrice", tovars.get(position).getPrice());
                intent.putExtra("tovarId",tovars.get(position).getId());


                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return tovars.size();
    }

    public static final class  TovarViewHolder extends RecyclerView.ViewHolder{
        LinearLayout tovarBg;
        ImageView tovarImage;
        TextView tovarTitle, tovarInfo, tovarPrice;
        public TovarViewHolder(@NonNull View itemView) {
            super(itemView);

            tovarBg = itemView.findViewById(R.id.tovarBg);
            tovarImage = itemView.findViewById(R.id.tovarImage);
            tovarInfo = itemView.findViewById(R.id.tovarInfo);
            tovarPrice = itemView.findViewById(R.id.tovarPrice);
            tovarTitle = itemView.findViewById(R.id.tovarTitle);
        }
    }
}
