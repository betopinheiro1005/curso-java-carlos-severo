package contas;

import classes.Pessoa;
import excecoes.SaldoInsuficienteException;

public class ContaPoupanca extends Conta {

    public ContaPoupanca() {
    }

    public ContaPoupanca(int numero, Pessoa correntista, float valor) {
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
    
}
