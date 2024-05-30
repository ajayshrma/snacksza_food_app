package com.example.splash.login_Activity.all_pojo_class;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.splash.R;

import java.util.List;

public class progrmmingAdapter extends RecyclerView.Adapter<progrmmingAdapter .PrograamingViewholder>{

    List<user> data;
    Context context;

    public progrmmingAdapter( List<user> data ,Context context){

        this.context = context;
        this.data =data;

    }

    @NonNull
    @Override
    public PrograamingViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.item, parent, false);
        return new PrograamingViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PrograamingViewholder holder, int position) {
                user users = data.get(position);
                holder.textView.setText(users.getText());
                holder.imageView.setImageResource(users.getImageview());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class PrograamingViewholder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        public PrograamingViewholder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.img);
            textView=itemView.findViewById(R.id.txt);


        }
    }

}
