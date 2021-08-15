package apps;

import classes.Movimento;
import classes.Pessoa;
import classes.Transacao;
import contas.Conta;
import contas.ContaComum;
import java.text.SimpleDateFormat;
import java.util.Date;

public class appTransacoes {

    public static void main(String[] args) {
        Transacao transacoes = new Transacao();
        Pessoa pessoa = new Pessoa("Adalberto Ribeiro", "adalberto_ribeiro@gmail.com");
        Conta contacomum = new ContaComum(102030, pessoa, 450.00f);
        
        float saldoanterior = contacomum.getSaldo();
        
        transacoes.realizarTTransacao(new Date(), contacomum, 100.00f, "Depósito em dinheiro.", Conta.DEPOSITAR);
        transacoes.realizarTTransacao(new Date(), contacomum, 50.00f, "Pagamento conta luz", Conta.SACAR);
        transacoes.realizarTTransacao(new Date(), contacomum, 120.00f, "Pagamento conta telefone", Conta.SACAR);
        transacoes.realizarTTransacao(new Date(), contacomum, 850.00f, "Transferência entre contas.", Conta.DEPOSITAR);
        
        // Exibindo o extrato da conta
        
        System.out.println("Emitindo extrato da conta comum número " + contacomum.getNumero());
        System.out.println("Correntista: " + contacomum.getCorrentista().getNome());
        System.out.println("Saldo anterior: " + saldoanterior);
        System.out.println("==============================================");
        
        for(Movimento movimento: transacoes.getMovimentos()){
            System.out.println("Data: " + new SimpleDateFormat("dd/MM/yyyy").format(movimento.getData()));
            System.out.println("Histórico: " + movimento.getHistorico());
            System.out.printf("Valor: %.2f \n", movimento.getValor());
            System.out.println("Movimento: " + (movimento.getOperacao() == Conta.DEPOSITAR ? "Depósito" : "Saque"));
            System.out.println("==============================================");
        }
        
        System.out.println("Saldo atual: " + contacomum.getSaldo() + "\n");
        
    }
    
}
