package com.paymix.opg.old.apiclient;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import javax.net.ssl.SSLHandshakeException;

import retrofit2.HttpException;

class HttpErrorHandler {

    private static final String SERVER_ERROR_MESSAGE = "We are having some trouble completing your request at this moment. Please try again shortly.";
    private static final String TIME_OUT_MESSAGE = "Could not connect with the server. Please try again later.";

    static void handleError(Throwable throwable, final ErrorListener errorListener){
        if(throwable instanceof HttpException){
            int errorCode = ((HttpException) throwable).code();
            if(errorCode == 500)
                errorListener.onError(SERVER_ERROR_MESSAGE);
        } else if ((throwable instanceof SocketTimeoutException) || (throwable instanceof SSLHandshakeException)) {
            errorListener.onError(TIME_OUT_MESSAGE);
        }else if (throwable instanceof ConnectException){
            errorListener.onError(SERVER_ERROR_MESSAGE);
        }
    }

    protected interface ErrorListener{

        void onError(String errorMessage);
    }
}