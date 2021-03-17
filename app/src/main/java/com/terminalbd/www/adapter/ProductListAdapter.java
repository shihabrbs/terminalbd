package com.terminalbd.www.adapter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.terminalbd.www.R;
import com.terminalbd.www.model.SaleItem;
import com.terminalbd.www.model.StockItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ProductListViewHolder> {

    private Context context;
    private List<StockItem> stockItemList;

    private Realm realm;
    private int quantity;
    private int subTotal;

    public ProductListAdapter(Context context, List<StockItem> stockItemList) {
        this.context = context;
        this.stockItemList = stockItemList;

        realm = Realm.getDefaultInstance();
    }

    @NonNull
    @Override
    public ProductListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_for_list_stock_item, viewGroup, false);

        return new ProductListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ProductListViewHolder holder, final int i) {

        holder.name.setText(stockItemList.get(i).getName());
        holder.mrp.setText(String.valueOf(stockItemList.get(i).getSalesPrice()));
        holder.sale_item_quantity.setText("0");
        holder.total.setText("৳0");
        holder.quantity_minus.setEnabled(false);

        List<SaleItem> saleItem = realm.where(SaleItem.class).findAll();
        if (saleItem.size() >0)
        {
            for (SaleItem item :
                    saleItem) {
                if (Integer.parseInt(item.getSaleStockId())==stockItemList.get(i).getItemId())
                {
                    holder.sale_item_quantity.setText(item.getSaleQuantity());
                    holder.quantity_minus.setEnabled(true);
                }
            }
        }

        holder.quantity_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                quantity = Integer.parseInt(holder.sale_item_quantity.getText().toString());
                holder.quantity_minus.setEnabled(true);

                if (quantity > 0) {
                    realm.beginTransaction();

                    SaleItem saleItem = realm.where(SaleItem.class).equalTo("saleStockId", String.valueOf(stockItemList.get(i).getItemId())).findFirst();

                    quantity = Integer.parseInt(holder.sale_item_quantity.getText().toString());
                    quantity++;
                    subTotal = (int) Math.round(Double.valueOf(stockItemList.get(i).getSalesPrice()) * quantity);
                    holder.sale_item_quantity.setText(String.valueOf(quantity));
                    holder.total.setText("৳" +subTotal);
//                    saleItem.setSaleStockId(String.valueOf(stockItemList.get(i).getItemId()));
//                    saleItem.setSaleItemName(stockItemList.get(i).getName());
//                    saleItem.setSalePpPrice(String.valueOf(stockItemList.get(i).getPurchasePrice()));
//                    saleItem.setSaleMrpPrice(String.valueOf(stockItemList.get(i).getSalesPrice()));
                    saleItem.setSaleQuantity(String.valueOf(quantity));
                    saleItem.setSaleSubTotal(String.valueOf(subTotal));

                    realm.copyToRealmOrUpdate(saleItem);
                    realm.commitTransaction();

                }else
                {
                    realm.beginTransaction();

                    SaleItem saleItem = new SaleItem();

                    quantity = Integer.parseInt(holder.sale_item_quantity.getText().toString());
                    quantity++;
                    subTotal = (int) Math.round(Double.valueOf(stockItemList.get(i).getSalesPrice()) * quantity);
                    holder.sale_item_quantity.setText(String.valueOf(quantity));
                    holder.total.setText("৳" + subTotal);
                    saleItem.setSaleStockId(String.valueOf(stockItemList.get(i).getItemId()));
                    saleItem.setSaleItemName(stockItemList.get(i).getName());
                    saleItem.setSalePpPrice(String.valueOf(stockItemList.get(i).getPurchasePrice()));
                    saleItem.setSaleMrpPrice(String.valueOf(stockItemList.get(i).getSalesPrice()));
                    saleItem.setSaleQuantity(String.valueOf(quantity));
                    saleItem.setSaleSubTotal(String.valueOf(subTotal));


                    realm.copyToRealmOrUpdate(saleItem);
                    realm.commitTransaction();
                }
            }
        });

        holder.quantity_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SaleItem saleItem = realm.where(SaleItem.class).equalTo("saleStockId",String.valueOf(stockItemList.get(i).getItemId())).findFirst();
                realm.beginTransaction();
                quantity = Integer.parseInt(saleItem.getSaleQuantity());
                quantity--;

                if (quantity > 0) {

                    subTotal = (int) Math.round(Double.valueOf(stockItemList.get(i).getSalesPrice()) * quantity);
                    holder.sale_item_quantity.setText(String.valueOf(quantity));
                    holder.total.setText("৳" + subTotal);
//                    saleItem.setSaleStockId(String.valueOf(stockItemList.get(i).getItemId()));
//                    saleItem.setSaleItemName(stockItemList.get(i).getName());
//                    saleItem.setSalePpPrice(String.valueOf(stockItemList.get(i).getPurchasePrice()));
//                    saleItem.setSaleMrpPrice(String.valueOf(stockItemList.get(i).getSalesPrice()));
                    saleItem.setSaleQuantity(String.valueOf(quantity));
                    saleItem.setSaleSubTotal(String.valueOf(subTotal));


                    realm.copyToRealmOrUpdate(saleItem);

                } else {
                    holder.sale_item_quantity.setText("0");
                    saleItem.deleteFromRealm();
                    holder.quantity_minus.setEnabled(false);
                }

                realm.commitTransaction();

            }
        });
    }

    @Override
    public int getItemCount() {
        return stockItemList != null ? stockItemList.size() : 0;
    }

    public void setFilter(List<StockItem> stockItem) {
        stockItemList = new ArrayList<>();
        stockItemList.addAll(stockItem);
        notifyDataSetChanged();
    }

    public class ProductListViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.name)
        TextView name;

        @BindView(R.id.mrp)
        TextView mrp;

        @BindView(R.id.quantity_plus)
        Button quantity_plus;

        @BindView(R.id.quantity_minus)
        Button quantity_minus;

        @BindView(R.id.sale_item_quantity)
        TextView sale_item_quantity;

        @BindView(R.id.total)
        TextView total;


        public ProductListViewHolder(@NonNull View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }

}
