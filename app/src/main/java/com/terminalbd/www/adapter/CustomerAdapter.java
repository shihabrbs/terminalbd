package com.terminalbd.www.adapter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.terminalbd.www.R;
import com.terminalbd.www.model.AnonymousCustomer;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.CustomerViewHolder>{

    private Context context;
    private List<AnonymousCustomer> customers;

    public CustomerAdapter(Context context, List<AnonymousCustomer> customers) {
        this.context = context;
        this.customers = customers;
    }

    @NonNull
    @Override
    public CustomerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_for_customer,viewGroup,false);

        return new CustomerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomerViewHolder customerViewHolder, int i) {

        customerViewHolder.customerName.setText(customers.get(i).getName());
        customerViewHolder.customerMobile.setText(customers.get(i).getMobile());
    }

    @Override
    public int getItemCount() {
        return customers != null ? customers.size() : 0;
    }

    public class CustomerViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.customerName)
        TextView customerName;

        @BindView(R.id.customerMobile)
        TextView customerMobile;


        public CustomerViewHolder(@NonNull View itemView) {
            super(itemView);

            ButterKnife.bind(this,itemView);
        }
    }
}
