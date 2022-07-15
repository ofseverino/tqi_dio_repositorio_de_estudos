import java.util.*;

public class Banco {
    Client cliente0 = new Client();
    protected Client[] clientes= {
        cliente0,cliente0,cliente0
    };
    
    
    public double extrato(int id){
        return clientes[id].conta.getSaldo() ;
    }

    public void depositar(double valor, int id) {
        double saldo =+ clientes[id].conta.getSaldo();
        clientes[id].conta.setSaldo(saldo+valor);
    }

    public boolean sacar(double valor,int id) {
        double saldo = clientes[id].conta.getSaldo();
        if (saldo>valor) {
            clientes[id].conta.setSaldo(saldo-valor);
            return true;
        } else {
            System.out.println("saldo insuficiente");
            return false;
        }
    }

    public void transferir(double valor,int idOrigem, int idDestino) {
        if (this.sacar(valor, idOrigem)) {
           this.depositar(valor, idDestino); 
        }else{
            System.out.println("saldo insuficiente"); 
        }
        

    }

    public void setCliente(int id,String nome,int cpf,int senha,Conta conta) {
        clientes[0].setNome(nome);
        clientes[id].setSenha(senha);
        clientes[id].setCpf(cpf);
        clientes[id].setConta(conta);
    }


    public Client getClientes(int id) {
        return clientes[id];
    }

   

}
