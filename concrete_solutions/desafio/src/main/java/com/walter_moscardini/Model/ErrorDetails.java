package com.walter_moscardini.Model;

public class ErrorDetails {

    private String mensagem;

    public ErrorDetails() {}

    public ErrorDetails(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
