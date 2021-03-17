package com.terminalbd.www.fragments;


import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.terminalbd.www.activity.DashboardActivity;
import com.terminalbd.www.activity.DimsActivity;
import com.terminalbd.www.activity.ExpenseActivity;
import com.terminalbd.www.activity.PurchaseActivity;
import com.terminalbd.www.R;
import com.terminalbd.www.activity.SalesActivity;
import com.terminalbd.www.activity.StockActivity;
import com.terminalbd.www.helpers.PreferenceManager;
import com.terminalbd.www.model.ExpenseItem;
import com.terminalbd.www.model.PurchaseHistory;
import com.terminalbd.www.model.SalesHistory;
import com.terminalbd.www.model.Setup;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    @BindView(R.id.dash_balance)
    TextView dash_balance;

    @BindView(R.id.dash_sale_amount)
    TextView dash_sale_amount;

    @BindView(R.id.dash_purchase_amount)
    TextView dash_purchase_amount;

    @BindView(R.id.dash_expense_amount)
    TextView dash_expense_amount;

    @BindView(R.id.dash_sales)
    RelativeLayout dash_sales;

    @BindView(R.id.dash_purchase)
    RelativeLayout dash_purchase;

    @BindView(R.id.dash_expense)
    RelativeLayout dash_expense;

    @BindView(R.id.dash_stock)
    RelativeLayout dash_stock;

    @BindView(R.id.dash_dims)
    RelativeLayout dash_dims;

//    @BindView(R.id.view_first)
//    View view_first;
//
//    @BindView(R.id.view_second)
//    View view_second;

    Realm realm;
    int totalBalance;
    int totalExpense;
    int totalPurchase;
    int totalSales;

    RealmResults<SalesHistory> salesHistories;
    RealmResults<PurchaseHistory> purchaseHistories;
    RealmResults<ExpenseItem> expenseItems;

    public HomeFragment() {
        // Required empty public constructor
    }

    RealmChangeListener<RealmResults<SalesHistory>> realmSaleListener = new RealmChangeListener<RealmResults<SalesHistory>>() {
        @Override
        public void onChange(RealmResults<SalesHistory> salesHistories) {

            getTotalSaleAmount();
            getTotalBalance();
        }
    };

    RealmChangeListener<RealmResults<PurchaseHistory>> realmPurchaseListener = new RealmChangeListener<RealmResults<PurchaseHistory>>() {
        @Override
        public void onChange(RealmResults<PurchaseHistory> purchaseHistories) {

            getTotalPurchaseAmount();
            getTotalBalance();

        }
    };

    RealmChangeListener<RealmResults<ExpenseItem>> realmExpenseListener = new RealmChangeListener<RealmResults<ExpenseItem>>() {
        @Override
        public void onChange(RealmResults<ExpenseItem> expenseItems) {

            getTotalExpenseAmount();
            getTotalBalance();
        }
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this,view);

        realm = Realm.getDefaultInstance();

        ((DashboardActivity)getActivity()).setTitle("Home");


        getTotalSaleAmount();
        getTotalPurchaseAmount();
        getTotalExpenseAmount();
        getTotalBalance();

        return view;
    }

    public void getTotalSaleAmount()
    {
        totalSales = 0;

        salesHistories = realm.where(SalesHistory.class).findAll();

        for (SalesHistory salesHistory:
                salesHistories ) {

            totalSales+=Math.round(Double.valueOf(salesHistory.getTotal()));
        }

        dash_sale_amount.setText(totalSales + " BDT");

        salesHistories.addChangeListener(realmSaleListener);
    }

    public void getTotalPurchaseAmount()
    {
        totalPurchase = 0;

        purchaseHistories = realm.where(PurchaseHistory.class).findAll();

        for (PurchaseHistory purchaseHistory:
             purchaseHistories) {

            totalPurchase+=Math.round(Double.valueOf(purchaseHistory.getTotal()));
        }

        dash_purchase_amount.setText(totalPurchase + " BDT");

        purchaseHistories.addChangeListener(realmPurchaseListener);


    }

    public void getTotalExpenseAmount()
    {
        totalExpense= 0;

        expenseItems = realm.where(ExpenseItem.class).findAll();

        for (ExpenseItem expenseItem:
             expenseItems) {
            totalExpense+=Math.round(Double.valueOf(expenseItem.getPayment()));
        }

        dash_expense_amount.setText(totalExpense + " BDT");

        expenseItems.addChangeListener(realmExpenseListener);

    }

    public void getTotalBalance()
    {
        totalBalance=0;

        totalBalance = totalSales-(totalPurchase+totalExpense);

        dash_balance.setText(totalBalance + " BDT");
    }

    @OnClick(R.id.dash_sales)
    void dash_sales()
    {
        startActivity(new Intent(getActivity(), SalesActivity.class));
    }

    @OnClick(R.id.dash_purchase)
    void dash_purchase()
    {
        startActivity(new Intent(getActivity(), PurchaseActivity.class));
    }

    @OnClick(R.id.dash_expense)
    void dash_expense()
    {
        startActivity(new Intent(getActivity(), ExpenseActivity.class));
    }

    @OnClick(R.id.dash_stock)
    void dash_stock()
    {
        startActivity(new Intent(getActivity(), StockActivity.class));
    }

    @OnClick(R.id.dash_dims)
    void dash_dims()
    {
        startActivity(new Intent(getActivity(), DimsActivity.class));
    }

    @Override
    public void onStart() {
        super.onStart();


        dash_sales.setVisibility(View.GONE);
        dash_purchase.setVisibility(View.GONE);
        dash_expense.setVisibility(View.GONE);
        dash_stock.setVisibility(View.GONE);
        dash_dims.setVisibility(View.GONE);


               /*
               Pharmacy Information
                */
        Setup setup = realm.where(Setup.class).findFirst();

        if (setup!=null) {

            if (setup.getMainAppName().equalsIgnoreCase("miss"))
            {
                dash_dims.setVisibility(View.VISIBLE);

            }else
            {
                dash_dims.setVisibility(View.GONE);
            }
        }


         /*
        check user roles
         */
        List<String> stringList = Arrays.asList(PreferenceManager.getRoles(getContext()).split(","));

        for (String s :
                stringList) {

            if (s.equalsIgnoreCase("ROLE_MANAGER")) {

               dash_sales.setVisibility(View.VISIBLE);
               dash_purchase.setVisibility(View.VISIBLE);
               dash_expense.setVisibility(View.VISIBLE);
               dash_stock.setVisibility(View.VISIBLE);
            }
            if (s.equalsIgnoreCase("ROLE_SALES"))
            {
                dash_sales.setVisibility(View.VISIBLE);

            }
            if (s.equalsIgnoreCase("ROLE_PURCHASE"))
            {
                dash_purchase.setVisibility(View.VISIBLE);


            }
            if (s.equalsIgnoreCase("ROLE_EXPENSE"))
            {

                dash_expense.setVisibility(View.VISIBLE);

            }
            if (s.equalsIgnoreCase("ROLE_STOCK"))
            {

                dash_stock.setVisibility(View.VISIBLE);
//                view_first.setVisibility(View.GONE);
//                view_second.setVisibility(View.GONE);
            }
        }
    }
}
