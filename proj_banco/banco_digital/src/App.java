import java.util.*;


public class App {

    public static void main(String[] args) throws Exception {
       Banco bancoDigital = new Banco();
       Conta criaConta1 = new Conta();
       Conta criaConta2 = new Conta();
       Client clientSelecionado = new Client();
       criaConta1.setTipo("corrente");
       criaConta1.setSaldo(500);
       bancoDigital.setCliente(0, "Antonio", 123456, 1234, criaConta1);
       criaConta2.setTipo("corrente");
       criaConta2.setSaldo(400);
       bancoDigital.setCliente(1, "Maria", 56789, 4321, criaConta2);
       
      // System.out.println(bancoDigital.getClientes(0).nome);
       //System.out.println(bancoDigital.getClientes(1).nome);
      // System.out.println(bancoDigital.getClientes(2).nome);
      
       int sair=0;
       int escolha1=0;
       int escolha2=0;
       int id,idBeneficiario;
       double valor;
       String nome;
       int senha=0;
       Mensagem1.exibir();
       Scanner entrada1 = new Scanner(System.in);
       escolha1 = entrada1.nextInt();
       if ( escolha1== 2) {
            System.out.println("digite seu id");
            id = entrada1.nextInt();
            clientSelecionado = bancoDigital.getClientes(id);
            System.out.println("Olá "+clientSelecionado.getNome()+" digite sua senha");
            senha=entrada1.nextInt();
            if (senha==clientSelecionado.getSenha()) {
                while(sair==0){
                    Mensagem2.exibir();
                    escolha2 = entrada1.nextInt();
                    switch (escolha2) {
                        case 1:
                             sair=1;
                        break;
                        case 2: // deposito
                            System.out.println("digite o valor");
                            valor=entrada1.nextDouble();
                            bancoDigital.depositar(valor, id);
                            
                        break;
                        case 3: //saque
                            System.out.println("digite o valor");
                            valor=entrada1.nextDouble();
                            bancoDigital.sacar(valor,id);
                        break;
                        case 4: // transferencia
                            System.out.println("digite o valor");
                            valor=entrada1.nextDouble();
                            System.out.println("digite o id do cliente beneficiado");
                            idBeneficiario=entrada1.nextInt();
                            bancoDigital.transferir(valor, id, idBeneficiario);
                        break; 
                        case 5:
                            valor=bancoDigital.extrato(id);
                            System.out.println("seu saldo é "+valor);
                        break;
                        default:
        
                        break;
                        }
                }
               
                } else {
                    System.out.println("senha incorreta");
                    sair=1;
                }
            } else {
                System.out.println("Por favor contate um gerente para abrir uma conta");
                    sair=1; 
            }
            
            
       
        
        
    }
}
