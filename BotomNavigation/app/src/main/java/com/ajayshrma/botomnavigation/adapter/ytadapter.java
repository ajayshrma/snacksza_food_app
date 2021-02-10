package com.ajayshrma.botomnavigation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.ajayshrma.botomnavigation.R;
import com.ajayshrma.botomnavigation.models.ytmodel;

import java.util.List;

public class ytadapter extends RecyclerView.Adapter<ytadapter.ytviewholder> {


    List<ytmodel> data;
    Context context;

    public ytadapter(List<ytmodel> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public ytviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.youtubevideodemo, parent, false);
        return new ytviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ytviewholder holder, int position) {
        ytmodel ytmodel =data.get(position);

    }

    @Override
    public int getItemCount() {
        return data.size();

    }

    public class ytviewholder extends RecyclerView.ViewHolder {
        CardView cardView;
        public ytviewholder(@NonNull View itemView)
        {
            super(itemView);
            cardView=itemView.findViewById(R.id.ytcardid);
        }
    }

}
