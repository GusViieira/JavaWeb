package Locadora1;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Cliente c1 = new Cliente("gabriel", "a@gmail.com", "qwerty");
        Usuario u1 = new Usuario("gabriel", "a@gmail.com", "qwerty");
        //u1.setNome("    Gabriel    ");
        c1.editarPerfil(scan);
        Carro car1 = new Carro("compacto","azul","2012","muito bem conservado", 12f);
        c1.setCarAlug(car1);
        c1.verCarroAlug();
        Funcionario f1 = new Funcionario("gabriel", "a@gmail.com", "qwerty");
        f1.setEditarCarro(car1);
        f1.editarCarro(scan);

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
}
