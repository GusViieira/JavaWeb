package Locadora1;

import java.util.ArrayList;
import java.util.Scanner;

public class Cliente extends Usuario {

    private Carro carAlug;

    public Cliente(String nome, String email, String senha, int idUsuario) {
        super(nome, email, senha, idUsuario);
    }

    public Cliente() {
        super();
    }

    public Carro getCarAlug() {
        return carAlug;
    }

    public void setCarAlug(Carro carAlug) {
        this.carAlug = carAlug;
    }

    // metodo que cria um novo cadastro de cliente
    public static void cadastrarCliente(Scanner scan, ArrayList<Cliente> clientes) {
        Cliente cliente = new Cliente();
        if (cliente.cadastrarUsuario(scan)) {
            cliente.setIdUsuario(clientes.size() + 1);
            clientes.add(cliente);
        }
    }

    // ele mostra um print dos dados de carro de um cliente
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

    // alugarCarro(lista de carros,scan)
    public void alugarCarro(Scanner scan, ArrayList<Carro> carros) {
        Carro aux = new Carro();
        Main main = new Main();
        int var, index;
        Main.telasLocadora("LOCADORA PAO DURO", "ALUGAR CARRO", Carro.listarCarros(carros));
        boolean i;
        do {
            i = false;
            var = Integer.parseInt(Main.lerDados(scan, "Digite o codigo do ID do carro: "));
            index = main.indexOfIdCarro(carros, var);

            if (index == -1) {
                System.out.println("O dado nao existe na lista\tDigite novamente...");
                i = true;
            }
        } while (i);
        aux = carros.get(index);// receber o carro disp
        Main.telasLocadora("LOCADORA PAO DURO", "ALUGAR CARRO", aux.toString());
        var = Integer.parseInt(Main.lerDados(scan, "Quer alugar esse carro? (1/SIM)(0/NAO): "));
        if (var == 1) {
            this.carAlug = aux; // o cliente recebe o carro
            aux.setDispCarro(false); // carro fica indisponivel
        }
    }

    // metodo para todas as funcionalidades de funcionario
    public static void metodosCliente(Scanner scan, int logar, ArrayList<Cliente> clientes, ArrayList<Carro> carros) {
        String opc;
        do {
            Main.telasLocadora("LOCADORA PAO DURO", "BEM VINDO", Main.textosProntos(1));
            opc = Main.lerDados(scan, "Informe a ação que deseja: ");
            switch (opc) {
                case "0":
                    break;
                case "1":// Editar Perfil do cliente
                    clientes.get(logar - 1).editarPerfil(scan);
                    break;
                case "2":// Alugar Carro
                    clientes.get(logar - 1).alugarCarro(scan, carros);
                    break;
                case "3":// Ver carro alugado
                    clientes.get(logar - 1).verCarroAlug();
                    break;
            }
        } while (!opc.equals("0"));
    }
}
