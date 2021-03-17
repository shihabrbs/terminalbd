package com.terminalbd.www.adapter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.terminalbd.www.R;
import com.terminalbd.www.model.Vendor;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VendorAdapter extends RecyclerView.Adapter<VendorAdapter.VendorViewHolder>{

    private Context context;
    private List<Vendor> vendors;

    public VendorAdapter(Context context, List<Vendor> vendors) {
        this.context = context;
        this.vendors = vendors;
    }

    @NonNull
    @Override
    public VendorViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_for_vendors,viewGroup,false);

        return new VendorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VendorViewHolder holder, int i) {

        holder.vendorName.setText(vendors.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return vendors != null ? vendors.size() : 0;
    }

    public class VendorViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.vendorName)
        TextView vendorName;



        public VendorViewHolder(@NonNull View itemView) {
            super(itemView);

            ButterKnife.bind(this,itemView);
        }
    }
}
