// Generated code from Butter Knife. Do not modify!
package com.terminalbd.www.fragments;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.terminalbd.www.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ExpenseCatFragment_ViewBinding implements Unbinder {
  private ExpenseCatFragment target;

  @UiThread
  public ExpenseCatFragment_ViewBinding(ExpenseCatFragment target, View source) {
    this.target = target;

    target.expense_category_rv = Utils.findRequiredViewAsType(source, R.id.expense_category_rv, "field 'expense_category_rv'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ExpenseCatFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.expense_category_rv = null;
  }
}
