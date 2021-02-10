package com.ajayshrma.botomnavigation.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.ajayshrma.botomnavigation.R;
import com.ajayshrma.botomnavigation.fragments.DescFragment;
import com.ajayshrma.botomnavigation.fragments.Specialitem_Detailfrag;
import com.ajayshrma.botomnavigation.models.special_item_model;
import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class special_item_adapter extends FirebaseRecyclerAdapter<special_item_model,special_item_adapter.specialViewholder> {



    public special_item_adapter(@NonNull FirebaseRecyclerOptions<special_item_model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull specialViewholder holder, int position, @NonNull final special_item_model model) {

        holder.special_item_rate.setText(model.getRate());

        Glide.with(holder.poster.getContext()).load(model.getTemplate()).into(holder.poster);

        holder.poster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity=(AppCompatActivity)view.getContext();
                activity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container,new Specialitem_Detailfrag(model.getItem_name(),model.getFoodpht(),model.getRate(),model.getTiming())).addToBackStack(null).commit();

            }
        });
    }

    @NonNull
    @Override
    public specialViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.special_iten_demo,parent,false);
        return new specialViewholder(view);
    }

    public class specialViewholder extends RecyclerView.ViewHolder {

        Button special_item_rate;
        ImageView poster;
        public specialViewholder(@NonNull View itemView) {
            super(itemView);
            special_item_rate=itemView.findViewById(R.id.special_item_rate_id);
            poster=itemView.findViewById(R.id.templateid);
        }
    }

}
