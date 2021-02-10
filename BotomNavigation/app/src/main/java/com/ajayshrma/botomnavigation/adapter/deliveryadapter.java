package com.ajayshrma.botomnavigation.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.ajayshrma.botomnavigation.R;
import com.ajayshrma.botomnavigation.fragments.DeliveryAddressfrag;
import com.ajayshrma.botomnavigation.fragments.DescFragment;
import com.ajayshrma.botomnavigation.fragments.PurchaseMealfrag;
import com.ajayshrma.botomnavigation.models.deliverymodel;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class deliveryadapter extends FirebaseRecyclerAdapter<deliverymodel,deliveryadapter.myviewholder> {


    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public deliveryadapter(@NonNull FirebaseRecyclerOptions<deliverymodel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull final deliverymodel model) {

        holder.addtext.setText(model.getAdd());


        holder.addtext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity=(AppCompatActivity)view.getContext();
                activity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container,new PurchaseMealfrag()).addToBackStack(null).commit();

            }
        });
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.deliver_area_demo,parent,false);
        return new myviewholder(view);

    }

    public class myviewholder extends RecyclerView.ViewHolder {
        TextView addtext;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            addtext=itemView.findViewById(R.id.add);
        }
    }


}
