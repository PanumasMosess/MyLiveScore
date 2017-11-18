package com.juck.jxk.mylivescore.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by JXK on 18/11/2560.
 */

public class FixtureService {
    private static final String ROOT_URL = "http://api.football-data.org";
    /**
     * Get Retrofit Instance
     */
    private static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl(ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    /**
     * Get API Service
     *
     * @return API Service
     */
    public static ApiManager getMyJSON() {
        return getRetrofitInstance().create(ApiManager.class);
    }
}
