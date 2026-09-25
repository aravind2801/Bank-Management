import java.util.Scanner;
public class Main{
    static Scanner sc=new Scanner(System.in);
    static Bank bank=new Bank();
    public static void main(String[] args){
        while(true){
            System.out.println("\n===== BANK MANAGEMENT =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Balance Check");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice=sc.nextInt();
            switch(choice){
                case 1:createAccount();break;
                case 2:deposit();break;
                case 3:withdraw();break;
                case 4:balanceCheck();break;
                case 5:
                    System.out.println("Thank you!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
    static void createAccount(){
        System.out.print("Enter Account ID: ");
        int id=sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name=sc.nextLine();
        System.out.print("Enter Initial Balance: ");
        double balance=sc.nextDouble();
        if(bank.createAccount(id,name,balance))
            System.out.println("Account created successfully!");
        else
            System.out.println("Account already exists or invalid balance!");
    }
    static void deposit(){
        System.out.print("Enter Account ID: ");
        int id=sc.nextInt();
        System.out.print("Enter Amount: ");
        double amount=sc.nextDouble();
        if(bank.deposit(id,amount))
            System.out.println("Deposit successful!");
        else
            System.out.println("Invalid account or amount!");
    }
    static void withdraw(){
        System.out.print("Enter Account ID: ");
        int id=sc.nextInt();
        System.out.print("Enter Amount: ");
        double amount=sc.nextDouble();
        int result=bank.withdraw(id,amount);
        if(result==1)
            System.out.println("Withdrawal successful!");
        else if(result==0)
            System.out.println("Account not found!");
        else
            System.out.println("Insufficient balance!");
    }
    static void balanceCheck(){
        System.out.print("Enter Account ID: ");
        int id=sc.nextInt();
        Account account=bank.getAccount(id);
        if(account==null)
            System.out.println("Account not found!");
        else
            account.display();
    }
}