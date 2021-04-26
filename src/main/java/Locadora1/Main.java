package Locadora1;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    //METODO PRINCIPAL DO PROGRAMA
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Cliente> clientes = new ArrayList<>();     //OBJETO: LISTA DE CLIENTES
        ArrayList<Carro> carros = new ArrayList<>();           //OBJETO: LISTA DE CARROS
        Funcionario f1 = new Funcionario("Alan", "alan@gmail.com", "123456", -1);     //OBJETO: FUNCIONARIO f1
        Funcionario f2 = new Funcionario("Gabriel", "gabriel@gmail.com", "123456", -2);     //OBJETO: FUNCIONARIO f2
        do {    //INICIO DO LOOPING DO MENU
            telasLocadora("LOCADORA PAO DURO", "BEM VINDO", textosProntos(8));
            switch (lerDados(scan, "Informe a ação que deseja: ")) {
                case "0":   //SAIR
                    System.exit(0);
                    break;
                case "1":   //CADASTRO CLIENTE
                    Cliente aux = new Cliente();
                    if (aux.cadastrarCliente(scan, clientes))
                        clientes.add(aux);
                    break;
                case "2":   //LOGIN
                    int logar = Usuario.login(scan, clientes, f1, f2);
                    if (logar != 0) {
                        if (logar < 0) {    //LOGIN COMO FUNCIONARIO
                            if (f1.getIdUsuario() == logar)
                                f1.metodosFuncionario(scan, carros);
                            else
                                f2.metodosFuncionario(scan, carros);
                        }
                        if (logar > 0) {    //LOGIN COMO CLIENTE
                            clientes.get(logar - 1).metodosCliente(scan, carros);
                        }
                    }
                    break;
            }
            System.out.println("\n\n");//PARA PULAR LINHAS
        } while (true);
    }

    //METODO QUE VERIFICA SE opc ESTA ENTRE ini E fim
    public static boolean verOpcao(int opc, int ini, int fim) {
        //opc FALSE - NUMERO QUE NAO EXISTE; opc TRUE - nuNUMERO QUE EXISTE
        return opc < ini || opc > fim;
    }

    //METODO PARA CRIACAO DAS OPCOES DE TEXTO DE TELAS, ACONSELHADO A UTILIZA-LO COM O METODO "telasLocadora"
    public static String textosProntos(int i) {
        String frase = null;
        switch (i) {    //INFORMACOES CONTIDAS NAS TELAS DO PROGRAMA
            case 1:     //TELA PRINCIPAL DO CLIENTE
                frase = "|0 - Sair\n|1 - Editar Perfil\n|2 - Alugar\n|3 - Ver Carro Alugado\n|4 - Retornar Carro";
                break;
            case 2:     //TELA DE EDITAR PERFIL
                frase = "|0 - Sair\n|1 - Editar Nome\n|2 - Editar Email\n|3 - Editar Senha";
                break;
            case 3:     //TELA DE LOGIN
                frase = "|Email: String\n|Senha: String";
                break;
            case 4:     //EDITAR CARRO
                frase = "|0 - Sair\n|1 - Editar Modelo\n|2 - Editar Cor\n|3 - Editar Ano\n|4 - Editar Descricao\n|5 - Editar Valor";
                break;
            case 5:     //TELA CADASTRO CARRO
                frase = "|Modelo: String\n|Cor: String\n|Ano: String\n|Descricao: String\n|Valor: Float";
                break;
            case 6:     //TELA CADASTRO DE USUARIO
                frase = "|NOME: String\n|EMAIL: String\n|SENHA: String";
                break;
            case 7:     //TELA PRINCIPAL DE FUNCIONARIO
                frase = "|0 - Sair\n|1 - Editar Perfil\n|2 - Cadastrar Carro\n|3 - Listar Carros\n|4 - Editar Carro\n";
                break;
            case 8:     //INICIO PROGRAMA
                frase = "|0 - Sair\n|1 - Cadastrar\n|2 - Logar";
                break;
        }
        return frase;
    }

    //METODO PADRAO DE TELAS
    public static void telasLocadora(String nomeLoc, String nomeFun, String fun) { // nomeLoc -> NOME DA LOCADORA; nomeFun -> NOME DA TELA; fun -> OPCAO DAS FUNCOES EM "textosProntos";
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

    //LER E VALIDAR DADOS DE ENTRADA
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

    //ADIQUIRI O NUMERO INDEX DA LISTA DE CARROS BASEADO NO ID DOS CARROS
    public static int indexOfIdCarro(ArrayList<Carro> carros, int pesq) {
        for (Carro carro : carros) {
            if (carro.isDispCarro())
                if (carro.getIdCarro() == pesq)
                    return carros.indexOf(carro);   //RETORNA A POSICAO(INDEX) DE UM CARRO
        }
        return -1;   //CASO NAO EXISTA O VALOR DENTRO DO ARRAYLIST
    }
}
