package com.terminalbd.www.activity;
import android.Manifest;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import com.google.android.material.navigation.NavigationView;
import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.terminalbd.www.R;
import com.terminalbd.www.fragments.CategoryFragment;
import com.terminalbd.www.fragments.CustomerFragment;
import com.terminalbd.www.fragments.ExpenseCatFragment;
import com.terminalbd.www.fragments.ExpenseHistoryFragment;
import com.terminalbd.www.fragments.HomeFragment;
import com.terminalbd.www.fragments.PaymentListFragment;
import com.terminalbd.www.fragments.PurchaseHistoryFragment;
import com.terminalbd.www.fragments.SalesHistoryFragment;
import com.terminalbd.www.fragments.SettingsFragment;
import com.terminalbd.www.fragments.UserFragment;
import com.terminalbd.www.fragments.VendorFragment;
import com.terminalbd.www.helpers.PreferenceManager;
import com.terminalbd.www.model.Setup;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.disposables.CompositeDisposable;
import io.realm.Realm;

public class DashboardActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawer;
    NavigationView navigationView;

    @BindView(R.id.toolbar_title)
    TextView toolbar_title;
    String title;

    Realm realm;

    ImageView iv;
    CompositeDisposable compositeDisposable;


    TextView nav_header_name;
    ImageView app_help;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        ButterKnife.bind(this);

        realm = Realm.getDefaultInstance();

        compositeDisposable = new CompositeDisposable();


        title = "Dashboard";
        toolbar_title.setText(title);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //request permission
        requestPermission();

        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        View view = navigationView.getHeaderView(0);
        nav_header_name = view.findViewById(R.id.nav_header_name);
        app_help = view.findViewById(R.id.app_help);
        nav_header_name.setText(PreferenceManager.getUserName(DashboardActivity.this));

        app_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.closeDrawer(GravityCompat.START);
                /*
               Pharmacy Information
                */
                Setup setup = realm.where(Setup.class).findFirst();

                if (setup!=null) {

                    showHelpDialog(setup.getAppsManual());
                }
            }
        });



        /*
        load home framgemt
         */
        HomeFragment homeFragment = new HomeFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_frame,homeFragment)
                .setCustomAnimations(R.anim.fade_in,R.anim.fade_out)
                .commitAllowingStateLoss();
    }

    public void setTitle(String title) {
        toolbar_title.setText(title);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {

             /*
        load home framgemt
         */
            HomeFragment homeFragment = new HomeFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_frame,homeFragment)
                    .setCustomAnimations(R.anim.fade_in,R.anim.fade_out)
                    .addToBackStack("null")
                    .commit();


        } else if (id == R.id.nav_sale) {

             /*
        load sales history framgemt
         */
            SalesHistoryFragment salesHistoryFragment = new SalesHistoryFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_frame,salesHistoryFragment)
                    .setCustomAnimations(R.anim.fade_in,R.anim.fade_out)
                    .addToBackStack("null")
                    .commitAllowingStateLoss();

        } else if (id == R.id.nav_purchase) {

              /*
        load purchase history framgemt
         */
            PurchaseHistoryFragment purchaseHistoryFragment = new PurchaseHistoryFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_frame,purchaseHistoryFragment)
                    .setCustomAnimations(R.anim.fade_in,R.anim.fade_out)
                    .addToBackStack("null")
                    .commitAllowingStateLoss();

        }else if (id == R.id.nav_expense) {

             /*
        load purchase history framgemt
         */
            ExpenseHistoryFragment expenseHistoryFragment = new ExpenseHistoryFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_frame,expenseHistoryFragment)
                    .setCustomAnimations(R.anim.fade_in,R.anim.fade_out)
                    .addToBackStack("null")
                    .commitAllowingStateLoss();


        }else if (id == R.id.nav_expense_cat) {

             /*
        load purchase history framgemt
         */
            ExpenseCatFragment expenseCatFragment = new ExpenseCatFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_frame,expenseCatFragment)
                    .setCustomAnimations(R.anim.fade_in,R.anim.fade_out)
                    .addToBackStack("null")
                    .commitAllowingStateLoss();


        }
        else if (id == R.id.nav_customer) {

            /*
            load customer framgemt
             */
            CustomerFragment customerFragment = new CustomerFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_frame,customerFragment)
                    .setCustomAnimations(R.anim.fade_in,R.anim.fade_out)
                    .addToBackStack("null")
                    .commit();

        }else if (id == R.id.nav_vendor) {

             /*
            load vendor framgemt
             */
            VendorFragment vendorFragment = new VendorFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_frame,vendorFragment)
                    .setCustomAnimations(R.anim.fade_in,R.anim.fade_out)
                    .addToBackStack("null")
                    .commit();

        }else if (id == R.id.nav_stock) {

            startActivity(new Intent(DashboardActivity.this,StockActivity.class));

        }else if (id == R.id.nav_category)
        {
              /*
            load user framgemt
             */
            CategoryFragment categoryFragment = new CategoryFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_frame,categoryFragment)
                    .setCustomAnimations(R.anim.fade_in,R.anim.fade_out)
                    .addToBackStack("null")
                    .commit();
        }
        else if (id == R.id.nav_user) {

              /*
            load user framgemt
             */
            UserFragment userFragment = new UserFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_frame,userFragment)
                    .setCustomAnimations(R.anim.fade_in,R.anim.fade_out)
                    .addToBackStack("null")
                    .commit();

        }else if (id == R.id.nav_mobile_bank_list) {

              /*
            load home framgemt
             */
            PaymentListFragment paymentListFragment = new PaymentListFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_frame,paymentListFragment)
                    .setCustomAnimations(R.anim.fade_in,R.anim.fade_out)
                    .addToBackStack("null")
                    .commit();

        }else if (id == R.id.nav_setting) {

             /*
            load settings framgemt
             */
            SettingsFragment settingsFragment = new SettingsFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_frame,settingsFragment)
                    .setCustomAnimations(R.anim.fade_in,R.anim.fade_out)
                    .addToBackStack("null")
                    .commit();

        }else if (id == R.id.nav_logout) {

            new AlertDialog.Builder(this).setMessage("Are you sure want to logout?")
                    .setTitle("Alert!!")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            PreferenceManager.setLogin(DashboardActivity.this,false);
                            startActivity(new Intent(DashboardActivity.this,LoginActivity.class));
                            finishAffinity();

                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    })
                    .show();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {

        /*
        check user roles
         */
        List<String> stringList = Arrays.asList(PreferenceManager.getRoles(DashboardActivity.this).split(","));

        for (String s :
                stringList) {

            if (s.equalsIgnoreCase("ROLE_MANAGER") || s.equalsIgnoreCase("ROLE_SALES")) {

                menu.clear();
                getMenuInflater().inflate(R.menu.sync_menu,menu);
                View view = menu.findItem(R.id.sync_status).getActionView();
                iv = view.findViewById(R.id.sync_progress);

                iv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(DashboardActivity.this,SalesActivity.class));
                    }
                });
            }
        }


        return true;
    }

    @Override
    protected void onDestroy() {
        realm.close();
        compositeDisposable.clear();
        super.onDestroy();
    }

    private void showHelpDialog(String text) {
        final Dialog dialog = new Dialog(DashboardActivity.this);
        dialog.setContentView(R.layout.dialog_help);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);

        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;

        TextView rules_text = dialog.findViewById(R.id.help_text);
        if (!TextUtils.isEmpty(text)) {
            rules_text.setText(Html.fromHtml(text));
        }

        dialog.findViewById(R.id.close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.findViewById(R.id.ok).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
        dialog.getWindow().setAttributes(lp);
    }

    @Override
    protected void onStart() {
        super.onStart();


        Menu nav_Menu = navigationView.getMenu();
        nav_Menu.findItem(R.id.nav_home).setVisible(false);
        nav_Menu.findItem(R.id.nav_sale).setVisible(false);
        nav_Menu.findItem(R.id.nav_purchase).setVisible(false);
        nav_Menu.findItem(R.id.nav_expense).setVisible(false);
        nav_Menu.findItem(R.id.nav_customer).setVisible(false);
        nav_Menu.findItem(R.id.nav_vendor).setVisible(false);
        nav_Menu.findItem(R.id.nav_stock).setVisible(false);
        nav_Menu.findItem(R.id.nav_user).setVisible(false);
        nav_Menu.findItem(R.id.nav_mobile_bank_list).setVisible(false);
        nav_Menu.findItem(R.id.nav_setting).setVisible(false);
        nav_Menu.findItem(R.id.nav_logout).setVisible(false);

        /*
        check user roles
         */
        List<String> stringList = Arrays.asList(PreferenceManager.getRoles(DashboardActivity.this).split(","));

        for (String s :
                stringList) {

            if (s.equalsIgnoreCase("ROLE_MANAGER")) {

                nav_Menu.findItem(R.id.nav_home).setVisible(true);
                nav_Menu.findItem(R.id.nav_sale).setVisible(true);
                nav_Menu.findItem(R.id.nav_purchase).setVisible(true);
                nav_Menu.findItem(R.id.nav_expense).setVisible(true);
                nav_Menu.findItem(R.id.nav_customer).setVisible(true);
                nav_Menu.findItem(R.id.nav_vendor).setVisible(true);
                nav_Menu.findItem(R.id.nav_stock).setVisible(true);
                nav_Menu.findItem(R.id.nav_user).setVisible(true);
                nav_Menu.findItem(R.id.nav_mobile_bank_list).setVisible(true);
                nav_Menu.findItem(R.id.nav_setting).setVisible(true);
                nav_Menu.findItem(R.id.nav_logout).setVisible(true);
            }
             if (s.equalsIgnoreCase("ROLE_SALES"))
            {
                nav_Menu.findItem(R.id.nav_home).setVisible(true);
                nav_Menu.findItem(R.id.nav_sale).setVisible(true);
                nav_Menu.findItem(R.id.nav_customer).setVisible(true);
                nav_Menu.findItem(R.id.nav_mobile_bank_list).setVisible(true);
                nav_Menu.findItem(R.id.nav_logout).setVisible(true);

            }
             if (s.equalsIgnoreCase("ROLE_PURCHASE"))
            {
                nav_Menu.findItem(R.id.nav_home).setVisible(true);
                nav_Menu.findItem(R.id.nav_purchase).setVisible(true);
                nav_Menu.findItem(R.id.nav_vendor).setVisible(true);
                nav_Menu.findItem(R.id.nav_logout).setVisible(true);


            }
             if (s.equalsIgnoreCase("ROLE_EXPENSE"))
            {
                nav_Menu.findItem(R.id.nav_home).setVisible(true);
                nav_Menu.findItem(R.id.nav_expense).setVisible(true);
                nav_Menu.findItem(R.id.nav_logout).setVisible(true);


            }
             if (s.equalsIgnoreCase("ROLE_STOCK"))
            {
                nav_Menu.findItem(R.id.nav_home).setVisible(true);
                nav_Menu.findItem(R.id.nav_stock).setVisible(true);
                nav_Menu.findItem(R.id.nav_logout).setVisible(true);

            }
        }
    }

//    AccessibilityNodeInfo source = event.getSource();
//if (source != null) {
//        //capture the EditText simply by using FOCUS_INPUT (since the EditText has the focus), you can probably find it with the viewId input_field
//        AccessibilityNodeInfo inputNode = source.findFocus(AccessibilityNodeInfo.FOCUS_INPUT);
//        if (inputNode != null) {//prepare you text then fill it using ACTION_SET_TEXT
//            Bundle arguments = new Bundle();
//            arguments.putCharSequence(AccessibilityNodeInfo.ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE,"text to enter");
//            inputNode.performAction(AccessibilityNodeInfo.ACTION_SET_TEXT, arguments);
//        }
//        //"Click" the Send button
//        List<AccessibilityNodeInfo> list = source.findAccessibilityNodeInfosByText("Send");
//        for (AccessibilityNodeInfo node : list) {
//            node.performAction(AccessibilityNodeInfo.ACTION_CLICK);
//        }
//    }

    void requestPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 0);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 0 && grantResults.length < 1) {
            requestPermission();
        }
    }
}
