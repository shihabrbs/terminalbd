// Generated code from Butter Knife. Do not modify!
package com.terminalbd.www.activity;

import android.view.View;
import android.widget.EditText;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.terminalbd.www.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SetupActivity_ViewBinding implements Unbinder {
  private SetupActivity target;

  private View view7f0a003d;

  @UiThread
  public SetupActivity_ViewBinding(SetupActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SetupActivity_ViewBinding(final SetupActivity target, View source) {
    this.target = target;

    View view;
    target.mobile = Utils.findRequiredViewAsType(source, R.id.edit_setup_mobile, "field 'mobile'", EditText.class);
    target.uniqueKey = Utils.findRequiredViewAsType(source, R.id.edit_setup_unique_key, "field 'uniqueKey'", EditText.class);
    view = Utils.findRequiredView(source, R.id.button_setup, "method 'setup'");
    view7f0a003d = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.setup();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    SetupActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mobile = null;
    target.uniqueKey = null;

    view7f0a003d.setOnClickListener(null);
    view7f0a003d = null;
  }
}
