package com.terminalbd.www.network;



import android.widget.ListView;

import com.terminalbd.www.model.ModelAddProduct;
import com.terminalbd.www.model.ResponseModel;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;


public interface ApiInterface {

    @Multipart
    @POST("upload_product.php")
    Call<ResponseModel> fileUpload(
            @Part("sender_information") RequestBody description,
            @Part MultipartBody.Part file);


    @GET("bengal_get_shop_type.php")
    Call<List<ModelAddProduct>> getShopType();


}
