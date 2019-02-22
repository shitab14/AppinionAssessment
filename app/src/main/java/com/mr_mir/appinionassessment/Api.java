package com.mr_mir.appinionassessment;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    String BASE_URL = "https://raw.githubusercontent.com/appinion-dev/intern-dcr-data/master/";

    @GET("data.json")
    Call<Data> getTheData();

}

