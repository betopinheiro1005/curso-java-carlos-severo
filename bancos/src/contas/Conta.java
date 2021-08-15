package contas;

import classes.Pessoa;
import excecoes.SaldoInsuficienteException;

/**
* A classe <strong>Conta</strong> define um tipo de dado abstrato para a criação de estrutura de classes de contas bancárias
* @author Roberto Pinheiro
* @since ago/2021
* @version 1.0
*/
public abstract class Conta {

    // atributos de instância

    /**
    * O atributo número é utilizado para referenciar o número da conta.
    */
    protected int numero;

    /**
    * O atributo correntista, do tipo <b>Pessoa</b> é utilizado para referenciar um correntista.
    */
    protected Pessoa correntista;

    /**
    * O atributo saldo é utilizado para referenciar a saída da conta.
    */
    protected float saldo;

    // atributo de classe

    /**
    * Constante que define a operação de saque.
    */
    public final static int SACAR = 0;

    /**
    * Constante que define a operação de depósito.
    */
    public final static int DEPOSITAR = 1;


    private static int numero_contas;
    
    /**
     * construtor default da classe <b>Conta</b>
     * <b>Uso: </b><br>
     * Conta conta = new ContaComum();
     */
    public Conta() { 
        incrementa_contas();
    }

    /**
     * construtor sobrecarregado da classe <b>Conta</b>
     * <b>Uso: </b><br>
     * Conta conta = new ContaComum(102374, new Pessoa("Fulano", "fulano@gmail.com"), 150.00f)<br>;
     * <b>Onde:</b><br>
     * @param numero inteiro que identifica o número da conta.
     * @param correntista objeto do tipo <b>Pessoa</b> que identifica o correntista da conta
     * @param valor float que identifica o saldo inicial da conta
     */
    public Conta(int numero, Pessoa correntista, float valor) {
        this();
        this.numero = numero;
        this.correntista = correntista;
        this.saldo = valor;
    }

    public final int getNumero() {
        return numero;
    }

    public final void setNumero(int numero) {
        this.numero = numero;
    }

    public final Pessoa getCorrentista() {
        return correntista;
    }

    public final void setCorrentista(Pessoa correntista) {
        this.correntista = correntista;
    }

    public final float getSaldo() {
        return saldo;
    }

    public final void setSaldo(float saldo) {
        this.saldo = saldo;
    }
    
    public int getNumeroContas(){
        return this.numero_contas;
    }

    public final void depositar(float valor){      // método concreto
        this.setSaldo(this.getSaldo() + valor);
    }
    
    public abstract void sacar(float valor) throws SaldoInsuficienteException;  // método polimórfico
    
    public void movimentar(float valor, int operacao) throws SaldoInsuficienteException {
        switch(operacao){
            case DEPOSITAR:
                this.depositar(valor);
                break;
            case SACAR:
                this.sacar(valor);
        }
    }
    
    private static void incrementa_contas(){
        numero_contas++;
    }

}
