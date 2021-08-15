package apps;

import classes.Pessoa;
import contas.ContaEspecial;

public class appContaEspecial {

    public static void main(String[] args) {
   
        ContaEspecial e1;
        Pessoa p1 = new Pessoa("Bruno Teixeira", "bruno_teixeira@hotmail.com");
        e1 = new ContaEspecial(123458, p1, 0.00f, -1000.00f);
        
        System.out.printf("Saldo inicial da conta: %.2f\n", e1.getSaldo());
        System.out.printf("Limite: %.2f\n\n", e1.getLimite());
    
        if(e1.sacar(1200.00f)){
            System.out.println("Operação de saque realizada com sucesso!");
            System.out.printf("Saldo atual da conta é %.2f\n\n", e1.getSaldo());
        } else {
            System.out.println("Limite insuficiente para realização do saque!\n");
        }
        
        if(e1.sacar(800.00f)){
            System.out.println("Operação de saque realizada com sucesso!");
            System.out.printf("Saldo atual da conta é %.2f\n\n", e1.getSaldo());
        } else {
            System.out.println("Limite insuficiente para realização do saque!\n");
        }
        
    }
    
}
