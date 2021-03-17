package com.terminalbd.www.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.terminalbd.www.R;
import com.terminalbd.www.model.ModelAddProduct;
import com.terminalbd.www.network.ApiInterface;
import com.terminalbd.www.network.RetrofitApiClient;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupActivity extends AppCompatActivity {
    Spinner spinner;

    ArrayList<String> myList;
    @BindView(R.id.checkBox)
    CheckBox conditioncheckBox;

    @BindView(R.id.textView3)
    TextView mybtn;

    @BindView(R.id.phonenumberid)
    TextInputEditText phonenumber;

    @BindView(R.id.selectusertype)
    RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        /*shoptypelist.add(0,"zero item");
        shoptypelist.add(1,"first item");
        shoptypelist.add(2,"second item");*/


        myList = (ArrayList<String>) getIntent().getSerializableExtra("mylist");


        ButterKnife.bind(this);

        rg.check(R.id.radio1);







        spinner = (Spinner) findViewById(R.id.spinnerid);
// Create an ArrayAdapter using the string array and a default spinner layout
        /*ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_spinner_item);*/

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, myList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {
                    ((TextView) parent.getChildAt(0)).setTextColor(Color.GRAY);
                    ((TextView) parent.getChildAt(0)).setTextSize(18);
                } else {
                    Toast.makeText(SignupActivity.this, "" + position, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        TextView textView = findViewById(R.id.dthana);
        String text = "Already have an account ? LOGIN";

        SpannableString ss = new SpannableString(text);

        ClickableSpan clickableSpan1 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {


                startActivity(new Intent(SignupActivity.this, SetupActivity.class));
                finish();

            }

            @Override
            public void updateDrawState(final TextPaint textPaint) {
                textPaint.setUnderlineText(false);
            }

        };
        ss.setSpan(clickableSpan1, 26, 31, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        ss.setSpan(new BackgroundColorSpan(Color.WHITE), 26, 31, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(new ForegroundColorSpan(Color.rgb(243, 156, 38)), 26, 31, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView.setText(ss);
        textView.setMovementMethod(LinkMovementMethod.getInstance());


        TextView textView2 = findViewById(R.id.termsandcondition);
        String text2 = "By using this app, you agree to the Terms and Condition";

        SpannableString sss = new SpannableString(text2);

        ClickableSpan clickableSpan2 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                //Toast.makeText(SetupActivity.this, "one", Toast.LENGTH_SHORT).show();
                showTermsDialog();

            }

            @Override
            public void updateDrawState(final TextPaint textPaint) {
                textPaint.setUnderlineText(false);
            }

        };
        sss.setSpan(clickableSpan2, 35, 55, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        sss.setSpan(new BackgroundColorSpan(Color.WHITE), 35, 55, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        sss.setSpan(new ForegroundColorSpan(Color.rgb(243, 156, 38)), 35, 55, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView2.setText(sss);
        textView2.setMovementMethod(LinkMovementMethod.getInstance());


        conditioncheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (conditioncheckBox.isChecked()) {
                    DrawableCompat.setTint(mybtn.getBackground(), ContextCompat.getColor(getApplicationContext(), R.color.orenge));
                    mybtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            final String value =
                                    ((RadioButton) findViewById(rg.getCheckedRadioButtonId()))
                                            .getText().toString();

                            /*Intent intent = new Intent(SignupActivity.this, VerifyOTPActivity.class);
                            intent.putExtra("PHONE", phonenumber.getText().toString());
                            startActivity(intent);*/
                            if (value.equals("Multiple User")) {
                                Intent intent = new Intent(SignupActivity.this, MultipleUserActivity.class);
                                //intent.putExtra("PHONE", phonenumber.getText().toString());
                                startActivity(intent);
                            } else {


                                Intent intent = new Intent(SignupActivity.this, VerifyOTPActivity.class);
                                //  intent.putExtra("PHONE", phonenumber.getText().toString());
                                startActivity(intent);
                            }

                        }
                    });
                } else {

                    DrawableCompat.setTint(mybtn.getBackground(), ContextCompat.getColor(getApplicationContext(), R.color.btn_disable));
                }
            }
        });


    }

    /* Terms and condition dialog */
    private void showTermsDialog() {
        LayoutInflater layoutInflater = LayoutInflater.from(SignupActivity.this);
        View view = layoutInflater.inflate(R.layout.dialog_terms, null);
        final AlertDialog.Builder builder = new AlertDialog.Builder(SignupActivity.this);

        builder.setView(view);

        final AlertDialog alertDialog = builder.create();
        alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        TextView close = view.findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });

        alertDialog.show();

    }

    /*@OnClick(R.id.gotologinpage)
    void gotologinpage(){
        startActivity(new Intent(SignupActivity.this, SetupActivity.class));
        finish();
    }*/
}