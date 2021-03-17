package com.terminalbd.www.adapter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.terminalbd.www.R;
import com.terminalbd.www.model.SaleItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmResults;

public class SalesItemAdapter extends RecyclerView.Adapter<SalesItemAdapter.SalesItemViewHolder> {

    private Context context;
    private List<SaleItem> saleItems;
    private Realm realm;
    private int quantity;
    private int subTotal;

    public SalesItemAdapter(Context context, List<SaleItem> saleItems) {
        this.context = context;
        this.saleItems = saleItems;

        realm = Realm.getDefaultInstance();
    }

    @NonNull
    @Override
    public SalesItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_for_sales_item,viewGroup,false);

        return new SalesItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final SalesItemViewHolder salesItemViewHolder, final int i) {

        salesItemViewHolder.sale_item_med_name.setText(saleItems.get(i).getSaleItemName());
        salesItemViewHolder.sale_item_mrp_price.setText(saleItems.get(i).getSaleMrpPrice());
        salesItemViewHolder.sale_item_quantity.setText(saleItems.get(i).getSaleQuantity());


        salesItemViewHolder.sale_item_sub_total.setText("৳"+saleItems.get(i).getSaleSubTotal());

        salesItemViewHolder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final RealmResults<SaleItem> saleItems = realm.where(SaleItem.class).findAll();

                realm.beginTransaction();
                SaleItem saleItem = saleItems.get(i);
                saleItem.deleteFromRealm();
                realm.commitTransaction();
            }
        });

        salesItemViewHolder.quantity_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final RealmResults<SaleItem> saleItems = realm.where(SaleItem.class).findAll();

                realm.beginTransaction();
                SaleItem saleItem = saleItems.get(i);
                quantity = Integer.parseInt(saleItem.getSaleQuantity());
                quantity++;
                subTotal = (int) Math.round(Double.valueOf(saleItem.getSaleMrpPrice())*quantity);
                salesItemViewHolder.sale_item_quantity.setText(String.valueOf(quantity));
                salesItemViewHolder.sale_item_sub_total.setText("৳"+subTotal);
                saleItem.setSaleQuantity(String.valueOf(quantity));
                saleItem.setSaleSubTotal(String.valueOf(subTotal));
                realm.commitTransaction();
            }
        });

        salesItemViewHolder.quantity_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final RealmResults<SaleItem> saleItems = realm.where(SaleItem.class).findAll();

                realm.beginTransaction();
                SaleItem saleItem = saleItems.get(i);
                quantity = Integer.parseInt(saleItem.getSaleQuantity());
                quantity--;

                if (quantity>0)
                {
                    subTotal = (int) Math.round(Double.valueOf(saleItem.getSaleMrpPrice())*quantity);
                    salesItemViewHolder.sale_item_quantity.setText(String.valueOf(quantity));
                    salesItemViewHolder.sale_item_sub_total.setText("৳"+subTotal);
                    saleItem.setSaleQuantity(String.valueOf(quantity));
                    saleItem.setSaleSubTotal(String.valueOf(subTotal));

                }else
                {
                    saleItem.deleteFromRealm();
                }

                realm.commitTransaction();


            }
        });


        salesItemViewHolder.sale_item_mrp_price.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {

                boolean handled = false;

                if (actionId == EditorInfo.IME_ACTION_DONE)
                {
                    handled = true;
                    final RealmResults<SaleItem> saleItems = realm.where(SaleItem.class).findAll();

                    realm.beginTransaction();
                    SaleItem saleItem = saleItems.get(i);
                    quantity = Integer.parseInt(saleItem.getSaleQuantity());
                    saleItem.setSaleMrpPrice(salesItemViewHolder.sale_item_mrp_price.getText().toString());
                    subTotal = (int) Math.round(Double.valueOf(salesItemViewHolder.sale_item_mrp_price.getText().toString())*quantity);
                    salesItemViewHolder.sale_item_sub_total.setText("৳"+subTotal);
                    saleItem.setSaleSubTotal(String.valueOf(subTotal));

                    realm.commitTransaction();

                }
                return handled;
            }
        });


    }

    @Override
    public int getItemCount() {
        return saleItems != null ? saleItems.size() : 0;
    }

    public class SalesItemViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.sale_item_med_name)
    TextView sale_item_med_name;


        @BindView(R.id.sale_item_mrp_price)
        EditText sale_item_mrp_price;

        @BindView(R.id.sale_item_quantity)
        TextView sale_item_quantity;

        @BindView(R.id.quantity_plus)
        TextView quantity_plus;

        @BindView(R.id.quantity_minus)
        TextView quantity_minus;

        @BindView(R.id.sale_item_sub_total)
        TextView sale_item_sub_total;

        @BindView(R.id.sale_item_delete)
        ImageView delete;



    public SalesItemViewHolder(@NonNull View itemView) {
        super(itemView);

        ButterKnife.bind(this,itemView);
    }
}

}