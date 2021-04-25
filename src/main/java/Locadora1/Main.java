package Locadora1;

import java.util.Iterator;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        ArrayList<Carro> carros = new ArrayList<Carro>();
        //CRIAR TESTES E INSTANCIAR
        Cliente c1 = new Cliente("gabriel", "q", "q", 1);
        clientes.add(c1);
        Funcionario f1 = new Funcionario("Alan", "a", "a", -1); // TROCAR DEPOIS
        Funcionario f2 = new Funcionario("Gabriel", "gabriel@gmail.com", "123456", -2);
        Carro car1 = new Carro("compacto", "azul", "2012", "muito bem conservado", 12f);
        carros.add(car1);
        do {
            telasLocadora("LOCADORA PAO DURO", "BEM VINDO", textosProntos(8));
            switch (lerDados(scan, "Informe a ação que deseja: ")) {
                case "0":
                    System.exit(0);
                    break;
                case "1":
                    Cliente.cadastrarCliente(scan, clientes);
                    break;
                case "2":
                    int logar = Usuario.login(scan, clientes, f1, f2);
                    if (logar != 0) {
                        if (logar < 0) {                                            //login funcionario
                            Funcionario.metodosFuncionario(scan, logar, f1, f2, carros);
                        }
                        if (logar > 0) { //login como cliente
                            Cliente.metodosCliente(scan, logar, clientes, carros);
                        }
                    }
                    break; 
                    
                    
                    
                    /*case "2": //c1.editarPerfil(scan);//mudar C1
                    ;break;
                case "3"://for(Cliente aux: clientes)
                        //      System.out.println(aux);
                    ;break;
                case "4": Carro.cadastrarCarro(scan, carros);
                ;break;
                case "5": //carros.editarCarro(scan);//Mandar apenas 1
                    ;break;
                case "6": Carro.listarCarros(carros);
                ;break;
                case "7": //c1.alugarCarro(scan, carros); // adicionar o carro alugado de um usuário
                          //c1.verCarroAlug();;
                    ;break;*/
            }
        } while (true);


        //ACOES


        //f1.editarPerfil(scan);
        //c1.setCarAlug(car1);
        //c1.verCarroAlug();
        //car1.editarCarro(scan);
        //f1.setEditarCarro(car1);
        //f1.getEditarCarro();//precisa colocar scan, mas da erro
        //Carro.cadastrarCarro(scan, carros);
//        for (int i = 0; i < 3; i++) {//listar
//            Carro car = new Carro("compacto", "azul", "2012", "muito bem conservado", 12f);
//            car.setIdCarro(i + 1);
//            if (i % 2 == 0)
//                car.setDispCarro(false);
//            else
//                car.setDispCarro(true);
//            carros.add(car);
        //System.out.println(aux);
        //    }
//        c1.alugarCarro(scan, carros); // adicionar o carro alugado de um usuário
//        c1.verCarroAlug();
//        if(car1.cadastrarCarro(scan)) { // para testar o cadastro dos carros
//            listaCarros.add(car1);
//            System.out.println("O cadastro foi realizado com sucesso");
//            System.out.println(listaCarros.toString());
//        }else
//            System.out.println("O cadastro nao foi realizado com sucesso\t Tente novamente...");
    }

    public static boolean verOpcao(int opc, int ini, int fim) {
        // false - numero que nao existe opcao; true - numero que existe opcao
        return opc < ini || opc > fim;
    }

    //Metodo para criação das opções de telas, utilizado em conjunto com o metodo "telasLocadora"
    public static String textosProntos(int i) {
        String frase = null;
        switch (i) {
            case 1 -> frase = "|0 - Sair\n|1 - Editar Perfil\n|2 - Alugar\n|3 - Ver Carro Alugado";// Cliente
            case 2 -> frase = "|0 - Sair\n|1 - Editar nome\n|2 - Editar Email\n|3 - Editar Senha"; //Editar Perfil
            case 3 -> frase = "|0 - Sair\n|1 - Cadastrar\n|2 - Editar";
            case 4 -> frase = "|0 - Sair\n|1 - Editar Modelo\n|2 - Editar Cor\n|3 - Editar Ano\n|4 - Editar Descricao\n|5 - Editar Valor";
            case 5 -> frase = "|Modelo: String\n|Cor: String\n|Ano: String\n|Descricao: String\n|Valor: Float";
            case 6 -> frase = "|NOME: String\n|EMAIL: String\n|SENHA: String";
            case 7 -> frase = "|0 - Sair\n|1 - Editar Perfil\n|2 - Cadastrar Carro\n|3 - Listar Carros\n|4 - Editar Carro\n";//TELA FUNCIONARIO
            case 8 -> frase = "|0 - Sair\n|1 - Cadastrar\n|2 - Logar";//INICIO PROGRAMA
            case 9 -> frase = "|Email: String\n|Senha: String";//TELA DE LOGIN
        }
        return frase;
    }

    //Metodo para padronização das telas
    public static void telasLocadora(String nomeLoc, String nomeFun, String fun) { // nomeLoc -> nome da locadora; nomeFun -> nome da tela de funcoes; fun -> opções de funções de "textosProntos";
        String lin = "--";
        int a = nomeLoc.length();
        for (int i = 0; i < a; i++)
            lin = lin.concat("-");
        System.out.printf(" %s\n" +
                          "| %s |\n" +
                          " %s\n" +
                          " %s\n" +
                          " %s\n" +
                          "%s\n" +
                          " %s\n", lin, nomeLoc, lin, nomeFun, lin, fun, lin);
    }

    //le os dados
    public static String lerDados(Scanner scan, String texto) {
        String dado;
        do {
            System.out.printf("%s", texto);
            dado = scan.nextLine();
            if (dado.isEmpty())
                System.out.println("O dado nao pode ser nulo\tDigite novamente...");
        } while (dado.isEmpty());
        dado = dado.trim();
        return dado;
    }

    //
    public static int indexOfIdCarro(ArrayList<Carro> carros, int pesq) {
        for (Carro carro : carros) {
            if (carro.isDispCarro())
                if (carro.getIdCarro() == pesq)
                    return carros.indexOf(carro);// retorna a posicao
        }
        return -1; // caso não exista o valor dentro do ArrayList
    }
}
