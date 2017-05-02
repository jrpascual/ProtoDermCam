package com.jrpascual.protodermcam.restApi.model;

import com.jrpascual.protodermcam.pojo.Cita;

import java.util.ArrayList;

/**
 * Created by Eversor on 01/05/2017.
 */

public class CitaResponse {
        ArrayList<Cita> citas;

    public ArrayList<Cita> getCitas() {
        return citas;
    }

    public void setCitas(ArrayList<Cita> citas) {
        this.citas = citas;
    }
}
