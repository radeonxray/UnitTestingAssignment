public class Account {


    private int accNumber,accInterestRate;
    private double accBalance;
    private String accFirstName, accLastName;

    public Account() {

    }

    public Account(int accNumber, int accInterestRate, double accBalance, String accFirstName, String accLastName) {
        this.accNumber = accNumber;
        this.accInterestRate = accInterestRate;
        this.accBalance = accBalance;
        this.accFirstName = accFirstName;
        this.accLastName = accLastName;
    }

    public int getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(int accNumber) {
        this.accNumber = accNumber;
    }

    public int getAccInterestRate() {
        return accInterestRate;
    }

    public void setAccInterestRate(int accInterestRate) {
        this.accInterestRate = accInterestRate;
    }

    public double getAccBalance() {
        return accBalance;
    }

    public void setAccBalance(double accBalance) {
        this.accBalance = accBalance;
    }

    public String getAccFirstName() {
        return accFirstName;
    }

    public void setAccFirstName(String accFirstName) {
        this.accFirstName = accFirstName;
    }

    public String getAccLastName() {
        return accLastName;
    }

    public void setAccLastName(String accLastName) {
        this.accLastName = accLastName;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accNumber=" + accNumber +
                ", accInterestRate=" + accInterestRate +
                ", accBalance=" + accBalance +
                ", accFirstName='" + accFirstName + '\'' +
                ", accLastName='" + accLastName + '\'' +
                '}';
    }
}
