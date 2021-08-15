package contas;

import classes.Taxas;
import classes.Pessoa;
import excecoes.SaldoInsuficienteException;

public final class ContaComum extends Conta implements Taxas {

    public ContaComum() {
    }

    public ContaComum(int numero, Pessoa correntista, float valor) {
        super(numero, correntista, valor);
    }

    @Override
    public void sacar(float valor) throws SaldoInsuficienteException{
        if(this.getSaldo() >= valor){
            this.setSaldo(this.getSaldo() - valor);
        } else {
            throw new SaldoInsuficienteException(this.getSaldo(), valor);
        }
    }
    
    @Override
    public float getTaxaManutencao(){
        return 15.00f;
    }
    
    @Override
    public void descontarTaxaManutencao(){
        this.setSaldo(this.getSaldo() - this.getTaxaManutencao());
    }

}
