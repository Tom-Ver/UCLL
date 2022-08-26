package be.ucll.electroman.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import be.ucll.electroman.R;
import be.ucll.electroman.UpdateDataActivity;
import be.ucll.electroman.entities.UserWithWorkorders;
import be.ucll.electroman.entities.Workorder;

public class UserWithWorkordersAdapter extends RecyclerView.Adapter<UserWithWorkordersAdapter.ViewHolder> {

    Context context;
    UserWithWorkorders userWithWorkorders;
    View view;

    public UserWithWorkordersAdapter(Context context){this.context = context;}
    public UserWithWorkordersAdapter(Context context, UserWithWorkorders userWithWorkorders){
        this.context = context;
        this.userWithWorkorders = userWithWorkorders;
    }

    @NonNull
    @Override
    public UserWithWorkordersAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.rv_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(userWithWorkorders != null && userWithWorkorders.workorders.size()>0){
            Workorder workorder = userWithWorkorders.workorders.get(position);
            holder.city_tv.setText(String.valueOf(workorder.getCity()));
            holder.device_tv.setText(String.valueOf(workorder.getDevice()));
            holder.problemCode_tv.setText(String.valueOf(workorder.getProblemCode()));
            holder.name_tv.setText(String.valueOf(workorder.getCustomerName()));

            //If processed is true show Text otherwise show the button
            if(workorder.getProcessed()){
                holder.processed_tv.setVisibility(View.VISIBLE);
                holder.processed_tv.setText(String.valueOf(workorder.getProcessed()));}
            else{
                holder.processed_btn.setVisibility(View.VISIBLE);
            }

            holder.tr.setOnClickListener(view -> context.startActivity(new Intent(context, UpdateDataActivity.class)
                    .putExtra("workorder", workorder)
                    .putExtra("user", userWithWorkorders.user)));

            holder.processed_btn.setOnClickListener(view -> {
                workorder.setProcessed(true);
                context.startActivity(new Intent(context, UpdateDataActivity.class)
                        .putExtra("workorder", workorder)
                        .putExtra("user", userWithWorkorders.user));
            });
        }

    }

    @Override
    public int getItemCount() {
        return userWithWorkorders.workorders.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView city_tv;
        TextView device_tv;
        TextView problemCode_tv;
        TextView name_tv;
        TextView processed_tv;
        Button processed_btn;
        TableRow tr;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            city_tv = itemView.findViewById(R.id.City_tv);
            device_tv = itemView.findViewById(R.id.Device_tv);
            problemCode_tv = itemView.findViewById(R.id.ProblemCode_tv);
            name_tv = itemView.findViewById(R.id.Name_tv);
            processed_tv = itemView.findViewById(R.id.Processed_tv);
            processed_btn = itemView.findViewById(R.id.Processed_btn);
            tr = itemView.findViewById(R.id.tr);
        }
    }
}
