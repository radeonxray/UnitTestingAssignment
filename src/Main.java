public class Main {


    public static void main(String[] args) {

        Main main = new Main();
        Account acc = new Account(0001,55.00,"Bjørn","Kristensen");
        System.out.println(main.calculateYearlyInterest(acc));

    }

    public double calculateYearlyInterest(Account account){

        double yearlyInterest = 0;

        if(account.getAccBalance() > 0 && account.getAccBalance() <= 100){

            yearlyInterest = (account.getAccBalance()/100 * 3);

        } else if (account.getAccBalance() > 100 && account.getAccBalance() < 1000){

            yearlyInterest = (account.getAccBalance()/100 * 5);

        } else if(account.getAccBalance() >= 1000 ){
            System.out.println("7%");
            yearlyInterest = (account.getAccBalance()/100 * 7);
        }

        return yearlyInterest;
    }




}
