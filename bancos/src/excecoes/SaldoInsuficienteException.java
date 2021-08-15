package excecoes;

public class SaldoInsuficienteException extends Exception {
    private float saldo;
    private float valor;

    public SaldoInsuficienteException(float saldo, float valor) {
        this.saldo = saldo;
        this.valor = valor;
    }
    
    @Override
    public String toString() {
        String saldo_formatado = String.format("%.2f", saldo);
        String valor_formatado = String.format("%.2f", valor);
        
        return "Saldo insuficiente para o saque! O saldo atual é R$" + saldo_formatado + " e você está tentando sacar R$" + valor_formatado;
    }
    
    
}
