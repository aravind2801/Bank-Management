public class Main {
    public static void main(String[] args) {
        BankLedger bank = new BankLedger();
        while (true) {
            System.out.println("\n==============================");
            System.out.println("      SECUREBANK MENU");
            System.out.println("==============================");
            System.out.println("1. Add Account");
            System.out.println("2. Add Money");
            System.out.println("3. Debit Money");
            System.out.println("4. Display Statement");
            System.out.println("5. Exit");
            System.out.println("==============================");
            int choice = bank.getChoice();
            switch (choice) {
                case 1:
                    bank.addAccount();
                    break;
                case 2:
                    bank.addMoney();
                    break;
                case 3:
                    bank.debitMoney();
                    break;
                case 4:
                    bank.displayStatement();
                    break;
                case 5:
                    System.out.println("Exiting SecureBank. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}