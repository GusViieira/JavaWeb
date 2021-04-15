package Locadora1;
import java.util.Scanner;
public class Main {
    public static void main (String[] args){
        String nome;
        String email;
        String senha;
        
        Usuario u1;
        
        Scanner leitor = new Scanner(System.in);
        System.out.println("Informe o nome: ");
        nome = leitor.next();
        System.out.println("Informe o email: ");
        email = leitor.next();
        System.out.println("Informe a senha: ");
        senha = leitor.next();
        leitor.close();
        u1 = new Usuario(nome, email, senha);
        System.out.println(u1);
        u1.Cadastrar();
       
        CaractCarros caracteristicas;
        caracteristicas = new CaractCarros("Corsa", 10.00, "Azul", 1999, "Sedan");
        Carro c1 = new Carro (caracteristicas, true);
        
        System.out.println(u1);
        System.out.println(c1);
    }
}
