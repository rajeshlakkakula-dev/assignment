package com.rs.assignmenttest;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    List<List<String>> list_names;
    private final Context context;


    public DataAdapter(Context context, List<List<String>> data) {
        this.context = context;
        list_names = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        Context context = viewGroup.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.items_list, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.tv_names.setText(list_names.get(position).get(0));

        holder.mLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailsPage.class);
                intent.putExtra("name", list_names.get(position).get(0));
                intent.putExtra("designation", list_names.get(position).get(1));
                intent.putExtra("location", list_names.get(position).get(2));
                intent.putExtra("number", list_names.get(position).get(3));
                intent.putExtra("date", list_names.get(position).get(4));
                intent.putExtra("amount", list_names.get(position).get(5));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return list_names.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_names;
        LinearLayout mLinearLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_names = itemView.findViewById(R.id.tv_name);
            mLinearLayout = itemView.findViewById(R.id.linearLayout);
        }
    }
}
