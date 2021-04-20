package Locadora1;
import java.util.Scanner;

public class Funcionario extends Usuario {
    private int idFuncionario;
    private Carro editarCarro;
    
    public Funcionario(String nome, String email, String senha) {
        super(nome, email, senha);
    }
    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }
    public Carro getEditarCarro() {
        return editarCarro;
    }

    public void setEditarCarro(Carro editarCarro) {
        this.editarCarro = editarCarro;
    }
    // metodo para editar as informações do funcionario
    public void editarPerfil(Scanner scan) {
        int aux;
        do {
            do { // verifica e valida a digitação da opcao para editar
                System.out.println("\n");
                System.out.println(super.toString()); // para testes
                Main.telasLocadora("LOCADORA PAO DURO", "EDITAR PERFIL", Main.textosProntos(2));
                System.out.print("Digite um valor: ");
                aux = scan.nextInt();
            } while (!Main.verOpcao(aux, 0, 3));
            scan.nextLine();
            if (aux != 0)
                switch (aux) {//vai para o metodo de editar o atributo do usuario
                    case 1 -> this.editarAtributoFuncionario(scan, "nome");
                    case 2 -> this.editarAtributoFuncionario(scan, "email");
                    case 3 -> this.editarAtributoFuncionario(scan, "senha");
                }
            else
                System.out.println();
        } while (aux != 0);
    }
    
    public void editarAtributoFuncionario(Scanner scan, String str) { // str -> Qual tipo ira editar
        String frase;
        String ant = "|" + str + " atual: ";
        switch (str) { // personalizar a string ant para apresentar na tela o valor antigo da string que esta editando
            case "nome" -> ant = ant.concat(this.getNome());
            case "email" -> ant = ant.concat(this.getEmail());
            case "senha" -> ant = ant.concat(this.getSenha());
        }
        do {//verifica e valida a digitação da nova string
            Main.telasLocadora("LOCADORA PAO DURO", "EDITAR PERFIL", ant);
            System.out.print("Digite o " + str + " (ou '-1' para sair): ");
            frase = scan.nextLine();
            frase = frase.trim();
        } while ((frase.length() == 0));
        if (!frase.equals("-1"))
            switch (str) { // atualiza a nova string
                case "nome" -> super.setNome(frase);
                case "email" -> super.setEmail(frase);
                case "senha" -> super.setSenha(frase);
            }
    }
        
    /*private void cadastrarCarro(listaCarro){
        System.out.printf("Informe modelo:" +
                          "Informe cor: %s" +
                          "Informe ano: %s" +
                          "Informe descricao: %s" +
                          "Informe valor: %.2f",
                          this.getCarro().setModelo(),
                          this.getCarro().setCor(),
                          this.getCarro().setAno(),
                          this.getcarro().setDescricao(),
                          this.getcarro().setValor());
        
    }*/
    
        public void editarCarro(Scanner scan) {
        int aux;
        do {
            do { // verifica e valida a digitação da opcao para editar
                System.out.println("\n");
               System.out.println(super.toString()); // para testes
                Main.telasLocadora("LOCADORA PAO DURO", "EDITAR CARRO", Main.textosProntos(4));
                System.out.print("Digite um valor: ");
                aux = scan.nextInt();
            } while (!Main.verOpcao(aux, 0, 5));
            scan.nextLine();
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
            case "modelo" -> ant = ant.concat(this.getEditarCarro().getModelo());
            case "cor" -> ant = ant.concat(this.getEditarCarro().getCor());
            case "ano" -> ant = ant.concat(this.getEditarCarro().getAno());
            case "descricao" -> ant = ant.concat(this.getEditarCarro().getDescricao());
            case "valor" ->  ant = ant.concat(String.valueOf(this.getEditarCarro().getValor()));
        }
        do {//verifica e valida a digitação da nova string
            Main.telasLocadora("LOCADORA PAO DURO", "EDITAR PERFIL", ant);
            System.out.print("Digite o " + str + " (ou '-1' para sair): ");
            frase = scan.nextLine();
            frase = frase.trim();
        } while ((frase.length() == 0));
        if (!frase.equals("-1"))
            switch (str) { // atualiza a nova string
                case "nome" -> super.setNome(frase);
                case "email" -> super.setEmail(frase);
                case "senha" -> super.setSenha(frase);
            }
    }

}