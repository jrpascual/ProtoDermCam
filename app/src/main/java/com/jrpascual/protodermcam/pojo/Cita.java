package com.jrpascual.protodermcam.pojo;

/**
 * Created by Eversor on 01/05/2017.
 */

public class Cita {
    private String id;
    private String nhc;
    private String codEpisodio;
    private String FechaHoraCita;
    private String nombrePaciente;
    private String tipoConsulta;
    private String diagnostico;

    public Cita(String id, String nhc, String fechaHoraCita) {
        this.id = id;
        this.nhc = nhc;
        this.FechaHoraCita = fechaHoraCita;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNhc() {
        return nhc;
    }

    public void setNhc(String nhc) {
        this.nhc = nhc;
    }

    public String getCodEpisodio() {
        return codEpisodio;
    }

    public void setCodEpisodio(String codEpisodio) {
        this.codEpisodio = codEpisodio;
    }

    public String getFechaHoraCita() {
        return FechaHoraCita;
    }

    public void setFechaHoraCita(String fechaHoraCita) {
        FechaHoraCita = fechaHoraCita;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoConsulta(String tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }
}
