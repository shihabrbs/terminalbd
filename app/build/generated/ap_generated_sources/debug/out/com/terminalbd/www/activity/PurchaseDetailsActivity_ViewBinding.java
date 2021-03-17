// Generated code from Butter Knife. Do not modify!
package com.terminalbd.www.activity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.terminalbd.www.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PurchaseDetailsActivity_ViewBinding implements Unbinder {
  private PurchaseDetailsActivity target;

  private View view7f0a0102;

  private View view7f0a00ea;

  @UiThread
  public PurchaseDetailsActivity_ViewBinding(PurchaseDetailsActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public PurchaseDetailsActivity_ViewBinding(final PurchaseDetailsActivity target, View source) {
    this.target = target;

    View view;
    target.vendor_name = Utils.findRequiredViewAsType(source, R.id.vendor_name, "field 'vendor_name'", TextView.class);
    target.account_no = Utils.findRequiredViewAsType(source, R.id.account_no, "field 'account_no'", TextView.class);
    target.invoice_id = Utils.findRequiredViewAsType(source, R.id.invoice_id, "field 'invoice_id'", TextView.class);
    target.created = Utils.findRequiredViewAsType(source, R.id.created, "field 'created'", TextView.class);
    target.totalBdt = Utils.findRequiredViewAsType(source, R.id.totalBdt, "field 'totalBdt'", TextView.class);
    target.paymentBdt = Utils.findRequiredViewAsType(source, R.id.paymentBdt, "field 'paymentBdt'", TextView.class);
    target.payment_method = Utils.findRequiredViewAsType(source, R.id.payment_method, "field 'payment_method'", TextView.class);
    target.salesBy = Utils.findRequiredViewAsType(source, R.id.salesBy, "field 'salesBy'", TextView.class);
    target.sale_total_tk = Utils.findRequiredViewAsType(source, R.id.sale_total_tk, "field 'sale_total_tk'", TextView.class);
    target.sale_discount_tk = Utils.findRequiredViewAsType(source, R.id.sale_discount_tk, "field 'sale_discount_tk'", TextView.class);
    target.sale_grand_total_tk = Utils.findRequiredViewAsType(source, R.id.sale_grand_total_tk, "field 'sale_grand_total_tk'", TextView.class);
    target.sales_details_item_rv = Utils.findRequiredViewAsType(source, R.id.sales_details_item_rv, "field 'sales_details_item_rv'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.edit_btn, "field 'edit_btn' and method 'onEditBtn'");
    target.edit_btn = Utils.castView(view, R.id.edit_btn, "field 'edit_btn'", Button.class);
    view7f0a0102 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onEditBtn();
      }
    });
    view = Utils.findRequiredView(source, R.id.delete_btn, "field 'delete_btn' and method 'onDeleteBtn'");
    target.delete_btn = Utils.castView(view, R.id.delete_btn, "field 'delete_btn'", Button.class);
    view7f0a00ea = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onDeleteBtn();
      }
    });
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.toolbar_title = Utils.findRequiredViewAsType(source, R.id.toolbar_title, "field 'toolbar_title'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PurchaseDetailsActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.vendor_name = null;
    target.account_no = null;
    target.invoice_id = null;
    target.created = null;
    target.totalBdt = null;
    target.paymentBdt = null;
    target.payment_method = null;
    target.salesBy = null;
    target.sale_total_tk = null;
    target.sale_discount_tk = null;
    target.sale_grand_total_tk = null;
    target.sales_details_item_rv = null;
    target.edit_btn = null;
    target.delete_btn = null;
    target.toolbar = null;
    target.toolbar_title = null;

    view7f0a0102.setOnClickListener(null);
    view7f0a0102 = null;
    view7f0a00ea.setOnClickListener(null);
    view7f0a00ea = null;
  }
}
