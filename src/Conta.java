public abstract class Conta implements Iconta{

    private static final int AGENCIA_PADRAO = 0001;
    private static int CONTA_SEQUENCIAL = 0001;


    protected int numeroConta;
    protected int agencia ;
    protected double saldo;
    protected Cliente cliente;


    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numeroConta = CONTA_SEQUENCIAL++;
        this.cliente = cliente;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public int getAgencia() {
        return agencia;
    }

    public double getSaldo() {
        return saldo;
    }


    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void sacar(double valor) {
        if(valor > getSaldo()){
            throw new RuntimeException("Saldo insuficiente. Saldo disponível é de apenas: R$" + getSaldo());
        }
        saldo -= valor;
    }

    @Override
    public void transferir(double valor, Iconta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Conta: %d", this.numeroConta));
        System.out.println(String.format("Saldo: R$ %.2f", this.saldo));
    }

}
