package com.terminalbd.www.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.terminalbd.www.R;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dmax.dialog.SpotsDialog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class VerifyOTPActivity extends AppCompatActivity {
   /* TextView phone ;
    TextView et_varification;
    ImageView back;


    ProgressBar progressBar;

    private String mVerificationId;
    private FirebaseAuth mAuth;*/

    @BindView(R.id.resendBtn)
    Button resendBtn;
    @BindView(R.id.verifyBtn)
    Button verifyBtn;

    String cc;
    String phone = "";
    String password = "";
    String tradeLicense = "";
    String licenseKey = "";
    String address = "";
    @BindView(R.id.edtOtp)
    EditText edtOtp;

    CompositeDisposable compositeDisposable;
    AlertDialog alertDialog;
    @BindView(R.id.registerCard)
    CardView registerCard;


    //firebase phone auth
    private String verificationID;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_otp);

       /* phone=findViewById(R.id.tt_verify_number);
        progressBar=findViewById(R.id.progressBar_verify);
        et_varification=findViewById(R.id.sign_up_verify_code);



      //  phone.setText(getIntent().getStringExtra("phone"));
        mAuth = FirebaseAuth.getInstance();




        progressBar.setVisibility(View.VISIBLE);

        sendVerificationCode();*/

        ButterKnife.bind(this);

        //initializing firebase auth
        mAuth = FirebaseAuth.getInstance();

        compositeDisposable = new CompositeDisposable();
        alertDialog = new SpotsDialog.Builder().setContext(VerifyOTPActivity.this).build();
        sendVerificationCode("+8801761632579");
       /* if (getIntent().getExtras() != null) {
            cc = getIntent().getExtras().getString("CODE");
            phone = getIntent().getExtras().getString("PHONE");
            password = getIntent().getExtras().getString("PASS");
            tradeLicense = getIntent().getExtras().getString("TRADE");
            licenseKey = getIntent().getExtras().getString("KEY");
            address = getIntent().getExtras().getString("ADDR");

            sendVerificationCode(cc + phone);

            Toast.makeText(this, "We have send a verification code to " + cc + phone, Toast.LENGTH_SHORT).show();
        }*/

        edtOtp.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (!TextUtils.isEmpty(editable.toString())) {

                    verifyBtn.setEnabled(true);
                    registerCard.setCardBackgroundColor(getResources().getColor(R.color.colorPrimary));

                }else
                {
                    verifyBtn.setEnabled(false);
                    registerCard.setCardBackgroundColor(getResources().getColor(R.color.grey_70));
                }
            }
        });


    }

    @OnClick(R.id.resendBtn)
    public void onResendBtnClicked() {
        Intent intent = getIntent();
        startActivity(intent);
        finish();
    }

    @OnClick(R.id.verifyBtn)
    public void onVerifyBtnClicked() {

        if (TextUtils.isEmpty(edtOtp.getText().toString())) {
            edtOtp.setError("Please enter OTP code");
            edtOtp.requestFocus();
            return;
        }
        alertDialog.show();

        verifyCode(edtOtp.getText().toString());

    }

    private void verifyCode(String code) {
        try {
            //creating the credential
            PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationID, code);
            //signing the user
            signInWithPhoneAuthCredential(credential);
        } catch (Exception e) {
            Toast.makeText(this, "Wrong otp code . Try Again", Toast.LENGTH_SHORT).show();
        }
    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential phoneAuthCredential) {
        mAuth.signInWithCredential(phoneAuthCredential)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            Toast.makeText(VerifyOTPActivity.this, "Ok", Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }


    private void sendVerificationCode(String number) {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                number,        // Phone number to verify
                20,                 // Timeout duration
                TimeUnit.SECONDS,   // Unit of timeout
                this,               // Activity (for callback binding)
                mCallbacks);
    }

    private PhoneAuthProvider.OnVerificationStateChangedCallbacks
            mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);

            verificationID = s;
        }

        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {

            String code = phoneAuthCredential.getSmsCode();

            if (code != null) {
                edtOtp.setText(code);

                verifyCode(code);
            }
        }

        @Override
        public void onVerificationFailed(FirebaseException e) {

        }

        @Override
        public void onCodeAutoRetrievalTimeOut(String s) {
            super.onCodeAutoRetrievalTimeOut(s);
        }
    };
/*
    private void sendVerificationCode() {

        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(mAuth)
                        .setPhoneNumber("+880"+"1761632579")       // Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(this)                 // Activity (for callback binding)
                        .setCallbacks(mCallbacks)          // OnVerificationStateChangedCallbacks
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
    }


    //the callback to detect the verification status
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {

            String code = phoneAuthCredential.getSmsCode();

            if (code != null) {
                et_varification.setText(code);

                progressBar.setVisibility(View.VISIBLE);

                verifyVerificationCode(et_varification.getText().toString());

            }



        }

        @Override
        public void onVerificationFailed(FirebaseException e) {
            progressBar.setVisibility(View.GONE);
            Toast.makeText(VerifyOTPActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
        }

        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);

            //storing the verification id that is sent to the user
            mVerificationId = s;
        }
    };




    private void verifyVerificationCode(String otp) {
        //creating the credential
        progressBar.setVisibility(View.VISIBLE);
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(mVerificationId, otp);

        signInWithPhoneAuthCredential(credential);
    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(VerifyOTPActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {


                            Toast.makeText(VerifyOTPActivity.this, "Login done", Toast.LENGTH_SHORT).show();


                        } else {


                            progressBar.setVisibility(View.GONE);
                            View parentLayout = findViewById(android.R.id.content);
                            Snackbar mSnackBar = Snackbar.make(parentLayout, "Invalid code !!", Snackbar.LENGTH_LONG);
                            View view = mSnackBar.getView();
                            FrameLayout.LayoutParams params =(FrameLayout.LayoutParams)view.getLayoutParams();
                            params.gravity = Gravity.TOP;
                            view.setLayoutParams(params);
                            view.setBackgroundColor(Color.RED);
                            TextView mainTextView = (TextView) (view).findViewById(R.id.snackbar_text);
                            mainTextView.setTextColor(Color.WHITE);
                            mSnackBar.show();

                        }
                    }
                });
    }


    public void nextpage(View view) {
        Intent intent = new Intent(VerifyOTPActivity.this,CategoryActivity.class);
        startActivity(intent);
    }*/
}