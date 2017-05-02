package com.jrpascual.protodermcam.restApi.adapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jrpascual.protodermcam.restApi.ConstantesRestApi;
import com.jrpascual.protodermcam.restApi.EndPointsApi;
import com.jrpascual.protodermcam.restApi.deserializador.CitaDeserializador;
import com.jrpascual.protodermcam.restApi.model.CitaResponse;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Eversor on 01/05/2017.
 */

public class RestApiAdapter {
    public EndPointsApi establecerConexionRestApiMirth(Gson gson){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.URLBASE)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(EndPointsApi.class);
    }

    public Gson construyeGsonDeserializador(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(CitaResponse.class, new CitaDeserializador());
        return gsonBuilder.create();
    }

}
