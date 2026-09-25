public class Account{
    private int id;
    private String name;
    private double balance;
    public Account(int id,String name,double balance){
        this.id=id;
        this.name=name;
        this.balance=balance;
    }
    public int getId(){return id;}
    public String getName(){return name;}
    public double getBalance(){return balance;}
    public void deposit(double amount){balance+=amount;}
    public boolean withdraw(double amount){
        if(amount>0&&amount<=balance){
            balance-=amount;
            return true;
        }
        return false;
    }
    public String toFileString(){
        return id+"|"+name+"|"+balance;
    }
    public void display(){
        System.out.println("Account ID: "+id);
        System.out.println("Name: "+name);
        System.out.printf("Balance: %.2f%n",balance);
    }
}