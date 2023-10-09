import java.util.*;
class accountdeails{
    static  void register(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter username :");
        String user=sc.nextLine();
        System.out.println("Enter password :");
        String pass=sc.nextLine();
        System.out.println("Entry Successful");
        ATM.prompt();
        while(true){
            display(ATM.name);
            int choice=sc.nextInt();
            if(choice==1){
                login(user,pass);
                break;
            }
            else {
                if(choice==2){
                    System.exit(0);
                }
                else{
                    System.out.println("Wrong Input! Try again!");
                }
            }
        }
    }
    static void display(String name){}
    static void login(String user,String pass){}
}
class transaction{
    static void withdraw(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter amount to Withdrawn :");
        int wcash=sc.nextInt();
        if(wcash<=ATM.balance){
            ATM.balance=ATM.balance-wcash;
            ATM.history.add(Integer.toString(wcash));
            ATM.history.add("Withdraw");
            System.out.println("Amount Rs"+wcash+"/-Withdrawn Successfully");
        }
        else{
            System.out.println("Insufficient Balance!");
        }
        ATM.prompt();
    }
    static void deposit(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter amount to be deposited :");
        int dcash=sc.nextInt();
        ATM.updatebalance(dcash);
        ATM.history.add(Integer.toString(dcash));
        ATM.history.add("Deposit");
        System.out.println("Amount Rs."+dcash+"/- Deposited Successfully!");
        ATM.prompt();
    }
    static void transfer(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Other Persons Name who you want to transfer Money:");
        String s=sc.nextLine();
        System.out.println("Enter the account number of the Person ");
        int num=sc.nextInt();
        System.out.println("Enter the amount to be transferred :");
        int tcash=sc.nextInt();
        if(tcash<=ATM.balance){
            ATM.balance=ATM.balance-tcash;
            ATM.history.add(Integer.toString(tcash));
            ATM.history.add("transferred");
            System.out.println("Amount Rs."+tcash+"/- Transferred Successfully!");
        }
        else{
            System.out.println("Insufficient Balance!");
        }
    }
}
class check{
    static void checkbalance(){
        System.out.println("------------------");
        System.out.println("Avaiable Balance:");
        ATM.showbalance();
        ATM.prompt();
    }
}
class his{
    static void transactionhistory(){
        System.out.println("Transaction History :");
        int s=0;
        if(ATM.balance>0){
            for(int i=0;i<(ATM.history.size()/2);i++)
            {
                for(int j=0;j<2;j++)
                {
                    System.out.print(ATM.history.get(s)+" ");
                    s++;
                }
            }
        }
        else {
            System.out.println("Your Account is Empty");
        }
        ATM.prompt();
    }
}
class ATM {
    public static String name;
    public static int balance=0;
    public static String accnumber;
    public static ArrayList<String> history=new ArrayList<String>();

    static void updatebalance(int dcash){
        balance=balance+dcash;
    }
    static void showbalance(){
        System.out.println(balance);
    }
    public static void homepage(){
        System.out.println("Enter Again");
        Scanner sc=new Scanner(System.in);
        System.out.println("WELCOME TO ATM");
        System.out.println("Select option :");
        System.out.println("1. Register");
        System.out.println("2. Exit");
        System.out.println("Enter choice");
        int choice =sc.nextInt();
        if (choice==1) {
            accountdeails.register();
        }
        else {
            if (choice==2){
                System.exit(0);
            }
            else{
                System.out.println("Select a Option :");
                homepage();
            }
        }
    }
    static void prompt(){
        Scanner sc=new Scanner(System.in);
        System.out.println("WELCOME "+ATM.name+"! TO ATM SYSTEM");
        System.out.println("Select option : ");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Transfer");
        System.out.println("4. Check balance");
        System.out.println("5. Transaction History");
        System.out.println("6. Exit");
        System.out.print("Enter your choice : ");
        int choice=sc.nextInt();
        switch (choice) {
            case 1:
                transaction.withdraw();
            case 2:
                transaction.deposit();
            case 3:
                transaction.transfer();
            case 4:
                check.checkbalance();
            case 5:
                his.transactionhistory();
            case 6:
                System.exit(0);
        }
    }

    public static void main(String[] args) {
        homepage();
    }
}