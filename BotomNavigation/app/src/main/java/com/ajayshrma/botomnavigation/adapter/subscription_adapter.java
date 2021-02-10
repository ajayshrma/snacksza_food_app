package com.ajayshrma.botomnavigation.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.ajayshrma.botomnavigation.R;
import com.ajayshrma.botomnavigation.fragments.DescFragment;
import com.ajayshrma.botomnavigation.models.Subscription_Model;
import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class subscription_adapter extends FirebaseRecyclerAdapter<Subscription_Model,subscription_adapter.myviewholder>

{


    public subscription_adapter(@NonNull FirebaseRecyclerOptions<Subscription_Model> options) {
        super(options);
    }



    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull final Subscription_Model model)
    {

 //       holder.

       holder.subs_title.setText(model.getTitle());
       holder.subs_rate.setText(model.getRate());
       holder.sub_detail.setText(model.getViewdetail());
       holder.sub_validity.setText(model.getValidity());

  //   Glide.with(holder.subs_img.getContext()).load(Subscription_Model.getImage()).into(holder.subs_img);

        holder.sub_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity=(AppCompatActivity)view.getContext();
                activity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container,new DescFragment(model.getTitle(),model.getTiffins(),model.getValidity(),model.getRate())).addToBackStack(null).commit();

            }
        });

    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_item,parent,false);
        return new myviewholder(view);

    }

    public class myviewholder extends RecyclerView.ViewHolder
    {
               Button sub_detail;
        TextView subs_title,subs_rate,sub_validity;
        CardView cardcolor;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            subs_title=itemView.findViewById(R.id.sub_title);
            subs_rate=itemView.findViewById(R.id.sub_rate);
            sub_detail=itemView.findViewById(R.id.viewDetail);
            sub_validity=itemView.findViewById(R.id.sub_validity);
            cardcolor=itemView.findViewById(R.id.itmfrag);

        }
    }

}


