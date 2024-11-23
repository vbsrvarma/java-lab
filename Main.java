//define the bankinterface
interface BankInterface
{
    double getBalance();           
    double getInterestRate();
}

//implement bankA
class BankA implements BankInterface
 {
    private double balance;
    private final double interestRate = 7.0;

BankA(double balance) {
    this.balance = balance;
}

public double getBalance() 
{
    return balance;
}

public double getInterestRate()
{
    return interestRate;
    }
}

//implement bankB
class BankB implements BankInterface
{
    private double balance;
    private final double interestRate = 7.4;

    BankB(double balance) 
    {
        this.balance = balance;
    }

public double getBalance()
{
    return balance;
}

public double getInterestRate()
{
    return interestRate;
    }
}

//implement bankC
class BankC implements BankInterface
{
    private double balance;
    private final double interestRate = 7.9;

BankC(double balance)
{
    this.balance = balance;
    }

public double getBalance()
{
    return balance;
}

public double getInterestRate()
{
    return interestRate;
    }
}

//main class to test the program
public class Main
{
public static void main(String[] args) {
//instantiate objects for each bank
    BankA bankA=new BankA(10000);
    BankB bankB=new BankB(150000);
    BankC bankC=new BankC(200000);

//display balance and interest rate for each bank
    System.out.println("BankA:");
    System.out.println("Balance:" + bankA.getBalance());
    System.out.println("Interest Rate:" + bankA.getInterestRate() + "%");

    System.out.println("\nBankB:");
    System.out.println("Balance:" + bankB.getBalance());
    System.out.println("Interest Rate:" + bankB.getInterestRate() + "%");

    System.out.println("\nBankC:");
    System.out.println("Balance:" + bankC.getBalance());
    System.out.println("Interest Rate:" + bankC.getInterestRate() + "%");
    }
}