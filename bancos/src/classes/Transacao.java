package classes;

import contas.Conta;
import excecoes.SaldoInsuficienteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// composição transação/movimento (relação mais forte que agregação)

public class Transacao {

    private List<Movimento> movimentos;
    
    public Transacao(){
        movimentos = new ArrayList<>();
    }
    
    // Efetiva uma movimentação na conta
    
    public void realizarTTransacao(Date data, Conta conta, float valor, String historico, int operacao) throws SaldoInsuficienteException {
        Movimento movimento = new Movimento(data, conta, historico, valor, operacao);
        movimento.movimentar();
        this.movimentos.add(movimento);
    }
    
    public void extornaTransacao(){
        for(Movimento movimento: this.movimentos){
            movimento = null;
        }
    }
    
    public List<Movimento> getMovimentos(){
        return this.movimentos;
    }
    
}
