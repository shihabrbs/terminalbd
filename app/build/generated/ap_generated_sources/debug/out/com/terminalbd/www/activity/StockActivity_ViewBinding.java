// Generated code from Butter Knife. Do not modify!
package com.terminalbd.www.activity;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.terminalbd.www.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class StockActivity_ViewBinding implements Unbinder {
  private StockActivity target;

  @UiThread
  public StockActivity_ViewBinding(StockActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public StockActivity_ViewBinding(StockActivity target, View source) {
    this.target = target;

    target.stock_item_rv = Utils.findRequiredViewAsType(source, R.id.stock_item_rv, "field 'stock_item_rv'", RecyclerView.class);
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.toolbar_title = Utils.findRequiredViewAsType(source, R.id.toolbar_title, "field 'toolbar_title'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    StockActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.stock_item_rv = null;
    target.toolbar = null;
    target.toolbar_title = null;
  }
}
