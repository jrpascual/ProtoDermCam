package com.jrpascual.protodermcam.restApi.deserializador;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.jrpascual.protodermcam.pojo.Cita;
import com.jrpascual.protodermcam.restApi.JsonKeys;
import com.jrpascual.protodermcam.restApi.model.CitaResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by Eversor on 02/05/2017.
 */

public class CitaDeserializador implements JsonDeserializer<CitaResponse> {
    @Override
    public CitaResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        CitaResponse citaResponse = gson.fromJson(json, CitaResponse.class);
        JsonArray citaResponseData = json.getAsJsonObject().getAsJsonArray(JsonKeys.CITA_RESPONSE_ARRAY);
        citaResponse.setCitas(deserializarCitaDeJson(citaResponseData));
        return citaResponse;
    }

    private ArrayList<Cita> deserializarCitaDeJson(JsonArray citaResponseData){
        ArrayList<Cita> citas = new ArrayList<>();
        for (int i = 0; i < citaResponseData.size() ; i++) {
            JsonObject citaResponseObject = citaResponseData.get(i).getAsJsonObject();
            String id = citaResponseObject.get(JsonKeys.CITA_ID).getAsString();
            String nhc = citaResponseObject.get(JsonKeys.CITA_NHC).getAsString();
            String codepisodio = citaResponseObject.get(JsonKeys.CITA_CODEPISODIO).getAsString();
            String fechaCita = citaResponseObject.get(JsonKeys.CITA_FECHAHORA).getAsString();
            String nombrePac = citaResponseObject.get(JsonKeys.CITA_NOMPAC).getAsString();
            String tipoCons = citaResponseObject.get(JsonKeys.CITA_TIPOCONS).getAsString();
            String diagnostico = citaResponseObject.get(JsonKeys.CITA_DIAGNOSTICO).getAsString();

            Cita cita = new Cita(id,nhc,fechaCita);
            cita.setCodEpisodio(codepisodio);
            cita.setNombrePaciente(nombrePac);
            cita.setTipoConsulta(tipoCons);
            cita.setDiagnostico(diagnostico);

            citas.add(cita);
        }
        return  citas;
    }
}
