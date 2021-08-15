
import classes.Pessoa;
import contas.Conta;
import contas.ContaComum;
import excecoes.SaldoInsuficienteException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class appTesteConta1 {

    public static void main(String[] args) {

        // Solicitando ao usuário os dados para criar uma conta comum
        Scanner teclado = new Scanner(System.in);
        teclado.useLocale(Locale.FRENCH);

        int numero = 0;
        String nome, email;
        float saldo = 0, valorsaque = 0;
        
        System.out.print("Número da conta: ............... ");
        try{
            numero = teclado.nextInt();
        } catch(InputMismatchException e) {
            System.out.println("Informe um valor numérico inteiro para o número da conta, ex: 123456");
            System.exit(0);
        }
        
        System.out.print("Correntista: ................... ");
        nome = teclado.next();
        
        System.out.print("Email: ......................... ");
        email = teclado.next();
        
        System.out.print("Saldo inicial: ................. ");
        try{
            saldo = teclado.nextFloat();
        } catch(InputMismatchException e) {
            System.out.println("Informe um valor numérico válido para o saldo inicial, ex: 300,00");
            System.exit(0);
        }

        Conta contacomum = new ContaComum(numero, new Pessoa(nome, email), saldo);
        
        System.out.print("Valor do saque: ................ ");
        try{
            valorsaque = teclado.nextFloat();
        } catch(InputMismatchException e) {
            System.out.println("Informe um valor numérico válido para o valor do depósito, ex: 100,00");
            System.exit(0);
        }
        
        try{
            contacomum.sacar(valorsaque);
        } catch(SaldoInsuficienteException e){
            System.out.println(e);
        }

        System.out.printf("Saldo atual: ................... %.2f \n", contacomum.getSaldo());
        
    }
   
}