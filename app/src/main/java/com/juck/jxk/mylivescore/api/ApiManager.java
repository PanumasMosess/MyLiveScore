package com.juck.jxk.mylivescore.api;

import com.juck.jxk.mylivescore.Model.FixtureManager;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by JXK on 18/11/2560.
 */

public interface ApiManager {
    @GET("/v1/fixtures")
    Call<FixtureManager> getMyJSON();
}
