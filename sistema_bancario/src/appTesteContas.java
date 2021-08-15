
import classes.Pessoa;
import contas.Conta;
import contas.ContaComum;

public class appTesteContas {

    public static void main(String[] args) {

        Conta contacomum = new ContaComum(198764, new Pessoa("Gilson Santos", "gilson_santos@gmail.com"), 150.00f);
        System.out.println("Correntista: " + contacomum.getCorrentista().getNome());
        System.out.println("Saldo inicial da conta: " + contacomum.getSaldo());
        
        contacomum.depositar(350.00f);
        
        System.out.println("Saldo atual da conta: " + contacomum.getSaldo());
        
        
    }
    
}
