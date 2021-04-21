package Locadora1;
import java.util.Scanner;

public class Cliente extends Usuario {

    private int idCliente;
    private Carro carAlug;

    public Cliente(String nome, String email, String senha) {
        super(nome, email, senha);
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Carro getCarAlug() {
        return carAlug;
    }

    public void setCarAlug(Carro carAlug) {
        this.carAlug = carAlug;
    }

    // metodo para editar as informações do cliente
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
                    case 1 -> this.editarAtributoCliente(scan, "nome");
                    case 2 -> this.editarAtributoCliente(scan, "email");
                    case 3 -> this.editarAtributoCliente(scan, "senha");
                }
            else
                System.out.println();
        } while (aux != 0);
    }

    // para editar os atributos de string do cliente
    public void editarAtributoCliente(Scanner scan, String str) { // str -> Qual tipo ira editar
        String frase;
        String ant = "|" + str + " atual: ";
        switch (str) { // personalizar a string ant para apresentar na tela o valor antigo da string que esta editando
            case "nome" -> ant = ant.concat(this.getNome());
            case "email" -> ant = ant.concat(this.getEmail());
            case "senha" -> ant = ant.concat(this.getSenha());
        }
        do {//verifica e valida a digitação da nova string
            Main.telasLocadora("LOCADORA PAO DURO", "EDITAR " + str.toUpperCase(), ant);
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

    // ver a lista e selecionar um carro
    public void alugarCarro() { // passar a lista de carros

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
                          "|Valor do carro: R$%.2f\n" +
                          "-----------------------\n",
                this.getCarAlug().getModelo(),
                this.getCarAlug().getCor(),
                this.getCarAlug().getAno(),
                this.getCarAlug().getDescricao(),
                this.getCarAlug().getValor());
    }

}
