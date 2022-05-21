package com.example.shopeee.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopeee.R;
import com.example.shopeee.models.AddressModel;

import java.util.List;

public class AddressAdapter extends RecyclerView.Adapter<AddressAdapter.ViewHolder> {
    Context context;
    List<AddressModel> list;
    SelectedAddress selectedAddress;
    private RadioButton selectedButton;

    public AddressAdapter(Context context, List<AddressModel> list, SelectedAddress selectedAddress) {
        this.context = context;
        this.list = list;
        this.selectedAddress = selectedAddress;
    }

    public void setData(List<AddressModel> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.address_item, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.address.setText(list.get(position).getUserAddress());
        int pos  = position;
        holder.select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (AddressModel address : list) {
                    address.setSelected(false);
                }
                list.get(pos).setSelected(true);

                if (selectedButton != null) {
                    selectedButton.setChecked(false);

                }
                selectedButton = (RadioButton) view;
                selectedButton.setChecked(true);
                selectedAddress.setAddress(list.get(pos).getUserAddress());
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView address;
        RadioButton select;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            address = itemView.findViewById(R.id.address_add);
            select = itemView.findViewById(R.id.select_address);
        }
    }

    public interface SelectedAddress {
        void setAddress(String address);
    }
}
