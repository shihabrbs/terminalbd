package com.terminalbd.www.network;



import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * APIClient handles all the Network API Requests using Retrofit Library
 **/

public class APIClient {
    
    
    // Base URL for API Requests
//  private static final String BASE_URL = "http://www.terminalbd.com/android-api/";
  // private static final String BASE_URL = "http://www.erpplatinum.com/android-api/";
   private static final String BASE_URL = "http://www.bengalerp.com/android-api/";

    private static APIRequests apiRequests;


    // Singleton Instance of APIRequests
    public static APIRequests getInstance() {
        if (apiRequests == null) {

            OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                    .connectTimeout(60, TimeUnit.SECONDS)
                    .readTimeout(60, TimeUnit.SECONDS)
                    .writeTimeout(60, TimeUnit.SECONDS)
                    .retryOnConnectionFailure(true)
                    .addInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            Request request = chain.request().newBuilder()
                                    .addHeader("Content-Type","application/x-www-form-urlencoded")
                                    .addHeader("X-API-KEY","terminalbd")
                                    .addHeader("X-API-VALUE","terminalbd@aps")
                                    .build();
                            return chain.proceed(request);
                        }
                    })
                    .build();

            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
            
            
            apiRequests = retrofit.create(APIRequests.class);
            
            return apiRequests;
        }
        else {
            return apiRequests;
        }
    }

}


