// Generated code from Butter Knife. Do not modify!
package com.terminalbd.www.adapter;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.terminalbd.www.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CustomerAdapter$CustomerViewHolder_ViewBinding implements Unbinder {
  private CustomerAdapter.CustomerViewHolder target;

  @UiThread
  public CustomerAdapter$CustomerViewHolder_ViewBinding(CustomerAdapter.CustomerViewHolder target,
      View source) {
    this.target = target;

    target.customerName = Utils.findRequiredViewAsType(source, R.id.customerName, "field 'customerName'", TextView.class);
    target.customerMobile = Utils.findRequiredViewAsType(source, R.id.customerMobile, "field 'customerMobile'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    CustomerAdapter.CustomerViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.customerName = null;
    target.customerMobile = null;
  }
}
