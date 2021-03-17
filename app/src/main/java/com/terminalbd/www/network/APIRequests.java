package com.terminalbd.www.network;


import com.terminalbd.www.model.AnonymousCustomer;
import com.terminalbd.www.model.BankAccount;
import com.terminalbd.www.model.Category;
import com.terminalbd.www.model.DIMSItem;
import com.terminalbd.www.model.ExpenseCategory;
import com.terminalbd.www.model.ExpenseItem;
import com.terminalbd.www.model.MobileAccount;
import com.terminalbd.www.model.PurchaseHistory;
import com.terminalbd.www.model.PurchaseItemHistory;
import com.terminalbd.www.model.SyncRequestBody.SalesItemRequestBody;
import com.terminalbd.www.model.SyncRequestBody.SalesRequestBody;
import com.terminalbd.www.model.Setup;
import com.terminalbd.www.model.StockItem;
import com.terminalbd.www.model.SystemUser;
import com.terminalbd.www.model.TokenNo;
import com.terminalbd.www.model.TransactionMethod;
import com.terminalbd.www.model.Vendor;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * APIRequests contains all the Network Request Methods with relevant API Endpoints
 **/

public interface APIRequests {

    @GET("stock-category")
    Observable<Response<List<Category>>> getCategory(@Header("X-API-SECRET") String secret);

    @GET("token-no")
    Observable<Response<List<TokenNo>>> getTokenNo(@Header("X-API-SECRET") String secret);

    @GET("stock-item")
    Observable<Response<List<StockItem>>> getStockItem(@Header("X-API-SECRET") String secret);

    @FormUrlEncoded
    @POST("setup")
    Single<Response<Setup>> setup(@Field("mobile") String mobile,
                                  @Field("uniqueCode") String uniqueCode,
                                  @Field("deviceId") String deviceId);


    @GET("system-user")
    Observable<Response<List<SystemUser>>> getSystemUser(@Header("X-API-SECRET") String secret);

    @GET("tarnsaction-method")
    Observable<Response<List<TransactionMethod>>> getTransactionMethod(@Header("X-API-SECRET") String secret);


    @GET("anonymiuse-customer")
    Observable<Response<List<AnonymousCustomer>>> getAnonymousCustomer(@Header("X-API-SECRET") String secret);



    @GET("online-bank-acccount")
    Observable<Response<List<BankAccount>>> getOnlineBankAccount(@Header("X-API-SECRET") String secret);

    @GET("mobile-account")
    Observable<Response<List<MobileAccount>>> getMobileAccount(@Header("X-API-SECRET") String secret);

    @GET("vendor")
    Observable<Response<List<Vendor>>> getVendor(@Header("X-API-SECRET") String secret);

    @GET("expense-category")
    Observable<Response<List<ExpenseCategory>>> getExpenseCategory(@Header("X-API-SECRET") String secret);

    @GET("medicine-dims")
    Observable<Response<List<DIMSItem>>> getDIMS(@Header("X-API-SECRET") String secret);

    @GET("payment-card")
    Observable<Response<List<PaymentCards>>> getPaymentCards(@Header("X-API-SECRET") String secret);

//    @POST("sales")
//    Observable<Response<ResponseBody>> syncSales(
//            @Header("X-DEVICE-ID") String deviceID,
//            @Header("X-API-SECRET") String secret,
//            @Body SalesRequestBody salesRequestBody);

    @FormUrlEncoded
    @POST("sales")
    Observable<Response<ResponseBody>> syncSales(
            @Header("X-DEVICE-ID") String deviceID,
            @Header("X-API-SECRET") String secret,
            @Field("item") String salesItem,
            @Field("itemCount") int itemCount,
            @Field("subItem") String subItems,
            @Field("subItemCount") int subItemCount);


    @POST("sales-item")
    Observable<Response<ResponseBody>> syncSalesItems(
            @Header("X-DEVICE-ID") String deviceID,
            @Header("X-API-SECRET") String secret,
            @Body SalesItemRequestBody salesItemRequestBody);

//    @POST("purchase")
//    Observable<Response<ResponseBody>> syncPurchase(
//            @Header("X-DEVICE-ID") String deviceID,
//            @Header("X-API-SECRET") String secret,
//            @Body PurchaseHistory purchaseHistory);

    @FormUrlEncoded
    @POST("purchase")
    Observable<Response<ResponseBody>> syncPurchase(
            @Header("X-DEVICE-ID") String deviceID,
            @Header("X-API-SECRET") String secret,
            @Field("item") String purchaseItem,
            @Field("itemCount") int itemCount,
            @Field("subItem") String subItems,
            @Field("subItemCount") int subItemCount);

//    @POST("purchase-item")
//    Observable<Response<ResponseBody>> syncPurchaseItem(
//            @Header("X-DEVICE-ID") String deviceID,
//            @Header("X-API-SECRET") String secret,
//            @Body PurchaseItemHistory purchaseItemHistory);

//    @POST("expense")
//    Observable<Response<ResponseBody>> syncExpense(
//            @Header("X-DEVICE-ID") String deviceID,
//            @Header("X-API-SECRET") String secret,
//            @Body ExpenseItem expenseItem);


    @FormUrlEncoded
    @POST("expense")
    Observable<Response<ResponseBody>> syncExpense(
            @Header("X-DEVICE-ID") String deviceID,
            @Header("X-API-SECRET") String secret,
            @Field("item") String expenseItem,
            @Field("itemCount") int itemCount);




}

