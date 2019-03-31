package com.example.reham.booksborrowing.Retrofit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by reham on 3/25/2019.
 */

public class ApiClient {

        private static final String BASE_URL = "https://www.googleapis.com/books/v1/";
        private static Retrofit retrofit = null;
    static  HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        public static Retrofit getClient() {
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            httpClient.addInterceptor(logging);
            if (retrofit==null) {
                retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(httpClient.build())
                        .build();
            }
            return retrofit;
        }
    }



