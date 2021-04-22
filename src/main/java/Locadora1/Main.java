package Locadora1;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    ArrayList<Carro> listaCarros = new ArrayList<Carro>();
    private Carro carro;
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        //CRIAR TESTES E INSTANCIAR
        Cliente c1 = new Cliente("gabriel", "a@gmail.com", "qwerty");
        Funcionario f1 = new Funcionario("Alan", "alan@gmail.com", "123456");
        Usuario u1 = new Usuario("gabriel", "a@gmail.com", "qwerty");
        Carro car1 = new Carro("compacto", "azul", "2012", "muito bem conservado", 12f);
        
        //ACOES
        c1.editarPerfil(scan);
        f1.editarPerfil(scan);
        c1.setCarAlug(car1);
        c1.verCarroAlug();
        f1.setEditarCarro(car1);
        f1.getEditarCarro();//precisa colocar scan, mas da erro
//      this.listaCarros.add(new Carro.cadastrarCarro()); // MODIFICAR O CADASTRARCARRO (NÃO É STATIC)
//        if(car1.cadastrarCarro(scan)) { // para testar o cadastro dos carros
//            listaCarros.add(car1);
//            System.out.println("O cadastro foi realizado com sucesso");
//            System.out.println(listaCarros.toString());
//        }else
//            System.out.println("O cadastro nao foi realizado com sucesso\t Tente novamente...");

//        
//        for (Carro aux : listaCarros)
//            System.out.println(aux); // testar a lista
    }

    public static boolean verOpcao(int opc, int ini, int fim) {
        // false - numero que nao existe opcao; true - numero que existe opcao
        return opc >= ini && opc <= fim;
    }

    //Metodo para criação das opções de telas, utilizado em conjunto com o metodo "telasLocadora"
    public static String textosProntos(int i) {
        String frase = null;
        switch (i) {
            case 1 -> frase = "|0 - Sair\n|1 - Cadastrar\n|2 - Editar\n|3 - Alugar";
            case 2 -> frase = "|0 - Sair\n|1 - Editar nome\n|2 - Editar Email\n|3 - Editar Senha";
            case 3 -> frase = "|0 - Sair\n|1 - Cadastrar\n|2 - Editar";
            case 4 -> frase = "|0 - Sair\n|1 - Editar Modelo\n|2 - Editar Cor\n|3 - Editar Ano\n|4 - Editar Descricao\n|5 - Editar Valor";
            case 5 -> frase = "|Modelo: String\n|Cor: String\n|Descricao: String\n|Valor: Float";
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


    public static String lerDados(Scanner scan, String texto) {
        String dado = null;
        do {
            System.out.printf("%s", texto);
            dado = scan.nextLine();
            if (dado.isEmpty())
                System.out.println("O dado nao pode ser nulo\tDigite novamente...");
        } while (dado.isEmpty());
        dado = dado.trim();
        return dado;
    }
}
