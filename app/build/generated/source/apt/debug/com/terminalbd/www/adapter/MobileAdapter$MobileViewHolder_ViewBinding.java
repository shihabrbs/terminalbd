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

public class MobileAdapter$MobileViewHolder_ViewBinding implements Unbinder {
  private MobileAdapter.MobileViewHolder target;

  @UiThread
  public MobileAdapter$MobileViewHolder_ViewBinding(MobileAdapter.MobileViewHolder target,
      View source) {
    this.target = target;

    target.vendorName = Utils.findRequiredViewAsType(source, R.id.vendorName, "field 'vendorName'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MobileAdapter.MobileViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.vendorName = null;
  }
}
