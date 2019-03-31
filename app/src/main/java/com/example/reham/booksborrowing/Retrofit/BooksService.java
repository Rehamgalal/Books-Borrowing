package com.example.reham.booksborrowing.Retrofit;

import com.example.reham.booksborrowing.Data.Book;
import com.example.reham.booksborrowing.Data.Items;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by reham on 3/25/2019.
 */

public interface BooksService {
    @GET("volumes")
    Call<Book> getBooks(@Query("q") String subject);
    @GET("volumes/{id}")
    Call<Items> getBook(@Path("id") String id);
}
