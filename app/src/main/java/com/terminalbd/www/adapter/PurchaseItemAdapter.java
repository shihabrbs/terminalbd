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
import com.terminalbd.www.model.PurchaseItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmResults;

public class PurchaseItemAdapter extends RecyclerView.Adapter<PurchaseItemAdapter.PurchaseItemViewHolder>{

    private Context context;
    private List<PurchaseItem> purchaseItems;
    private Realm realm;
    private int quantity;
    private int subTotal;

    public PurchaseItemAdapter(Context context, List<PurchaseItem> purchaseItems) {
        this.context = context;
        this.purchaseItems = purchaseItems;

        realm = Realm.getDefaultInstance();
    }

    @NonNull
    @Override
    public PurchaseItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_for_sales_item,viewGroup,false);

        return new PurchaseItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final PurchaseItemViewHolder salesItemViewHolder, final int i) {

        salesItemViewHolder.sale_item_med_name.setText(purchaseItems.get(i).getPurchaseItemName());
        salesItemViewHolder.sale_item_mrp_price.setText(purchaseItems.get(i).getPurchasePpPrice());
        salesItemViewHolder.sale_item_quantity.setText(purchaseItems.get(i).getPurchaseQuantity());


        salesItemViewHolder.sale_item_sub_total.setText("৳"+purchaseItems.get(i).getPurchaseSubTotal());

        salesItemViewHolder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final RealmResults<PurchaseItem> purchaseItems = realm.where(PurchaseItem.class).findAll();

                realm.beginTransaction();
                PurchaseItem saleItem = purchaseItems.get(i);
                saleItem.deleteFromRealm();
                realm.commitTransaction();
            }
        });

        salesItemViewHolder.quantity_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final RealmResults<PurchaseItem> purchaseItems = realm.where(PurchaseItem.class).findAll();

                realm.beginTransaction();
                PurchaseItem saleItem = purchaseItems.get(i);
                quantity = Integer.parseInt(saleItem.getPurchaseQuantity());
                quantity++;
                subTotal = (int) Math.round(Double.valueOf(saleItem.getPurchasePpPrice())*quantity);
                salesItemViewHolder.sale_item_quantity.setText(String.valueOf(quantity));
                salesItemViewHolder.sale_item_sub_total.setText("৳"+subTotal);
                saleItem.setPurchaseQuantity(String.valueOf(quantity));
                saleItem.setPurchaseSubTotal(String.valueOf(subTotal));
                realm.commitTransaction();
            }
        });

        salesItemViewHolder.quantity_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final RealmResults<PurchaseItem> purchaseItems = realm.where(PurchaseItem.class).findAll();

                realm.beginTransaction();
                PurchaseItem saleItem = purchaseItems.get(i);
                quantity = Integer.parseInt(saleItem.getPurchaseQuantity());
                quantity--;

                if (quantity>0)
                {
                    subTotal = (int) Math.round(Double.valueOf(saleItem.getPurchasePpPrice())*quantity);
                    salesItemViewHolder.sale_item_quantity.setText(String.valueOf(quantity));
                    salesItemViewHolder.sale_item_sub_total.setText("৳"+subTotal);
                    saleItem.setPurchaseQuantity(String.valueOf(quantity));
                    saleItem.setPurchaseSubTotal(String.valueOf(subTotal));

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
                    final RealmResults<PurchaseItem> purchaseItems = realm.where(PurchaseItem.class).findAll();

                    realm.beginTransaction();
                    PurchaseItem saleItem = purchaseItems.get(i);
                    quantity = Integer.parseInt(saleItem.getPurchaseQuantity());
                    saleItem.setPurchasePpPrice(salesItemViewHolder.sale_item_mrp_price.getText().toString());
                    subTotal = (int) Math.round(Double.valueOf(salesItemViewHolder.sale_item_mrp_price.getText().toString())*quantity);
                    salesItemViewHolder.sale_item_sub_total.setText("৳"+subTotal);
                    saleItem.setPurchaseSubTotal(String.valueOf(subTotal));

                    realm.commitTransaction();

                }
                return handled;
            }
        });


    }

    @Override
    public int getItemCount() {
        return purchaseItems != null ? purchaseItems.size() : 0;
    }

    public class PurchaseItemViewHolder extends RecyclerView.ViewHolder {

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



        public PurchaseItemViewHolder(@NonNull View itemView) {
            super(itemView);

            ButterKnife.bind(this,itemView);
        }
    }
}
