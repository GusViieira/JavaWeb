package Locadora1;
import java.util.Scanner;
public class CaractCarro {

    private String modelo;
    private String cor;
    private String ano;
    private String descricao;
    private float valor;

    public CaractCarro(String modelo, String cor, String ano, String descricao, float valor) {
        this.modelo = modelo;
        this.cor = cor;
        this.ano = ano;
        this.descricao = descricao;
        this.valor = valor;
    }

    public CaractCarro(){

    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    public void Cadastrar(Scanner scan) {
        System.out.print("Cadastre o carro:");
        System.out.print("Informe o modelo:");
        this.setModelo(scan.nextLine());
        System.out.print("Informe a cor:");
        this.setCor(scan.nextLine());
        System.out.print("Informe o ano:");
        this.setAno(scan.nextLine());
        System.out.print("Informe a descricao:");
        this.setDescricao(scan.nextLine());
        System.out.print("Informe o valor:");
        this.setValor(scan.nextFloat());
    }
    @Override
    public String toString() {
        return "CaractCarro{" +
               "modelo='" + modelo + '\'' +
               ", cor='" + cor + '\'' +
               ", ano='" + ano + '\'' +
               ", descricao='" + descricao + '\'' +
               ", valor=" + valor +
               '}';
    }
}
