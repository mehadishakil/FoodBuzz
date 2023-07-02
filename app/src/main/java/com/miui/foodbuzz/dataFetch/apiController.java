package com.miui.foodbuzz.dataFetch;

import com.miui.foodbuzz.ApiSet;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class apiController {

    public static final String BASE_URL ="http://10.0.2.2/foodbuzz/";
    private static apiController clientObject;
    public static Retrofit retrofit;


    apiController()
    {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
    }

    public static synchronized apiController getInstance()
    {
        if (clientObject == null)
            clientObject = new apiController();

        return clientObject;
    }

    public ApiSet getApi()
    {
        return retrofit.create(ApiSet.class);
    }

}
