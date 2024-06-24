public class Main {
    public static void main(String[] args) {


        Cliente cliente = new Cliente();
        cliente.setNome("Leandro");

        Cliente cliente2 = new Cliente();
        cliente.setNome("Teste");


        Conta conta = new ContaCorrente(cliente);
        Conta conta2 = new ContaCorrente(cliente2);


        conta.depositar(100);
        conta.imprimirExtrato();
        conta.transferir(200, conta2);
        conta.imprimirExtrato();
        conta2.imprimirExtrato();



    }
}
