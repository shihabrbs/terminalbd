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

public class StockItemAdapter$StockItemViewHolder_ViewBinding implements Unbinder {
  private StockItemAdapter.StockItemViewHolder target;

  @UiThread
  public StockItemAdapter$StockItemViewHolder_ViewBinding(
      StockItemAdapter.StockItemViewHolder target, View source) {
    this.target = target;

    target.name = Utils.findRequiredViewAsType(source, R.id.name, "field 'name'", TextView.class);
    target.pp = Utils.findRequiredViewAsType(source, R.id.pp, "field 'pp'", TextView.class);
    target.mrp = Utils.findRequiredViewAsType(source, R.id.mrp, "field 'mrp'", TextView.class);
    target.qnt = Utils.findRequiredViewAsType(source, R.id.qnt, "field 'qnt'", TextView.class);
    target.unit = Utils.findRequiredViewAsType(source, R.id.unit, "field 'unit'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    StockItemAdapter.StockItemViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.name = null;
    target.pp = null;
    target.mrp = null;
    target.qnt = null;
    target.unit = null;
  }
}
