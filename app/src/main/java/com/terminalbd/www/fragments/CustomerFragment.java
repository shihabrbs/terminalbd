package com.terminalbd.www.fragments;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.terminalbd.www.activity.DashboardActivity;
import com.terminalbd.www.R;
import com.terminalbd.www.adapter.CustomerAdapter;
import com.terminalbd.www.model.AnonymousCustomer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmResults;

/**
 * A simple {@link Fragment} subclass.
 */
public class CustomerFragment extends Fragment {

    Realm realm;

    RealmResults<AnonymousCustomer> anonymousCustomers;

    List<AnonymousCustomer> anonymousCustomerList;

    @BindView(R.id.customer_rv)
    RecyclerView customer_rv;

    CustomerAdapter adapter;


    public CustomerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_customer, container, false);
        ButterKnife.bind(this,view);

        realm = Realm.getDefaultInstance();

        ((DashboardActivity)getActivity()).setTitle("Customer List");

        anonymousCustomerList = new ArrayList<>();

        anonymousCustomers = realm.where(AnonymousCustomer.class).findAll();

        anonymousCustomerList.addAll(realm.copyFromRealm(anonymousCustomers));

        adapter = new CustomerAdapter(getContext(),anonymousCustomerList);
        customer_rv.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        customer_rv.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
        customer_rv.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        return view;
    }

}
