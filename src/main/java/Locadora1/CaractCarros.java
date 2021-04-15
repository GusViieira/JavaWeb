
package Locadora1;

class CaractCarros {
    private String modelo;
    private double valor;
    private String cor;
    private int ano;
    private String descricao;

    public CaractCarros(String modelo, double valor, String cor, int ano, String descricao) {
        this.modelo = modelo;
        this.valor = valor;
        this.cor = cor;
        this.ano = ano;
        this.descricao = descricao;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}