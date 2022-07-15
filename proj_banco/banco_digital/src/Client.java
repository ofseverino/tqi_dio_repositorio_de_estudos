public class Client {
    protected String nome="                                                                                 ";
    protected int cpf=0;
    protected int senha=0;
    protected Conta conta = new Conta();
   /* public Client(String nome, int cpf,int senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha= senha;
    }*/
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
   
    public int getSenha() {
        return senha;
    }
    public void setSenha(int senha) {
        this.senha = senha;
    }
    public Conta getConta() {
        return conta;
    }
    public void setConta(Conta conta) {
        this.conta = conta;
    }
    public int getCpf() {
        return cpf;
    }
    public void setCpf(int cpf) {
        this.cpf = cpf;
    }
  
    
}
