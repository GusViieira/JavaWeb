package Locadora1;

import java.util.ArrayList;
import java.util.Scanner;

public class Cliente extends Usuario {  //HERANÇA DE USUARIO

    private Carro carAlug;

//-------------------------------------------------------------------------------------------------------------------

    // CONSTRUTORES DE CLIENTE
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
    public static void cadastrarCliente(Scanner scan, ArrayList<Cliente> clientes) {
        Cliente cliente = new Cliente();
        if (cliente.cadastrarUsuario(scan)) {
            cliente.setIdUsuario(clientes.size() + 1); // IdUsuario VAI SER INDEX(posicao do array) + 1
            clientes.add(cliente);
        }
    }

    //MOSTRA UM PRINT DOS DADOS DE CARRO DO CLIENTE
    public void verCarroAlug() {
        System.out.printf(" -----------------------\n" +
                          "|   LOCADORA PAO DURO   |\n" +
                          "-----------------------\n" +
                          "|     Carro alugado     |\n" +
                          "-----------------------\n" +
                          "|Modelo: %s\n" +
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
    }

    // METODO PARA CLIENTE ALUGAR CARRO
    public void alugarCarro(Scanner scan, ArrayList<Carro> carros) {
        Carro aux;
        int var, index;
        Main.telasLocadora("LOCADORA PAO DURO", "ALUGAR CARRO", Carro.listarCarros(carros)); // TELA MOSTRANDO TODOS OS CARROS DISPONIVEIS PARA ALUGAR
        boolean i;
        do {    // VERIFICACAO DE CODIGO DO CARRO
            i = false;
            var = Integer.parseInt(Main.lerDados(scan, "Digite o codigo do ID do carro: "));
            index = Main.indexOfIdCarro(carros, var);

            if (index == -1) {
                System.out.println("O dado nao existe na lista\tDigite novamente...");
                i = true;
            }
        } while (i);
        aux = carros.get(index);    //RECEBE O CARRO DISPONIVEL
        Main.telasLocadora("LOCADORA PAO DURO", "ALUGAR CARRO", aux.toString());
        var = Integer.parseInt(Main.lerDados(scan, "Quer alugar esse carro? (1/SIM)(0/NAO): "));
        if (var == 1) {
            this.setCarAlug(aux);   //CLIENTE RECEBE CARRO
            this.getCarAlug().setDispCarro(false);  //CARRO FICA INDISPONIVEL
        }
    }

    // METODO PARA TODAS AS FUNCIONALIDADES DE CLIENTE
    public static void metodosCliente(Scanner scan, int logar, ArrayList<Cliente> clientes, ArrayList<Carro> carros) {
        String opc;
        do { // LOOPING DE MENU DE CLIENTE
            Main.telasLocadora("LOCADORA PAO DURO", "BEM VINDO", Main.textosProntos(1));
            opc = Main.lerDados(scan, "Informe a ação que deseja: ");
            switch (opc) {
                case "0":   //SAIR
                    break;
                case "1":   //EDITAR PERFIL DO CLIENTE
                    clientes.get(logar - 1).editarPerfil(scan);
                    break;
                case "2":   //ALUGAR CARRO
                    clientes.get(logar - 1).alugarCarro(scan, carros);
                    break;
                case "3":   //VER O CARRO ALUGADO
                    clientes.get(logar - 1).verCarroAlug();
                    break;
            }
        } while (!opc.equals("0"));
    }
}
