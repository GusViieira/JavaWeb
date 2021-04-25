package Locadora1;
import java.util.Scanner;
public class CaractCarro {

    private String modelo;
    private String cor;
    private String ano;
    private String descricao;
    private float valor;
//-------------------------------------------------------------------------------------------------------------------

    //CONSTRUTORES DE CaractCarro
    public CaractCarro(String modelo, String cor, String ano, String descricao, float valor) {
        this.modelo = modelo;
        this.cor = cor;
        this.ano = ano;
        this.descricao = descricao;
        this.valor = valor;
    }

    public CaractCarro(){
        
    }
//-------------------------------------------------------------------------------------------------------------------

    //METODO GET modelo
    public String getModelo() {
        return modelo;
    }

    //METODO SET modelo
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    //METODO GET cor
    public String getCor() {
        return cor;
    }

    //METODO SET cor
    public void setCor(String cor) {
        this.cor = cor;
    }

    //METODO GET ano
    public String getAno() {
        return ano;
    }

    //METODO SET ano
    public void setAno(String ano) {
        this.ano = ano;
    }

    //METODO GET descricao
    public String getDescricao() {
        return descricao;
    }

    //METODO SET descricao
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    //METODO GET valor
    public float getValor() {
        return valor;
    }

    //METODO SET valor
    public void setValor(float valor) {
        this.valor = valor;
    }
//-------------------------------------------------------------------------------------------------------------------

    //METODO PARA CADASTRAR UM CARRO
    public boolean obterCarro(Scanner scan) {
        Carro car = new Carro();
        Main.telasLocadora("LOCADORA PAO DURO", "CADASTRAR CARRO", Main.textosProntos(5));
        car.setModelo(Main.lerDados(scan, "Informe modelo (ou '-1' para sair): "));
        if (!car.getModelo().equals("-1")) {
            car.setCor(Main.lerDados(scan, "Informe cor (ou '-1' para sair):  "));
            if (!car.getCor().equals("-1")) {
                car.setAno(Main.lerDados(scan, "Informe ano (ou '-1' para sair): "));
                if (!car.getAno().equals("-1")) {
                    car.setDescricao(Main.lerDados(scan, "Informe descricao (ou '-1' para sair): "));
                    if (!car.getDescricao().equals("-1")) {
                        car.setValor(Float.parseFloat(Main.lerDados(scan, "Informe valor (ou '-1' para sair): ")));
                        if (car.getValor() != -1) {     //COLOCAR OS DADOS DENTRO DE UM NOVO OBJETO
                            this.setModelo(car.getModelo());
                            this.setCor(car.getCor());
                            this.setAno(car.getAno());
                            this.setDescricao(car.getDescricao());
                            this.setValor(car.getValor());
                            return true;    //CADASTRO OCORREU CORRETAMENTE
                        }
                    }
                }
            }
        }
        return false; //CADASTRO NAO OCORREU(POR ERRO OU USUARIO DIGITAR "-1")
    }
    
    //METODO PARA EDITAR O CARRO
    public void editarCarro(Scanner scan) {
        int aux;
        do {
            do {    //VERIFICA E VALIDA OPCAO PARA EDITAR
                Main.telasLocadora("LOCADORA PAO DURO", "EDITAR CARRO", Main.textosProntos(4));
                aux = Integer.parseInt(Main.lerDados(scan, "Digite um valor: "));
            } while (Main.verOpcao(aux, 0, 5));
            if (aux != 0)
                switch (aux) {      //CHAMA O METODO EDITAR OS DADOS DO CARRO
                    case 1 -> this.editarAtributoCarro(scan, "modelo");
                    case 2 -> this.editarAtributoCarro(scan, "cor");
                    case 3 -> this.editarAtributoCarro(scan, "ano");
                    case 4 -> this.editarAtributoCarro(scan, "descricao");
                    case 5 -> this.editarAtributoCarro(scan, "valor");
                }
            else
                System.out.println();
        } while (aux != 0);
    }
    
    //METODO PARA EDITAR OS DADOS DO CARRO
    public void editarAtributoCarro(Scanner scan, String str) { //str -> QUAL TIPO IRA EDITAR
        String frase;
        String ant = "|" + str + " atual: ";
        switch (str) {      //MUDA A STRING ANT PARA APRESENTAR VALOR ANTIGO DA STRING QUE IRA EDITAR
            case "modelo" -> ant = ant.concat(this.getModelo());
            case "cor" -> ant = ant.concat(this.getCor());
            case "ano" -> ant = ant.concat(this.getAno());
            case "descricao" -> ant = ant.concat(this.getDescricao());
            case "valor" -> ant = ant.concat(String.valueOf(this.getValor()));
        }
        Main.telasLocadora("LOCADORA PAO DURO", "EDITAR " + str.toUpperCase(), ant);
        frase = Main.lerDados(scan, "Digite o " + str + " (ou '-1' para sair): ");     //VERIFICA E VALIDA DADOS DIGITADOS
        if (!frase.equals("-1"))
            switch (str) {      //MODIFICA A NOVA STRING(ATRIBUTO)
                case "modelo" -> this.setModelo(frase);
                case "cor" -> this.setCor(frase);
                case "ano" -> this.setAno(frase);
                case "descricao" -> this.setDescricao(frase);
                case "valor" -> this.setValor(Float.parseFloat(frase));
            }
    }
}
