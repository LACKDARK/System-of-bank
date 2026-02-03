import java.util.Scanner;
 class sistemadecontabancaria {
    private final Scanner input = new Scanner(System.in);
    private Conta conta;

    public static void main(String[] args) {

        sistemadecontabancaria app = new sistemadecontabancaria();

        app.iniciar();
    }

    void iniciar() {
        criarconta();

        boolean executando = true;
        while (executando) {
            executando = menu();

        }

        input.close();
    }

      void criarconta(){
        System.out.println("Digite seu nome: ");

        String nome = input.nextLine();

        System.out.println("Digite o saldo inicial: ");

        double saldo = input.nextDouble();

        input.nextLine();

        conta = new Conta(nome, saldo);

    }

     class Conta {

        private String nome;
        private double saldo;

        public Conta(String nome, double saldo) {

            if (nome == null ||nome.isBlank()){
                throw new IllegalArgumentException("Invalid name.");
            }

            if (saldo <= 0){
                throw new IllegalArgumentException("Invalid balance.");
            }

            this.nome = nome;
            this.saldo = saldo;

        }

        public void depositar(double valor) {
            if (valor < 1) {
                throw new IllegalArgumentException("Invalid value.");
            }

            this.saldo += valor;

        }

        public void sacar(double valor) {
            if (valor < 1 ){
                throw new IllegalArgumentException("Invalid value.");
            } else if (valor > this.saldo) {
                throw new IllegalArgumentException("Insufficient balance.");
            }

            this.saldo -= valor;
        }

        public double getsaldo() {

            return saldo;
        }

    }

     boolean menu() {

        System.out.println("\nMenu do usuário\n");

        System.out.println("1.Withdraw");
        System.out.println("2.Deposit");
        System.out.println("3.See founds");
        System.out.println("4.Exit");
        int opcao = input.nextInt();

        switch (opcao) {

            case 1:
                saque();
                break;
            case 2:
                deposito();
                break;
            case 3:
                saldo();
                break;
            case 4: {
                return false;
            }

            default: System.out.print("Opção Inválida");

        }

        return true;
    }

     void deposito() {
       System.out.println("How much do you want to Deposit?: ");
       double deposito = input.nextDouble();
       conta.depositar(deposito);


    }

     void saque() {
           System.out.println("How much do you want to Withdraw?: ");
        double saque = input.nextDouble();
        conta.sacar(saque);

    }

     void saldo() {
        System.out.println("Your balance: " + conta.getsaldo());
    }
}