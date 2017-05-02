package com.jrpascual.protodermcam.restApi;

import com.jrpascual.protodermcam.restApi.model.CitaResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Eversor on 01/05/2017.
 */

public interface EndPointsApi {
    @GET(ConstantesRestApi.URL_GET_INFORMATION_USER)
    Call<CitaResponse> getCitasUsuario();

}
