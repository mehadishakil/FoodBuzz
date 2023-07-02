package com.miui.foodbuzz;

import com.miui.foodbuzz.dataFetch.responseModel;
import com.miui.foodbuzz.dataUpload.dataUploadClass;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiSet {

    @FormUrlEncoded
    @POST("popular_item.php")
    Call<dataUploadClass> uploadImage (@Field("title") String title, @Field("price") String price, @Field("description") String description, @Field("image") String image);


    @GET("fetch_popular_item.php")
    Call<List<responseModel>>getData();



}
