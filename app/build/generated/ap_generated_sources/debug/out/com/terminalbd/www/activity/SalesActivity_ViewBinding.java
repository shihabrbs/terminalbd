// Generated code from Butter Knife. Do not modify!
package com.terminalbd.www.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.terminalbd.www.R;
import com.terminalbd.www.utils.ClearableAutoCompleteTextView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SalesActivity_ViewBinding implements Unbinder {
  private SalesActivity target;

  private View view7f0a01e9;

  private View view7f0a00ac;

  private View view7f0a0097;

  private View view7f0a0098;

  private View view7f0a0160;

  private View view7f0a0083;

  @UiThread
  public SalesActivity_ViewBinding(SalesActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SalesActivity_ViewBinding(final SalesActivity target, View source) {
    this.target = target;

    View view;
    target.search = Utils.findRequiredViewAsType(source, R.id.med_search, "field 'search'", ClearableAutoCompleteTextView.class);
    target.sales_mrp = Utils.findRequiredViewAsType(source, R.id.sales_mrp, "field 'sales_mrp'", EditText.class);
    target.sales_quantity = Utils.findRequiredViewAsType(source, R.id.sales_quantity, "field 'sales_quantity'", EditText.class);
    target.saleItemRv = Utils.findRequiredViewAsType(source, R.id.sales_history_rv, "field 'saleItemRv'", RecyclerView.class);
    target.bs_sales_history_rv = Utils.findRequiredViewAsType(source, R.id.bs_sales_history_rv, "field 'bs_sales_history_rv'", RecyclerView.class);
    target.category_rv = Utils.findRequiredViewAsType(source, R.id.category_rv, "field 'category_rv'", RecyclerView.class);
    target.product_rv = Utils.findRequiredViewAsType(source, R.id.product_rv, "field 'product_rv'", RecyclerView.class);
    target.token_no_rv = Utils.findRequiredViewAsType(source, R.id.token_no_rv, "field 'token_no_rv'", RecyclerView.class);
    target.total_item_count = Utils.findRequiredViewAsType(source, R.id.total_item_count, "field 'total_item_count'", TextView.class);
    target.grand_total_text = Utils.findRequiredViewAsType(source, R.id.grand_total_text, "field 'grand_total_text'", TextView.class);
    view = Utils.findRequiredView(source, R.id.sale_layout, "field 'sale_layout' and method 'sale_layout'");
    target.sale_layout = Utils.castView(view, R.id.sale_layout, "field 'sale_layout'", RelativeLayout.class);
    view7f0a01e9 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.sale_layout();
      }
    });
    target.search_layout = Utils.findRequiredViewAsType(source, R.id.search_layout, "field 'search_layout'", LinearLayout.class);
    target.list_grid_layout = Utils.findRequiredViewAsType(source, R.id.list_grid_layout, "field 'list_grid_layout'", LinearLayout.class);
    target.title_layout = Utils.findRequiredViewAsType(source, R.id.title_layout, "field 'title_layout'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.category_all, "field 'category_all' and method 'onAllCategory'");
    target.category_all = Utils.castView(view, R.id.category_all, "field 'category_all'", TextView.class);
    view7f0a00ac = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onAllCategory();
      }
    });
    view = Utils.findRequiredView(source, R.id.barcode_scan, "field 'barcode_scan' and method 'onBarcodeScan'");
    target.barcode_scan = Utils.castView(view, R.id.barcode_scan, "field 'barcode_scan'", Button.class);
    view7f0a0097 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onBarcodeScan();
      }
    });
    view = Utils.findRequiredView(source, R.id.barcode_scan_list_grid, "field 'barcode_scan_list_grid' and method 'onBarcodeScanList'");
    target.barcode_scan_list_grid = Utils.castView(view, R.id.barcode_scan_list_grid, "field 'barcode_scan_list_grid'", Button.class);
    view7f0a0098 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onBarcodeScanList();
      }
    });
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.toolbar_title = Utils.findRequiredViewAsType(source, R.id.toolbar_title, "field 'toolbar_title'", TextView.class);
    view = Utils.findRequiredView(source, R.id.list_show_btn, "field 'list_show_btn' and method 'onShowBtn'");
    target.list_show_btn = Utils.castView(view, R.id.list_show_btn, "field 'list_show_btn'", FloatingActionButton.class);
    view7f0a0160 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onShowBtn();
      }
    });
    target.bottom_sheet = Utils.findRequiredViewAsType(source, R.id.bottom_sheet, "field 'bottom_sheet'", LinearLayout.class);
    target.list_grid_search = Utils.findRequiredViewAsType(source, R.id.list_grid_search, "field 'list_grid_search'", EditText.class);
    target.tokenLayout = Utils.findRequiredViewAsType(source, R.id.tokenLayout, "field 'tokenLayout'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.add_btn, "method 'add_btn'");
    view7f0a0083 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.add_btn();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    SalesActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.search = null;
    target.sales_mrp = null;
    target.sales_quantity = null;
    target.saleItemRv = null;
    target.bs_sales_history_rv = null;
    target.category_rv = null;
    target.product_rv = null;
    target.token_no_rv = null;
    target.total_item_count = null;
    target.grand_total_text = null;
    target.sale_layout = null;
    target.search_layout = null;
    target.list_grid_layout = null;
    target.title_layout = null;
    target.category_all = null;
    target.barcode_scan = null;
    target.barcode_scan_list_grid = null;
    target.toolbar = null;
    target.toolbar_title = null;
    target.list_show_btn = null;
    target.bottom_sheet = null;
    target.list_grid_search = null;
    target.tokenLayout = null;

    view7f0a01e9.setOnClickListener(null);
    view7f0a01e9 = null;
    view7f0a00ac.setOnClickListener(null);
    view7f0a00ac = null;
    view7f0a0097.setOnClickListener(null);
    view7f0a0097 = null;
    view7f0a0098.setOnClickListener(null);
    view7f0a0098 = null;
    view7f0a0160.setOnClickListener(null);
    view7f0a0160 = null;
    view7f0a0083.setOnClickListener(null);
    view7f0a0083 = null;
  }
}
