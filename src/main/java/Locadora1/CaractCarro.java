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

    //metodo para cadastrar um carro
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
                        if (car.getValor() != -1) { // colocar os dados dentro de um dos elementos do objeto
                            this.setModelo(car.getModelo());
                            this.setCor(car.getCor());
                            this.setAno(car.getAno());
                            this.setDescricao(car.getDescricao());
                            this.setValor(car.getValor());
                            return true; // cadastro ocorreu de forma correta
                        }
                    }
                }
            }
        }
        return false; // valor false caso o usuario digitar "-1"
    }
    
    //Metodo para editar o valor de "caractCarro" de "carro"
    public void editarCarro(Scanner scan) {
        int aux;
        do {
            do { // verifica e valida a digitação da opção para editar
                System.out.println("\n");
                System.out.println(this.toString()); // para testes
                Main.telasLocadora("LOCADORA PAO DURO", "EDITAR CARRO", Main.textosProntos(4));
                aux = Integer.parseInt(Main.lerDados(scan, "Digite um valor: "));
            } while (Main.verOpcao(aux, 0, 5));
            if (aux != 0)
                switch (aux) {//vai para o metodo de editar o atributo do usuario
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
    
    // para editar os atributos de string do cliente
    public void editarAtributoCarro(Scanner scan, String str) { // str -> Qual tipo ira editar
        String frase;
        String ant = "|" + str + " atual: ";
        switch (str) { // personalizar a string ant para apresentar na tela o valor antigo da string que esta editando
            case "modelo" -> ant = ant.concat(this.getModelo());
            case "cor" -> ant = ant.concat(this.getCor());
            case "ano" -> ant = ant.concat(this.getAno());
            case "descricao" -> ant = ant.concat(this.getDescricao());
            case "valor" -> ant = ant.concat(String.valueOf(this.getValor()));
        }
        Main.telasLocadora("LOCADORA PAO DURO", "EDITAR " + str.toUpperCase(), ant);
        frase = Main.lerDados(scan, "Digite o " + str + " (ou '-1' para sair): ");//verifica e valida a digitação da nova string
        if (!frase.equals("-1"))
            switch (str) { // atualiza a nova string
                case "modelo" -> this.setModelo(frase);
                case "cor" -> this.setCor(frase);
                case "ano" -> this.setAno(frase);
                case "descricao" -> this.setDescricao(frase);
                case "valor" -> this.setValor(Float.parseFloat(frase));
            }
    }
}
