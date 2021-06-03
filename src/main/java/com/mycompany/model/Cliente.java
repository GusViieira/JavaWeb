package com.mycompany.model;

import com.mycompany.view.Main;
import java.util.ArrayList;
import java.util.Scanner;

public class Cliente extends Usuario implements Interface {  //HERANÇA DE USUARIO
    private Carro carAlug;

//-------------------------------------------------------------------------------------------------------------------

    //CONSTRUTORES DE CLIENTE
    public Cliente(String nome, String email, String senha, int idUsuario) {
        super(nome, email, senha, idUsuario);
    }

    public Cliente() {
        super();
    }
//-------------------------------------------------------------------------------------------------------------------

    //METODO GET carAlug
    public Carro getCarAlug() {
        return carAlug;
    }

    //METODO SET carAlug
    public void setCarAlug(Carro carAlug) {
        this.carAlug = carAlug;
    }
//-------------------------------------------------------------------------------------------------------------------

    //METODO QUE CRIA UM NOVO CADASTRO DE CLIENTE
    public boolean cadastrarCliente(Scanner scan, ArrayList<Cliente> clientes) {
        if (this.cadastrarUsuario(scan)) {
            this.setIdUsuario(clientes.size() + 1); //idUsuario IRÁ SER INDEX(posicao no array) + 1
            return true;
        }
        return false;
    }

    //MOSTRA O CARRO ALUGADO PELO CLIENTE
    public void verCarroAlug() {
        System.out.print("\n\n -----------------------\n" +
                         "|   LOCADORA PAO DURO   |\n" +
                         "-----------------------\n" +
                         "      Carro alugado     \n" +
                         "-----------------------\n");
        if (this.getCarAlug() != null) //MOSTRAR AS INFORMACOES DO CARRO
            System.out.printf("|Modelo: %s\n" +
                              "|Cor: %s\n" +
                              "|Ano do ve\u00edculo: %s\n" +
                              "|Descri\u00e7\u00e3o: %s\n" +
                              "|Valor do carro: R$ %.2f\n" +
                              "-----------------------\n",
                    this.getCarAlug().getModelo(),
                    this.getCarAlug().getCor(),
                    this.getCarAlug().getAno(),
                    this.getCarAlug().getDescricao(),
                    this.getCarAlug().getValor());
        else
            System.out.println("\n NAO EXISTE UM CARRO ALUGADO\n\n-----------------------");//QUANDO NAO HOUVER CARRO CADASTRADO
    }

    //METODO PARA CLIENTE ALUGAR CARRO
    public void alugarCarro(Scanner scan, ArrayList<Carro> carros) {
        Carro aux;
        int var, index;
        System.out.println("\n\n");//PARA PULAR LINHAS
        Main.telasLocadora("LOCADORA PAO DURO", "ALUGAR CARRO", this.listarCarros(carros)); //TELA MOSTRANDO TODOS OS CARROS DISPONIVEIS PARA ALUGAR
        boolean i;
        do {    //VERIFICACAO DE CODIGO DO CARRO
            i = false;
            var = Integer.parseInt(Main.lerDados(scan, "Digite o codigo do ID do carro: "));
            index = Main.indexOfIdCarro(carros, var);

            if (index == -1) {
                System.out.println("O dado nao existe na lista\tDigite novamente...");
                i = true;
            }
        } while (i);
        aux = carros.get(index);    //RECEBE O CARRO DISPONIVEL
        System.out.println("\n\n");//PARA PULAR LINHAS
        Main.telasLocadora("LOCADORA PAO DURO", "ALUGAR CARRO", aux.toString());
        var = Integer.parseInt(Main.lerDados(scan, "Quer alugar esse carro? (1/SIM)(0/NAO): "));
        if (var == 1) {
            this.setCarAlug(aux);   //CLIENTE RECEBE CARRO
            this.getCarAlug().setDispCarro(false);  //CARRO FICA INDISPONIVEL
        }
    }

    //METODO PARA RETORNAR O CARRO ALUGADO
    public void retornarCarro() {
        this.getCarAlug().setDispCarro(true);
        this.setCarAlug(null);
    }

    //METODO PARA TODAS AS FUNCIONALIDADES DE CLIENTE
    public void metodosCliente(Scanner scan, ArrayList<Carro> carros) {
        String opc;
        do {    //LOOPING DE MENU DE CLIENTE
            System.out.println("\n\n");     //PARA PULAR LINHAS
            Main.telasLocadora("LOCADORA PAO DURO", "BEM VINDO " + this.getNome(), Main.textosProntos(1));
            opc = Main.lerDados(scan, "Informe a ação que deseja: ");
            switch (opc) {
                case "0":   //SAIR
                    break;
                case "1":   //EDITAR PERFIL DO CLIENTE
                    this.editarPerfil(scan);
                    break;
                case "2":   //ALUGAR CARRO (APENAS 1)
                    if (this.getCarAlug() == null)
                        this.alugarCarro(scan, carros);
                    else
                        System.out.println("\n\n\nNAO EH POSSIVEL ALUGAR MAIS DE UM CARROS");
                    break;
                case "3":   //VER O CARRO ALUGADO
                    this.verCarroAlug();
                    System.out.println("Digite qualquer coisa para voltar...");
                    scan.nextLine();
                    break;
                case "4":   //RETORNA O CARRO PARA ALUGUEL NOVAMENTE
                    if (this.getCarAlug() != null)
                        this.retornarCarro();
                    else
                        System.out.print("\n\n\nNAO EXITE UM CARRO ALUGADO PELO CLIENTE\t Tente novamente...");
                    break;
            }
        } while (!opc.equals("0"));
    }

    //METODO PARAR LISTAR CARROS
    @Override
    public String listarCarros(ArrayList<Carro> carros) {
        String texto = "CODIGO   -    MODELO      -   ANO    -    VALOR\n";
        for (Carro aux : carros) {
            if (aux.isDispCarro())
                texto += (aux.toString() + "\n");
        }
        return texto + "\n";   //RETORNA STRING QUE CONTEM A LISTA DE CARROS
    }
}
