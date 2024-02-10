package com.example.contactapp.adpter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactapp.R;
import com.example.contactapp.model.ContactModel;

import java.util.ArrayList;
import java.util.List;

public class ContactAdpter extends RecyclerView.Adapter<ContactAdpter.DataViewHolder> {
    Activity activity;
    List<ContactModel> contactModelList = new ArrayList<>();

    public ContactAdpter(Activity activity,List<ContactModel> contactModelList){
        this.activity = activity;
        this.contactModelList = contactModelList;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(activity).inflate(R.layout.contact_page,parent,false);
        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
        holder.contactName.setText(contactModelList.get(position).name);
        holder.contactNumber.setText(contactModelList.get(position).number);
    }

    @Override
    public int getItemCount() {
        return contactModelList.size();
    }

    class DataViewHolder extends  RecyclerView.ViewHolder{
        LinearLayout tileLiner;
        TextView contactName,contactNumber;
        public DataViewHolder(@NonNull View itemView) {
            super(itemView);
            tileLiner = itemView.findViewById(R.id.tileLiner);
            contactName = itemView.findViewById(R.id.contactName);
            contactNumber = itemView.findViewById(R.id.contactNumber);


        }
    }
}
