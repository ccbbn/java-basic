package chap06.check;

public class Q20 {
    private String ano;
    private String owner;
    private int balance;

    public Q20(String ano, String owner, int balance) {
        this.ano = ano;
        this.owner = owner;
        this.balance = balance;
    }

    public String getAno() { return ano; }
    private void setAno() { this.ano = ano; }
    public String getOwner() { return owner; }
    public void setOwner(String owner) { this.owner = owner; }
    public int getBalance() { return balance; }
    public void setBalance(int balance) {
        if (balance < 0) {
            System.out.println("잔액이 부족");
            return;
        }
        this.balance = balance; }

}
