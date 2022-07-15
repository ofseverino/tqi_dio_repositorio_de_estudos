public class Conta {
    protected String tipo="indefinido              ";
    //protected int numero;
    protected double saldo=0;
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    /*public int getNumero() {
        return numero;
    }*/
    /*public void setNumero(int numero) {
        this.numero = numero;
    }*/
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
