package com.terminalbd.www.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.core.content.res.ResourcesCompat;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.terminalbd.www.R;
import com.terminalbd.www.adapter.CategoryAdapter;
import com.terminalbd.www.adapter.ProductGridAdapter;
import com.terminalbd.www.adapter.ProductListAdapter;
import com.terminalbd.www.adapter.SalesItemAdapter;
import com.terminalbd.www.adapter.SuggestionAdapter;
import com.terminalbd.www.adapter.TokenAdapter;
import com.terminalbd.www.helpers.PreferenceManager;
import com.terminalbd.www.interfaces.ItemClickListener;
import com.terminalbd.www.model.Category;
import com.terminalbd.www.model.SaleItem;
import com.terminalbd.www.model.StockItem;
import com.terminalbd.www.model.TokenNo;
import com.terminalbd.www.utils.ClearableAutoCompleteTextView;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

public class SalesActivity extends AppCompatActivity implements ItemClickListener {

    @BindView(R.id.med_search)
    ClearableAutoCompleteTextView search;

    @BindView(R.id.sales_mrp)
    EditText sales_mrp;

    @BindView(R.id.sales_quantity)
    EditText sales_quantity;

    @BindView(R.id.sales_history_rv)
    RecyclerView saleItemRv;

    @BindView(R.id.bs_sales_history_rv)
    RecyclerView bs_sales_history_rv;

    @BindView(R.id.category_rv)
    RecyclerView category_rv;

    @BindView(R.id.product_rv)
    RecyclerView product_rv;

    @BindView(R.id.token_no_rv)
    RecyclerView token_no_rv;

    @BindView(R.id.total_item_count)
    TextView total_item_count;

    @BindView(R.id.grand_total_text)
    TextView grand_total_text;

    @BindView(R.id.sale_layout)
    RelativeLayout sale_layout;


    @BindView(R.id.search_layout)
    LinearLayout search_layout;

    @BindView(R.id.list_grid_layout)
    LinearLayout list_grid_layout;

    @BindView(R.id.title_layout)
    LinearLayout title_layout;

    @BindView(R.id.category_all)
    TextView category_all;

    @BindView(R.id.barcode_scan)
    Button barcode_scan;

    @BindView(R.id.barcode_scan_list_grid)
    Button barcode_scan_list_grid;

    List<StockItem> stockItemList;
    Realm realm;

    RealmResults<SaleItem> salesItemList;

    SalesItemAdapter adapter;

    ProductListAdapter productListAdapter;

    ProductGridAdapter productGridAdapter;


    StockItem stockItem;


    int total;
    int total_item = 0;

//
//    RealmChangeListener<RealmResults<SaleItem>> realmListener = new RealmChangeListener<RealmResults<SaleItem>>() {
//        @Override
//        public void onChange(RealmResults<SaleItem> saleItems) {
//
//
//        }
//    };

    /*
    toolbar
     */
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.toolbar_title)
    TextView toolbar_title;

    RealmResults<Category> categoryRealmResults;
    private List<Category> categoryList;

    private CategoryAdapter categoryAdapter;

    RealmResults<TokenNo> tokenNos;
    private List<TokenNo> tokenNoList;

    private TokenAdapter tokenAdapter;

    String sales_mode;

    BottomSheetBehavior bottomSheetBehavior;

    @BindView(R.id.list_show_btn)
    FloatingActionButton list_show_btn;

    @BindView(R.id.bottom_sheet)
    LinearLayout bottom_sheet;

    @BindView(R.id.list_grid_search)
    EditText list_grid_search;

    @BindView(R.id.tokenLayout)
    LinearLayout tokenLayout;

    int page = 1;
    int limit = 50;
    int cur_limit = 50;
    private boolean isLoading = false;
    private int currentItems, totalItems, scrollOutitems = 0;

    private LinearLayoutManager linearLayoutManager;
    private GridLayoutManager gridLayoutManager;


    private RealmResults<StockItem> stockItemRealmResults;
    private List<StockItem> searchStockItemList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales);

        ButterKnife.bind(this);


        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(ResourcesCompat.getDrawable(getResources(), R.drawable.ic_arrow_back, null));

        toolbar_title.setText("Add Sales");

        realm = Realm.getDefaultInstance();

        /* check barcode scanner mode */
        if (PreferenceManager.getBarcodeMode(SalesActivity.this).equalsIgnoreCase("On"))
        {
            barcode_scan.setVisibility(View.VISIBLE);
            barcode_scan_list_grid.setVisibility(View.VISIBLE);
        }else if (PreferenceManager.getBarcodeMode(SalesActivity.this).equalsIgnoreCase("Off"))
        {
            barcode_scan.setVisibility(View.GONE);
            barcode_scan_list_grid.setVisibility(View.GONE);
        }

        searchStockItemList = new ArrayList<>();
        searchStockItemList.clear();
        stockItemRealmResults = realm.where(StockItem.class).findAll();
        searchStockItemList.addAll(realm.copyFromRealm(stockItemRealmResults));


        /*
        bottom sheet
         */
        bottomSheetBehavior = BottomSheetBehavior.from(bottom_sheet);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);


        stockItemList = new ArrayList<>();
        salesItemList = realm.where(SaleItem.class).findAll();

        salesItemList.addChangeListener(new RealmChangeListener<RealmResults<SaleItem>>() {
            @Override
            public void onChange(RealmResults<SaleItem> saleItems) {
                checkSaleLayoutVisibility();
                adapter.notifyDataSetChanged();
            }
        });


        stockItem = new StockItem();


        /*
        category setup
         */
        categoryList = new ArrayList<>();
        categoryRealmResults = realm.where(Category.class).findAll();

        categoryList.addAll(realm.copyFromRealm(categoryRealmResults));


        /*
        token no data getting
         */
        tokenNoList = new ArrayList<>();
        tokenNos = realm.where(TokenNo.class).findAll();
        tokenNoList.addAll(realm.copyFromRealm(tokenNos));


        //search click
        search.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View arg1, int position, long arg3) {
                Object item = parent.getItemAtPosition(position);
                if (item instanceof StockItem) {
                    stockItem = (StockItem) item;
                    sales_mrp.setText(String.valueOf(stockItem.getSalesPrice()));
                    sales_quantity.requestFocus();
                }
            }
        });


        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                search.showClearButton();
            }
        });

        search.setOnClearListener(new ClearableAutoCompleteTextView.OnClearListener() {
            @Override
            public void onClear() {

                search.setText("");
                sales_mrp.setText("");
                sales_quantity.setText("");

            }
        });



        /*
        sales item adapter
         */
        adapter = new SalesItemAdapter(SalesActivity.this, salesItemList);
        saleItemRv.setLayoutManager(new LinearLayoutManager(SalesActivity.this, LinearLayoutManager.VERTICAL, false));
        saleItemRv.addItemDecoration(new DividerItemDecoration(SalesActivity.this, DividerItemDecoration.VERTICAL));
        saleItemRv.setAdapter(adapter);


        if (PreferenceManager.getModule(SalesActivity.this).equalsIgnoreCase("restaurant")) {
             /*
        token no adapter
         */

            tokenAdapter = new TokenAdapter(SalesActivity.this, tokenNoList);
            token_no_rv.setLayoutManager(new LinearLayoutManager(SalesActivity.this, LinearLayoutManager.HORIZONTAL, false));
            token_no_rv.addItemDecoration(new DividerItemDecoration(SalesActivity.this, DividerItemDecoration.HORIZONTAL));
            token_no_rv.setAdapter(tokenAdapter);

            tokenLayout.setVisibility(View.VISIBLE);
        } else {
            tokenLayout.setVisibility(View.GONE);
        }

        /*
        getting sales mode
         */
        sales_mode = PreferenceManager.getSalesMode(SalesActivity.this);


        /*
        check sales layout
         */
        if (sales_mode.equalsIgnoreCase("Search")) {
            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    stockItemList.clear();
                    RealmResults<StockItem> oldStockItem = realm.where(StockItem.class).findAll();
                    stockItemList.addAll(realm.copyFromRealm(oldStockItem));

                }
            });

            /**
             * setup serach function here
             */
            search.setAdapter(new SuggestionAdapter(this, stockItemList));


            list_grid_layout.setVisibility(View.GONE);
            search_layout.setVisibility(View.VISIBLE);
            list_show_btn.hide();

        } else if (sales_mode.equalsIgnoreCase("List")) {

            loadData(0, 50);

         /*
        sales item adapter
         */
            adapter = new SalesItemAdapter(SalesActivity.this, salesItemList);
            bs_sales_history_rv.setLayoutManager(new LinearLayoutManager(SalesActivity.this, LinearLayoutManager.VERTICAL, false));
            bs_sales_history_rv.addItemDecoration(new DividerItemDecoration(SalesActivity.this, DividerItemDecoration.VERTICAL));
            bs_sales_history_rv.setAdapter(adapter);


            /*
        category adapter
         */
            categoryAdapter = new CategoryAdapter(SalesActivity.this, categoryList);
            category_rv.setLayoutManager(new LinearLayoutManager(SalesActivity.this, LinearLayoutManager.HORIZONTAL, false));
            category_rv.addItemDecoration(new DividerItemDecoration(SalesActivity.this, DividerItemDecoration.HORIZONTAL));
            category_rv.setAdapter(categoryAdapter);

            categoryAdapter.SetItemClickListener(this);




         /*
        list stock item adapter
         */
            linearLayoutManager = new LinearLayoutManager(SalesActivity.this, LinearLayoutManager.VERTICAL, false);
            productListAdapter = new ProductListAdapter(SalesActivity.this, stockItemList);
            product_rv.setLayoutManager(linearLayoutManager);
            product_rv.addItemDecoration(new DividerItemDecoration(SalesActivity.this, DividerItemDecoration.VERTICAL));
            product_rv.setAdapter(productListAdapter);

//        productListAdapter.setFilter(stockItemList);

            search_layout.setVisibility(View.GONE);
            title_layout.setVisibility(View.VISIBLE);
            list_grid_layout.setVisibility(View.VISIBLE);


            category_all.setBackground(getResources().getDrawable(R.drawable.selected_category_background));
            category_all.setTextColor(Color.WHITE);

        } else if (sales_mode.equalsIgnoreCase("Grid")) {
            loadData(0, 50);

                        /*
        sales item adapter
         */
            adapter = new SalesItemAdapter(SalesActivity.this, salesItemList);
            bs_sales_history_rv.setLayoutManager(new LinearLayoutManager(SalesActivity.this, LinearLayoutManager.VERTICAL, false));
            bs_sales_history_rv.addItemDecoration(new DividerItemDecoration(SalesActivity.this, DividerItemDecoration.VERTICAL));
            bs_sales_history_rv.setAdapter(adapter);


            /*
        category adapter
         */
            categoryAdapter = new CategoryAdapter(SalesActivity.this, categoryList);
            category_rv.setLayoutManager(new LinearLayoutManager(SalesActivity.this, LinearLayoutManager.HORIZONTAL, false));
            category_rv.addItemDecoration(new DividerItemDecoration(SalesActivity.this, DividerItemDecoration.HORIZONTAL));
            category_rv.setAdapter(categoryAdapter);

            categoryAdapter.SetItemClickListener(this);

             /*
        Grid stock item adapter
         */
            gridLayoutManager = new GridLayoutManager(SalesActivity.this, 3);
            productGridAdapter = new ProductGridAdapter(SalesActivity.this, stockItemList);
            product_rv.setLayoutManager(gridLayoutManager);
            product_rv.addItemDecoration(new DividerItemDecoration(SalesActivity.this, DividerItemDecoration.VERTICAL));
            product_rv.addItemDecoration(new DividerItemDecoration(SalesActivity.this, DividerItemDecoration.HORIZONTAL));
            product_rv.setAdapter(productGridAdapter);

//            productGridAdapter.setFilter(stockItemList);


            search_layout.setVisibility(View.GONE);
            title_layout.setVisibility(View.GONE);
            list_grid_layout.setVisibility(View.VISIBLE);


            category_all.setBackground(getResources().getDrawable(R.drawable.selected_category_background));
            category_all.setTextColor(Color.WHITE);

        }

        checkSaleLayoutVisibility();

        list_grid_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (charSequence.length() > 0) {

                    if (sales_mode.equalsIgnoreCase("List")) {
                        final List<StockItem> filteredModelList = filter(searchStockItemList, charSequence.toString());
                        productListAdapter.setFilter(filteredModelList);


                    } else if (sales_mode.equalsIgnoreCase("Grid")) {
                        final List<StockItem> filteredModelList = filter(searchStockItemList, charSequence.toString());
                        productGridAdapter.setFilter(filteredModelList);

                    }
                } else {
                    if (sales_mode.equalsIgnoreCase("List")) {
                        productListAdapter.setFilter(stockItemList);

                    } else if (sales_mode.equalsIgnoreCase("Grid")) {
                        productGridAdapter.setFilter(stockItemList);
                    }
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        product_rv.setOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                    isLoading = true;
                }
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if (sales_mode.equalsIgnoreCase("List")) {
                    currentItems = linearLayoutManager.getChildCount();
                    totalItems = linearLayoutManager.getItemCount();
                    scrollOutitems = linearLayoutManager.findFirstVisibleItemPosition();

                } else {
                    currentItems = gridLayoutManager.getChildCount();
                    totalItems = gridLayoutManager.getItemCount();
                    scrollOutitems = gridLayoutManager.findFirstVisibleItemPosition();
                }


                if (isLoading && (currentItems + scrollOutitems == totalItems)) {

//                    loadMoreProgressbar.setVisibility(View.VISIBLE);
                    page = page + limit;
                    cur_limit = cur_limit + limit;

                    loadData(page, cur_limit);

                    isLoading = false;

                    if (sales_mode.equalsIgnoreCase("List")) {
                        productListAdapter.notifyDataSetChanged();
                    } else {
                        productGridAdapter.notifyDataSetChanged();
                    }

                }
            }
        });


    }


    public void checkSaleLayoutVisibility() {
        if (salesItemList.size() > 0) {
            if (sales_mode.equalsIgnoreCase("List")
                    || sales_mode.equalsIgnoreCase("Grid")) {
//                list_show_btn.setVisibility(View.VISIBLE);
            }
            sale_layout.setVisibility(View.VISIBLE);

            calculatePrice();
        } else {
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
//            list_show_btn.setVisibility(View.GONE);
            sale_layout.setVisibility(View.GONE);
        }
    }

    @OnClick(R.id.list_show_btn)
    void onShowBtn() {
        if (bottomSheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {

            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);

        } else {

            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
        }
    }

    @OnClick(R.id.sale_layout)
    void sale_layout() {
        if (PreferenceManager.getModule(SalesActivity.this).equalsIgnoreCase("restaurant")) {
            Intent intent = new Intent(SalesActivity.this, SalePaymentActivity.class);
            intent.putExtra("TOKEN", new Gson().toJson(tokenAdapter.getSelectedToken()));
            startActivity(intent);
            this.finish();

        } else {
            startActivityForResult(new Intent(this, SalePaymentActivity.class), 101);
        }
    }

    @OnClick(R.id.add_btn)
    void add_btn() {
        if (TextUtils.isEmpty(search.getText().toString())) {
            search.setError("Please add a product");
            search.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(sales_mrp.getText().toString())) {
            sales_mrp.setError("Mrp cannot empty");
            sales_mrp.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(sales_quantity.getText().toString())) {
            sales_quantity.setError("Please enter quantity");
            sales_quantity.requestFocus();
            return;
        }


        realm.beginTransaction();
        SaleItem saleItem = realm.createObject(SaleItem.class, UUID.randomUUID().toString());
        saleItem.setSaleStockId(String.valueOf(stockItem.getItemId()));
        saleItem.setSaleItemName(search.getText().toString().trim());
        saleItem.setSalePpPrice(String.valueOf(stockItem.getPurchasePrice()));
        saleItem.setSaleMrpPrice(sales_mrp.getText().toString());
        saleItem.setSaleQuantity(sales_quantity.getText().toString());
        int sub_total = (int) Math.round(Double.valueOf(sales_mrp.getText().toString()) * Double.valueOf(sales_quantity.getText().toString()));
        saleItem.setSaleSubTotal(String.valueOf(sub_total));
        realm.commitTransaction();

        sale_layout.setVisibility(View.VISIBLE);

        calculatePrice();


        search.setText("");
        sales_mrp.setText("");
        sales_quantity.setText("");

        search.requestFocus();

        adapter.notifyDataSetChanged();
    }


    @OnClick(R.id.category_all)
    void onAllCategory() {

        loadData(0, 50);

        if (sales_mode.equalsIgnoreCase("List")) {
            productListAdapter.setFilter(stockItemList);
            productListAdapter.notifyDataSetChanged();

        } else if (sales_mode.equalsIgnoreCase("Grid")) {
            productGridAdapter.setFilter(stockItemList);
            productGridAdapter.notifyDataSetChanged();

        }

        category_all.setBackground(getResources().getDrawable(R.drawable.selected_category_background));
        category_all.setTextColor(Color.WHITE);
        categoryAdapter.SetPosition(-1);
        categoryAdapter.notifyDataSetChanged();
    }

    public void calculatePrice() {
        total = 0;

        for (SaleItem item : salesItemList) {
            total += Math.round(Double.valueOf(item.getSaleMrpPrice()) * Double.valueOf(item.getSaleQuantity()));

        }

        total_item = salesItemList.size();

        grand_total_text.setText("৳" + total);
        total_item_count.setText(String.valueOf(total_item));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }

    @Override
    public void onClick(View view, final int position) {

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                stockItemList.clear();
                RealmResults<StockItem> oldStockItem = realm.
                        where(StockItem.class)
                        .beginGroup()
                        .equalTo("categoryId", categoryList.get(position).getCategoryId())
                        .endGroup()
                        .findAll();
                stockItemList.addAll(realm.copyFromRealm(oldStockItem));

            }
        });

        if (sales_mode.equalsIgnoreCase("List")) {
            productListAdapter.setFilter(stockItemList);
            productListAdapter.notifyDataSetChanged();

        } else if (sales_mode.equalsIgnoreCase("Grid")) {
            productGridAdapter.setFilter(stockItemList);
            productGridAdapter.notifyDataSetChanged();

        }


        category_all.setBackground(getResources().getDrawable(R.drawable.edit_text_round_corner_border));
        category_all.setTextColor(Color.BLACK);
        categoryAdapter.SetPosition(position);
        categoryAdapter.notifyDataSetChanged();

    }

    private List<StockItem> filter(List<StockItem> stocks, String query) {
        query = query.toLowerCase();
        final List<StockItem> filteredModelList = new ArrayList<>();
        for (StockItem stock : stocks) {
            final String text = stock.getName().toLowerCase() + " " + stock.getCategoryName().toLowerCase();
            if (text.contains(query)) {
                filteredModelList.add(stock);
            }
        }
        return filteredModelList;
    }


    private void loadData(int start, int limit) {
        RealmResults<StockItem> oldStockItem = realm.where(StockItem.class).between("count", start, limit).findAll();
        stockItemList.addAll(realm.copyFromRealm(oldStockItem));

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case 101:
                if (resultCode == RESULT_CANCELED) {
                    Intent intent = getIntent();
                    startActivity(intent);
                    finish();
                }
                break;

            case 102:
                if (resultCode == RESULT_OK) {
                    String code = data.getStringExtra("code");
                    StockItem item = realm.where(StockItem.class).equalTo("unitId", code).findFirst();

                    if (item != null) {
                        realm.beginTransaction();
                        SaleItem saleItem = realm.createObject(SaleItem.class, UUID.randomUUID().toString());
                        saleItem.setSaleStockId(String.valueOf(item.getItemId()));
                        saleItem.setSaleItemName(item.getName());
                        saleItem.setSalePpPrice(String.valueOf(item.getPurchasePrice()));
                        saleItem.setSaleMrpPrice(String.valueOf(item.getSalesPrice()));
                        saleItem.setSaleQuantity(String.valueOf(1));
                        int sub_total = (int) Math.round(item.getSalesPrice() * Double.valueOf(1));
                        saleItem.setSaleSubTotal(String.valueOf(sub_total));
                        realm.commitTransaction();

                        sale_layout.setVisibility(View.VISIBLE);

                        calculatePrice();

                        if (sales_mode.equalsIgnoreCase("Search")) {
                            adapter.notifyDataSetChanged();
                        } else if (sales_mode.equalsIgnoreCase("List")) {
                            productListAdapter.notifyDataSetChanged();
                        } else if (sales_mode.equalsIgnoreCase("Grid")) {
                            productGridAdapter.notifyDataSetChanged();
                        }
                    }else
                    {
                        Toast.makeText(this, "Product not found !", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
        }

    }

    @OnClick(R.id.barcode_scan)
    public void onBarcodeScan() {

        startActivityForResult(new Intent(SalesActivity.this, BarcodeScannerActivity.class), 102);
    }

    @OnClick(R.id.barcode_scan_list_grid)
    public void onBarcodeScanList() {

        startActivityForResult(new Intent(SalesActivity.this, BarcodeScannerActivity.class), 102);
    }
}
