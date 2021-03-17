package com.terminalbd.www.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.terminalbd.www.R;

public class MultipleUserActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_user);

    }

    public void btn_add_multiuser(View view) {
        showMultiUserDialog();
    }


    /* Add Multi User dialog */
    private void showMultiUserDialog() {
        LayoutInflater layoutInflater = LayoutInflater.from(MultipleUserActivity.this);
        View view = layoutInflater.inflate(R.layout.dialog_multiple_user, null);
        final AlertDialog.Builder builder = new AlertDialog.Builder(MultipleUserActivity.this);

        builder.setView(view);

        final AlertDialog alertDialog = builder.create();
        alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));



        TextView createbtn = view.findViewById(R.id.textView3);

        createbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MultipleUserActivity.this, "multi user create", Toast.LENGTH_SHORT).show();
            }
        });

      /*  TextView close = view.findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });*/

        alertDialog.show();

    }

    public void btn_back(View view) {
        onBackPressed();
    }

    public void btn_add_cagegory(View view) {
        Intent intent = new Intent(MultipleUserActivity.this,CategoryActivity.class);
        startActivity(intent);
    }
}