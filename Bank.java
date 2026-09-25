import java.io.*;
import java.util.*;
public class Bank{
    private ArrayList<Account> accounts=new ArrayList<>();
    private final String fileName="accounts.txt";
    public Bank(){
        loadAccounts();
    }
    private Account findAccount(int id){
        for(Account account:accounts){
            if(account.getId()==id)return account;
        }
        return null;
    }
    public boolean createAccount(int id,String name,double balance){
        if(findAccount(id)!=null||balance<0)return false;
        accounts.add(new Account(id,name,balance));
        saveAccounts();
        return true;
    }
    public boolean deposit(int id,double amount){
        Account account=findAccount(id);
        if(account==null||amount<=0)return false;
        account.deposit(amount);
        saveAccounts();
        return true;
    }
    public int withdraw(int id,double amount){
        Account account=findAccount(id);
        if(account==null)return 0;
        if(!account.withdraw(amount))return -1;
        saveAccounts();
        return 1;
    }
    public Account getAccount(int id){
        return findAccount(id);
    }
    private void saveAccounts(){
        try(BufferedWriter writer=new BufferedWriter(new FileWriter(fileName))){
            for(Account account:accounts){
                writer.write(account.toFileString());
                writer.newLine();
            }
        }catch(IOException e){
            System.out.println("Error saving data.");
        }
    }
    private void loadAccounts(){
        File file=new File(fileName);
        if(!file.exists())return;
        try(BufferedReader reader=new BufferedReader(new FileReader(file))){
            String line;
            while((line=reader.readLine())!=null){
                String[] data=line.split("\\|");
                if(data.length==3){
                    int id=Integer.parseInt(data[0]);
                    String name=data[1];
                    double balance=Double.parseDouble(data[2]);
                    accounts.add(new Account(id,name,balance));
                }
            }
        }catch(IOException|NumberFormatException e){
            System.out.println("Error loading data.");
        }
    }
}