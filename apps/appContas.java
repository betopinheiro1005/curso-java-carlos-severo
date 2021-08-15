package apps;

import classes.Pessoa;
import contas.Conta;
import contas.ContaComum;
import contas.ContaEspecial;

public class appContas {

    public static void main(String[] args) {
        Pessoa p1 = new Pessoa("Fernando Borges", "fernando_borgessgmail.com");
        ContaComum c1 = new ContaComum(123456, p1, 150.00f);
        System.out.println("Número de contas instanciadas até o momento: " + c1.getNumeroContas());
        
        ContaEspecial e1 = new ContaEspecial(145362, p1, 2500.00f, 5500.00f);
        System.out.println("Número de contas instanciadas até o momento: " + e1.getNumeroContas());
        
        System.out.println("");
        
        if(c1.sacar(1000.00f)){
            System.out.println("Saque efetuado com sucesso!");
        } else {
            System.out.println("Saldo insuficiente!");
        }

        if(c1.movimentar(1000.00f, Conta.SACAR)){
            System.out.println("Saque efetuado com sucesso!");
        } else {
            System.out.println("Saldo insuficiente!");
        }

        c1.movimentar(200.00f, Conta.DEPOSITAR);
        System.out.println("Depósito realizado com sucesso!");
        System.out.printf("Novo saldo: %.2f \n\n", c1.getSaldo());
        
        
        System.out.println("Novo do correntista: " + c1.getCorrentista());
        System.out.println("Novo do correntista: " + c1.getCorrentista().getNome());
        
        System.out.println("");
        
    }
    
}
