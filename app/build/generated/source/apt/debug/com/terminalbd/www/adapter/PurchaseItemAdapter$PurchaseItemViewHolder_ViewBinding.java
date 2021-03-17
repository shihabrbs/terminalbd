// Generated code from Butter Knife. Do not modify!
package com.terminalbd.www.adapter;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.terminalbd.www.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PurchaseItemAdapter$PurchaseItemViewHolder_ViewBinding implements Unbinder {
  private PurchaseItemAdapter.PurchaseItemViewHolder target;

  @UiThread
  public PurchaseItemAdapter$PurchaseItemViewHolder_ViewBinding(
      PurchaseItemAdapter.PurchaseItemViewHolder target, View source) {
    this.target = target;

    target.sale_item_med_name = Utils.findRequiredViewAsType(source, R.id.sale_item_med_name, "field 'sale_item_med_name'", TextView.class);
    target.sale_item_mrp_price = Utils.findRequiredViewAsType(source, R.id.sale_item_mrp_price, "field 'sale_item_mrp_price'", EditText.class);
    target.sale_item_quantity = Utils.findRequiredViewAsType(source, R.id.sale_item_quantity, "field 'sale_item_quantity'", TextView.class);
    target.quantity_plus = Utils.findRequiredViewAsType(source, R.id.quantity_plus, "field 'quantity_plus'", TextView.class);
    target.quantity_minus = Utils.findRequiredViewAsType(source, R.id.quantity_minus, "field 'quantity_minus'", TextView.class);
    target.sale_item_sub_total = Utils.findRequiredViewAsType(source, R.id.sale_item_sub_total, "field 'sale_item_sub_total'", TextView.class);
    target.delete = Utils.findRequiredViewAsType(source, R.id.sale_item_delete, "field 'delete'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PurchaseItemAdapter.PurchaseItemViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.sale_item_med_name = null;
    target.sale_item_mrp_price = null;
    target.sale_item_quantity = null;
    target.quantity_plus = null;
    target.quantity_minus = null;
    target.sale_item_sub_total = null;
    target.delete = null;
  }
}
