package com.terminalbd.www.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.terminalbd.www.R;
import com.terminalbd.www.model.Category;
import com.terminalbd.www.model.EventModel;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import static com.terminalbd.www.activity.ProductActivity.verifyStoragePermissions;

public class CategoryActivity extends AppCompatActivity {

    boolean isOnlyImageAllowed = true;

    private String filePath;
    private static final int PICK_PHOTO = 1958;
    private static final int REQUEST_EXTERNAL_STORAGE = 1;

    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(EventModel event) throws ClassNotFoundException {
        if (event.isTagMatchWith("response")) {
            String responseMessage = "Data insert " + event.getMessage();
            // responseTextView.setText(responseMessage);
            Toast.makeText(this, responseMessage, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        verifyStoragePermissions(this);

    }

    public void btn_productpage(View view) {
        Intent intent = new Intent(CategoryActivity.this,ProductActivity.class);
        startActivity(intent);
    }

    /* Add Category dialog */
    private void showTermsDialog() {
        LayoutInflater layoutInflater = LayoutInflater.from(CategoryActivity.this);
        View view = layoutInflater.inflate(R.layout.dialog_category, null);
        final AlertDialog.Builder builder = new AlertDialog.Builder(CategoryActivity.this);

        builder.setView(view);

        final AlertDialog alertDialog = builder.create();
        alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        ImageView picimg = view.findViewById(R.id.imageView4);
        ImageView sampleimg = view.findViewById(R.id.imageView8);

        picimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sampleimg.setVisibility(View.VISIBLE);
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

    public void btn_add_cagegory(View view) {
        showTermsDialog();
    }
}