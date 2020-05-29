package br.com.daniellopes.pokemonfavoriteapi.validacao;

public class ErrorFormDto {

    private final String campo;
    private final String erro;

    public ErrorFormDto(String campo, String erro) {
        this.campo = campo;
        this.erro = erro;
    }

    public String getCampo() {
        return campo;
    }

    public String getErro() {
        return erro;
    }
}
