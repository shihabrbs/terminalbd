package com.terminalbd.www.adapter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.terminalbd.www.R;
import com.terminalbd.www.model.StockItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StockItemAdapter extends RecyclerView.Adapter<StockItemAdapter.StockItemViewHolder>{

    private Context context;
    private List<StockItem> stockItems;

    public StockItemAdapter(Context context, List<StockItem> stockItems) {
        this.context = context;
        this.stockItems = stockItems;
    }

    @NonNull
    @Override
    public StockItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_for_stock_items,viewGroup,false);

        return new StockItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StockItemViewHolder salesItemViewHolder, final int i) {

        salesItemViewHolder.name.setText(stockItems.get(i).getName());
        salesItemViewHolder.pp.setText(String.valueOf(stockItems.get(i).getPurchasePrice()));
        salesItemViewHolder.mrp.setText(String.valueOf(stockItems.get(i).getSalesPrice()));
        salesItemViewHolder.qnt.setText(String.valueOf(stockItems.get(i).getQuantity()));
        salesItemViewHolder.unit.setText(stockItems.get(i).getUnit());

    }

    @Override
    public int getItemCount() {
        return stockItems != null ? stockItems.size() : 0;
    }

    public void setFilter(List<StockItem> stockItem) {
        stockItems = new ArrayList<>();
        stockItems.addAll(stockItem);
        notifyDataSetChanged();
    }

    public class StockItemViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.name)
        TextView name;

        @BindView(R.id.pp)
        TextView pp;

        @BindView(R.id.mrp)
        TextView mrp;

        @BindView(R.id.qnt)
        TextView qnt;

        @BindView(R.id.unit)
        TextView unit;



        public StockItemViewHolder(@NonNull View itemView) {
            super(itemView);

            ButterKnife.bind(this,itemView);
        }
    }
}
