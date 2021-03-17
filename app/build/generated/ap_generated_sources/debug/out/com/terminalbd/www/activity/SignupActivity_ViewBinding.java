// Generated code from Butter Knife. Do not modify!
package com.terminalbd.www.activity;

import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.google.android.material.textfield.TextInputEditText;
import com.terminalbd.www.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SignupActivity_ViewBinding implements Unbinder {
  private SignupActivity target;

  @UiThread
  public SignupActivity_ViewBinding(SignupActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SignupActivity_ViewBinding(SignupActivity target, View source) {
    this.target = target;

    target.conditioncheckBox = Utils.findRequiredViewAsType(source, R.id.checkBox, "field 'conditioncheckBox'", CheckBox.class);
    target.mybtn = Utils.findRequiredViewAsType(source, R.id.textView3, "field 'mybtn'", TextView.class);
    target.phonenumber = Utils.findRequiredViewAsType(source, R.id.phonenumberid, "field 'phonenumber'", TextInputEditText.class);
    target.rg = Utils.findRequiredViewAsType(source, R.id.selectusertype, "field 'rg'", RadioGroup.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SignupActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.conditioncheckBox = null;
    target.mybtn = null;
    target.phonenumber = null;
    target.rg = null;
  }
}
