package br.com.fiap.to;

import jakarta.validation.constraints.NotNull;

public class DadosConsumoTO {
    @NotNull
    private int idUsuario;
    @NotNull
    private int idConsumo;
    @NotNull
    private int anoConsumo;
    @NotNull
    private String mesConsumo;
    @NotNull
    private double kwhConsumo;

    public DadosConsumoTO() {
    }

    public DadosConsumoTO(int idUsuario, int idConsumo, int anoConsumo, String mesConsumo, double kwhConsumo) {
        this.idUsuario = idUsuario;
        this.idConsumo = idConsumo;
        this.anoConsumo = anoConsumo;
        this.mesConsumo = mesConsumo;
        this.kwhConsumo = kwhConsumo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }


    public int getIdConsumo() {
        return idConsumo;
    }

    public void setIdConsumo(int idConsumo) {
        this.idConsumo = idConsumo;
    }

    public int getAnoConsumo() {
        return anoConsumo;
    }

    public void setAnoConsumo(int anoConsumo) {
        this.anoConsumo = anoConsumo;
    }

    public String getMesConsumo() {
        return mesConsumo;
    }

    public void setMesConsumo(String mesConsumo) {
        this.mesConsumo = mesConsumo;
    }

    public double getKwhConsumo() {
        return kwhConsumo;
    }

    public void setKwhConsumo(double kwhConsumo) {
        this.kwhConsumo = kwhConsumo;
    }
}
