// Generated code from Butter Knife. Do not modify!
package com.terminalbd.www.adapter;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.terminalbd.www.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ProductListAdapter$ProductListViewHolder_ViewBinding implements Unbinder {
  private ProductListAdapter.ProductListViewHolder target;

  @UiThread
  public ProductListAdapter$ProductListViewHolder_ViewBinding(
      ProductListAdapter.ProductListViewHolder target, View source) {
    this.target = target;

    target.name = Utils.findRequiredViewAsType(source, R.id.name, "field 'name'", TextView.class);
    target.mrp = Utils.findRequiredViewAsType(source, R.id.mrp, "field 'mrp'", TextView.class);
    target.quantity_plus = Utils.findRequiredViewAsType(source, R.id.quantity_plus, "field 'quantity_plus'", Button.class);
    target.quantity_minus = Utils.findRequiredViewAsType(source, R.id.quantity_minus, "field 'quantity_minus'", Button.class);
    target.sale_item_quantity = Utils.findRequiredViewAsType(source, R.id.sale_item_quantity, "field 'sale_item_quantity'", TextView.class);
    target.total = Utils.findRequiredViewAsType(source, R.id.total, "field 'total'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ProductListAdapter.ProductListViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.name = null;
    target.mrp = null;
    target.quantity_plus = null;
    target.quantity_minus = null;
    target.sale_item_quantity = null;
    target.total = null;
  }
}
