// Generated code from Butter Knife. Do not modify!
package com.terminalbd.www.fragments;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.terminalbd.www.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SettingsFragment_ViewBinding implements Unbinder {
  private SettingsFragment target;

  private View view7f0a0197;

  private View view7f0a0198;

  private View view7f0a0199;

  private View view7f0a019b;

  private View view7f0a019c;

  private View view7f0a01a3;

  private View view7f0a019d;

  private View view7f0a01a4;

  private View view7f0a01a2;

  private View view7f0a01a5;

  private View view7f0a01a0;

  private View view7f0a019f;

  private View view7f0a019a;

  @UiThread
  public SettingsFragment_ViewBinding(final SettingsFragment target, View source) {
    this.target = target;

    View view;
    target.manual_sync_layout = Utils.findRequiredViewAsType(source, R.id.manual_sync_layout, "field 'manual_sync_layout'", LinearLayout.class);
    target.medicine_layout = Utils.findRequiredViewAsType(source, R.id.medicine_layout, "field 'medicine_layout'", LinearLayout.class);
    target.manual_sync = Utils.findRequiredViewAsType(source, R.id.manual_sync, "field 'manual_sync'", TextView.class);
    target.export_sync_layout = Utils.findRequiredViewAsType(source, R.id.export_sync_layout, "field 'export_sync_layout'", LinearLayout.class);
    target.export_sync = Utils.findRequiredViewAsType(source, R.id.export_sync, "field 'export_sync'", TextView.class);
    view = Utils.findRequiredView(source, R.id.sync_anonymous_customer, "field 'sync_anonymous_customer' and method 'onAnonymousCustomer'");
    target.sync_anonymous_customer = Utils.castView(view, R.id.sync_anonymous_customer, "field 'sync_anonymous_customer'", ImageView.class);
    view7f0a0197 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onAnonymousCustomer();
      }
    });
    view = Utils.findRequiredView(source, R.id.sync_bank_account, "field 'sync_bank_account' and method 'onsync_bank_account'");
    target.sync_bank_account = Utils.castView(view, R.id.sync_bank_account, "field 'sync_bank_account'", ImageView.class);
    view7f0a0198 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onsync_bank_account();
      }
    });
    view = Utils.findRequiredView(source, R.id.sync_dims, "field 'sync_dims' and method 'onsync_dims'");
    target.sync_dims = Utils.castView(view, R.id.sync_dims, "field 'sync_dims'", ImageView.class);
    view7f0a0199 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onsync_dims();
      }
    });
    view = Utils.findRequiredView(source, R.id.sync_expense_category, "field 'sync_expense_category' and method 'onsync_expense_category'");
    target.sync_expense_category = Utils.castView(view, R.id.sync_expense_category, "field 'sync_expense_category'", ImageView.class);
    view7f0a019b = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onsync_expense_category();
      }
    });
    view = Utils.findRequiredView(source, R.id.sync_mobile_account, "field 'sync_mobile_account' and method 'onsync_mobile_account'");
    target.sync_mobile_account = Utils.castView(view, R.id.sync_mobile_account, "field 'sync_mobile_account'", ImageView.class);
    view7f0a019c = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onsync_mobile_account();
      }
    });
    view = Utils.findRequiredView(source, R.id.sync_system_users, "field 'sync_system_users' and method 'onsync_system_users'");
    target.sync_system_users = Utils.castView(view, R.id.sync_system_users, "field 'sync_system_users'", ImageView.class);
    view7f0a01a3 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onsync_system_users();
      }
    });
    view = Utils.findRequiredView(source, R.id.sync_product_category, "field 'sync_product_category' and method 'sync_product_category'");
    target.sync_product_category = Utils.castView(view, R.id.sync_product_category, "field 'sync_product_category'", ImageView.class);
    view7f0a019d = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.sync_product_category();
      }
    });
    view = Utils.findRequiredView(source, R.id.sync_transaction_method, "field 'sync_transaction_method' and method 'onsync_transaction_method'");
    target.sync_transaction_method = Utils.castView(view, R.id.sync_transaction_method, "field 'sync_transaction_method'", ImageView.class);
    view7f0a01a4 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onsync_transaction_method();
      }
    });
    view = Utils.findRequiredView(source, R.id.sync_stock, "field 'sync_stock' and method 'onsync_stock'");
    target.sync_stock = Utils.castView(view, R.id.sync_stock, "field 'sync_stock'", ImageView.class);
    view7f0a01a2 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onsync_stock();
      }
    });
    view = Utils.findRequiredView(source, R.id.sync_vendor, "field 'sync_vendor' and method 'onsync_vendor'");
    target.sync_vendor = Utils.castView(view, R.id.sync_vendor, "field 'sync_vendor'", ImageView.class);
    view7f0a01a5 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onsync_vendor();
      }
    });
    view = Utils.findRequiredView(source, R.id.sync_sales, "field 'sync_sales' and method 'onsync_sales'");
    target.sync_sales = Utils.castView(view, R.id.sync_sales, "field 'sync_sales'", ImageView.class);
    view7f0a01a0 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onsync_sales();
      }
    });
    view = Utils.findRequiredView(source, R.id.sync_purchase, "field 'sync_purchase' and method 'onsync_purchase'");
    target.sync_purchase = Utils.castView(view, R.id.sync_purchase, "field 'sync_purchase'", ImageView.class);
    view7f0a019f = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onsync_purchase();
      }
    });
    view = Utils.findRequiredView(source, R.id.sync_expense, "field 'sync_expense' and method 'onsync_expense'");
    target.sync_expense = Utils.castView(view, R.id.sync_expense, "field 'sync_expense'", ImageView.class);
    view7f0a019a = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onsync_expense();
      }
    });
    target.sales_mode_spinner = Utils.findRequiredViewAsType(source, R.id.sales_mode_spinner, "field 'sales_mode_spinner'", Spinner.class);
    target.printer_type_spinner = Utils.findRequiredViewAsType(source, R.id.printer_type_spinner, "field 'printer_type_spinner'", Spinner.class);
    target.camera_mode_spinner = Utils.findRequiredViewAsType(source, R.id.camera_mode_spinner, "field 'camera_mode_spinner'", Spinner.class);
    target.online_offline_mode = Utils.findRequiredViewAsType(source, R.id.online_offline_mode, "field 'online_offline_mode'", Switch.class);
    target.barcode_mode = Utils.findRequiredViewAsType(source, R.id.barcode_mode, "field 'barcode_mode'", Switch.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SettingsFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.manual_sync_layout = null;
    target.medicine_layout = null;
    target.manual_sync = null;
    target.export_sync_layout = null;
    target.export_sync = null;
    target.sync_anonymous_customer = null;
    target.sync_bank_account = null;
    target.sync_dims = null;
    target.sync_expense_category = null;
    target.sync_mobile_account = null;
    target.sync_system_users = null;
    target.sync_product_category = null;
    target.sync_transaction_method = null;
    target.sync_stock = null;
    target.sync_vendor = null;
    target.sync_sales = null;
    target.sync_purchase = null;
    target.sync_expense = null;
    target.sales_mode_spinner = null;
    target.printer_type_spinner = null;
    target.camera_mode_spinner = null;
    target.online_offline_mode = null;
    target.barcode_mode = null;

    view7f0a0197.setOnClickListener(null);
    view7f0a0197 = null;
    view7f0a0198.setOnClickListener(null);
    view7f0a0198 = null;
    view7f0a0199.setOnClickListener(null);
    view7f0a0199 = null;
    view7f0a019b.setOnClickListener(null);
    view7f0a019b = null;
    view7f0a019c.setOnClickListener(null);
    view7f0a019c = null;
    view7f0a01a3.setOnClickListener(null);
    view7f0a01a3 = null;
    view7f0a019d.setOnClickListener(null);
    view7f0a019d = null;
    view7f0a01a4.setOnClickListener(null);
    view7f0a01a4 = null;
    view7f0a01a2.setOnClickListener(null);
    view7f0a01a2 = null;
    view7f0a01a5.setOnClickListener(null);
    view7f0a01a5 = null;
    view7f0a01a0.setOnClickListener(null);
    view7f0a01a0 = null;
    view7f0a019f.setOnClickListener(null);
    view7f0a019f = null;
    view7f0a019a.setOnClickListener(null);
    view7f0a019a = null;
  }
}
