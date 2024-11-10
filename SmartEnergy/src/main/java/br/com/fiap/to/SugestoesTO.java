package br.com.fiap.to;

public class SugestoesTO {
    private int idSugestao;
    private String temaSugestao;
    private String dsSugestao;

    public SugestoesTO() {
    }

    public SugestoesTO(int idSugestao, String temaSugestao, String dsSugestao) {
        this.idSugestao = idSugestao;
        this.temaSugestao = temaSugestao;
        this.dsSugestao = dsSugestao;
    }

    public int getIdSugestao() {
        return idSugestao;
    }

    public void setIdSugestao(int idSugestao) {
        this.idSugestao = idSugestao;
    }

    public String getTemaSugestao() {
        return temaSugestao;
    }

    public void setTemaSugestao(String temaSugestao) {
        this.temaSugestao = temaSugestao;
    }

    public String getDsSugestao() {
        return dsSugestao;
    }

    public void setDsSugestao(String dsSugestao) {
        this.dsSugestao = dsSugestao;
    }
}
