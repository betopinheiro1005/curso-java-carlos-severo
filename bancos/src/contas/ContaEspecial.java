package contas;

import classes.Pessoa;
import contas.Conta;
import excecoes.SaldoInsuficienteException;

public final class ContaEspecial extends Conta {
    
	private float limite;

	public ContaEspecial(){

	}

	public ContaEspecial(int numero, Pessoa correntista, float valor, float limite){
		super(numero, correntista, valor);
		this.setLimite(limite);
	}

	public float getLimite() {
		return limite;
	}

	public void setLimite(float limite){
		this.limite = limite;
	}

        @Override
	public void sacar(float valor) throws SaldoInsuficienteException {
            if(this.getSaldo() - valor >= this.getLimite()) {
		this.setSaldo(this.getSaldo() - valor);
            } else {
                throw new SaldoInsuficienteException(this.getSaldo(), valor);
            }
	}
    
}
