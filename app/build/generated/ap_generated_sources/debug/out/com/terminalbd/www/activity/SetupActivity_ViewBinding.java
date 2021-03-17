// Generated code from Butter Knife. Do not modify!
package com.terminalbd.www.activity;

import android.view.View;
import android.widget.Button;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.material.textfield.TextInputEditText;
import com.terminalbd.www.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SetupActivity_ViewBinding implements Unbinder {
  private SetupActivity target;

  private View view7f0a00a4;

  private View view7f0a00ca;

  @UiThread
  public SetupActivity_ViewBinding(SetupActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SetupActivity_ViewBinding(final SetupActivity target, View source) {
    this.target = target;

    View view;
    target.mobile = Utils.findRequiredViewAsType(source, R.id.edit_setup_mobile, "field 'mobile'", TextInputEditText.class);
    target.uniqueKey = Utils.findRequiredViewAsType(source, R.id.edit_setup_unique_key, "field 'uniqueKey'", TextInputEditText.class);
    view = Utils.findRequiredView(source, R.id.button_setup, "field 'mybtn' and method 'setup'");
    target.mybtn = Utils.castView(view, R.id.button_setup, "field 'mybtn'", Button.class);
    view7f0a00a4 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.setup();
      }
    });
    view = Utils.findRequiredView(source, R.id.createnewbusiness, "method 'creatBusiness'");
    view7f0a00ca = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.creatBusiness();
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
    target.mybtn = null;

    view7f0a00a4.setOnClickListener(null);
    view7f0a00a4 = null;
    view7f0a00ca.setOnClickListener(null);
    view7f0a00ca = null;
  }
}
