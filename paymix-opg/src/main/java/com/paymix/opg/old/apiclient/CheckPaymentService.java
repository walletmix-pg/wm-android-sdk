package com.paymix.opg.old.apiclient;

import com.google.gson.JsonElement;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Url;

interface CheckPaymentService {

    @FormUrlEncoded
    @POST
    Call<JsonElement> checkPayment(@Url String url, @FieldMap Map<String, String> params);

}