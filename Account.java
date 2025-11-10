import java.util.*;
public class Account
{
    static Scanner sc=new Scanner(System.in);
    //Personal Information;
    private String AccountHolderName;
    private String DateofBirth;
    private String Address;
    private String phono;
    private String email;
    private String AccountType;
    private String identityproof;
    private double Balance;
    ArrayList<String> history=new ArrayList<>();
    void set_name(String AccountHolderName)
    {
        this.AccountHolderName=AccountHolderName;
    }
    void set_dob(String DateofBirth)
    {
        
        this.DateofBirth=DateofBirth;
        
    }
    void set_address(String Address)
    {
        
        this.Address=Address;
    }
    void set_phono(String phono)
    {
        
            this.phono=phono;
    }
    void set_mail(String email)
    {
        this.email=email;
    }
    void set_accounttype(String AccountType)
    {
        this.AccountType=AccountType;
    }
    void set_idp(String identityproof)
    {
        this.identityproof=identityproof;
    }
    void set_balance(double Balance)
    {
        this.Balance=Balance;
    }
    String get_name()
    {
        return AccountHolderName;
    }
    String get_dob()
    {
        return DateofBirth;
    }
    String get_address()
    {
        return Address;
    }
    String get_phono()
    {
        return phono;
    }
    String get_email()
    {
        return email;
    }
    String get_accounttype()
    {
        return AccountType;
    }
    String get_idp()
    {
        return identityproof;
    }
    double get_balance()
    {
        return Balance;
    }
    //dispaly the details
    void display()
    {
        System.out.println("AccountHolderName   : "+AccountHolderName);
        System.out.println("Date_of_Birth       : "+DateofBirth);
        System.out.println("Address             : "+Address);
        System.out.println("Phoneno             : "+phono);
        System.out.println("Email_add           : "+email);
        System.out.println("Accounttype         : "+AccountType);
        System.out.println("Identity_proof      : "+identityproof);
    }
}
class PersonalAccount extends Account
{
    
    void Personal(PersonalAccount x)
    {
        System.out.println("------------    PERSONAL INFROMATION   ----------");
        System.out.print("Enter  AccountHolderName          : ");
        x.set_name(sc.nextLine());
        System.out.println();
        System.out.print("Enter your Date of Birth          : ");
        x.set_dob(sc.nextLine());
        System.out.println();
        System.out.print("Enter your Address                : ");
        x.set_address(sc.nextLine());
        System.out.println();
        System.out.print("Enter your Phone no               : ");
        x.set_phono(sc.next());
        System.out.println();
        System.out.print("Enter your Email Address          : ");
        x.set_mail(sc.next());
        System.out.println();
        System.out.print("Enter your Identity proof         : ");
        x.set_idp(sc.next());
        System.out.println();
        System.out.print("Initial Deposite (Note :>=500)                : ");
        x.set_balance(sc.nextDouble());
        System.out.println();
        x.display();
        System.out.println("----------------ACCOUNT SUCCESSFULL CREATED----------------");
    
    }
    void intrest(PersonalAccount x)
    {
        double intrest=x.get_balance()*0.03;
        x.set_balance(x.get_balance()+intrest);
        System.out.println("Intrest of "+intrest+"added");
    }
    void deposite(double dep,PersonalAccount x)
    {
        x.set_balance(x.get_balance()+dep);
        // return x.get_balance();
        history.add("Deposite $"+dep+" on " +new Date());
    }
    void withdraw(double withdraw,PersonalAccount x)
    {
        if(withdraw <x.get_balance())
        {
            x.set_balance(x.get_balance()-withdraw);
            history.add("withdraw $"+withdraw+" on " +new Date());
        }
        else
        {
            System.out.println("Balance is insufficient");
        }
    }
    void checkbalance(PersonalAccount x)
    {
        System.out.println("Current Balance : "+x.get_balance());
    }
    void transaction_history()
    {
        for(String x:history)
        {
            System.out.println(x);
        }
    }
}
class CurrentAccount extends Account
{
    void current(CurrentAccount y)
    {
        System.out.println("------------    PERSONAL INFORMATION   ----------");
        System.out.print("Enter  AccountHolderName          : ");
        y.set_name(sc.nextLine());
        System.out.println();
        System.out.print("Enter your Date of Birth          : ");
        y.set_dob(sc.nextLine());
        System.out.println();
        System.out.print("Enter your Address                : ");
        y.set_address(sc.nextLine());
        System.out.println();
        System.out.print("Enter your Phone no               : ");
        y.set_phono(sc.next());
        System.out.println();
        System.out.print("Enter your Email Address          : ");
        y.set_mail(sc.next());
        System.out.println();
        System.out.print("Enter your Identity proof         : ");
        y.set_idp(sc.next());
        System.out.println();
        System.out.print("Initial Deposite (Note :>=5000)                : ");
        y.set_balance(sc.nextDouble());
        System.out.println();
        y.display();
        System.out.println("----------------ACCOUNT SUCCESSFULL CREATED----------------");
    }
     void deposite(double dep,CurrentAccount y)
    {
        y.set_balance(y.get_balance()+dep);
        history.add("Deposite $"+dep+" on " +new Date());
    }
    void withdraw(double withdraw,CurrentAccount y)
    {
        if(withdraw <y.get_balance())
        {
            y.set_balance(y.get_balance()-withdraw);
            history.add("Withdraw $"+withdraw+" on " +new Date());
        }
        else
        {
            System.out.println("Balance is insufficient");
        }
    }
    void checkbalance(CurrentAccount y)
    {
        System.out.println("Current Balance : "+y.get_balance());
    }
    void transaction_history()
    {
        for(String x:history)
        {
            System.out.println(x);
        }
    }
}
class Main
{
    static Scanner sc=new Scanner(System.in);
    
    
    String  Account(PersonalAccount x)
    {
        int z=0;
            String nm=x.get_name();
            for(int i=0;i<nm.length();i++)
            {
                if((nm.charAt(i)>='a' && nm.charAt(i)<='z') || (nm.charAt(i)>='A' && nm.charAt(i)<='Z'))
                {
                }
                else{
                    z=1;
                }
            }
            if((x.get_phono().length()==10)&&(x.get_phono().charAt(0)<='9' && x.get_phono().charAt(0)>='6'))
            {}
            else{z=1;}
            if(x.get_balance()>=500)
            {}
            else{z=1;}
            if(z==0)
            {
                return "Activated";
            }
            else
            {   return " Not Acitvated "; }
    }

    public static void main(String[] agrs)
    {
        Scanner sc=new Scanner(System.in);
        PersonalAccount x=new PersonalAccount();
        CurrentAccount y=new CurrentAccount();
        // Main y=new Main();
    
        System.out.println("------------------WELCOME TO THE BB BANK-----------------\nTo create Your Account");
        System.out.println("Choose your Account Type : -\n1 - Personal Account\n2 - CurrentAccount");
      
        int n2=sc.nextInt();
        if(n2==1 )
        {
            x.set_accounttype("Personal Account");
            x.Personal(x);
            x.intrest(x);
            while(true)
            {
                System.out.println("Choose the option   :-\n1 - Deposit\n2 - Withdraw\n3 - Check Balance\n4 - Transaction History\n5 - Exit");
                int n1=sc.nextInt();
                if(n1==1)
                {
                    System.out.print("Enter the Amount to Deposit : ");
                    double dd=sc.nextDouble();
                    x.deposite(dd,x);
                }
                else if(n1==2)
                {
                    System.out.print("Enter the Amount to Withdraw : ");
                    double wd=sc.nextDouble();
                    x.withdraw(wd,x);
                }
                else if(n1==3)
                {
                    x.checkbalance(x);
                    
                }
                else if(n1==4)
                {
                    x.transaction_history();
                }
                else if(n1==5)
                {
                    
                    System.out.println("-------------------------------------------------------");
                    System.out.println("-----------Thank you for visiting the BB Bank----------");
                    System.out.println("--------------------------------------------------------");
                    break;
                }
                else{
                    System.out.println("Choose correct option");
                }
            }
            
            
        }
        else if( n2==2)
        {
            y.set_accounttype("Current Account");
            y.current(y);
            System.out.println("No Intrest Added");
            while(true)
            {
                System.out.println("Choose the option   :-\n1 - Deposit\n2 - Withdraw\n3 - Check Balance\n4 - Transaction History\n5 - Exit");
                int n1=sc.nextInt();
                if(n1==1)
                {
                    System.out.print("Enter the Amount to Deposit : ");
                    double dd=sc.nextDouble();
                    y.deposite(dd,y);
                }
                else if(n1==2)
                {
                    System.out.print("Enter the Amount to Withdraw : ");
                    double wd=sc.nextDouble();
                    y.withdraw(wd,y);

                    
                }
                else if(n1==3)
                {
                    y.checkbalance(y);
                }
                 else if(n1==4)
                {
                    y.transaction_history();
                }
                else if(n1==5)
                {
                    System.out.println("-------------------------------------------------------");
                    System.out.println("-----------Thank you for visiting the BB Bank----------");
                    System.out.println("--------------------------------------------------------");
                    break;
                }
                else{
                    System.out.println("Choose correct option");
                }
            }
        }
        else{
            System.out.println("Invalid Choice ");
        }
        
    
    }
}
