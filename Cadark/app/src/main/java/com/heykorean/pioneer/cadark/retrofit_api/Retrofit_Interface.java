package com.heykorean.pioneer.cadark.retrofit_api;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by Android on 1/25/2016.
 */
public interface Retrofit_Interface {
    //@GET("group/{id}/users")
    @GET("/v2/Market/member/Login?userid={username}&password={pass}")
    void getCurators(
            @Path("username") String username, @Path("pass") String pass , Callback<Curator> cb
    );

    @GET("/v2/Market/member/Login?userid=nfbs2000@gmail.com&password=1")
    void getCurators1(
            @Query("api_key") String key, Callback<Curator> cb
    );
}
