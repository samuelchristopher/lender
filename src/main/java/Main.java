public class Main {

    static Loan[] loans = new Loan[100];
    static int loansCount = 0;

    public static void addLoan(String borrower, int amount, double interestRate){
        Loan loan = new Loan(borrower, amount, interestRate);
        loans[loansCount] = loan;
        loansCount++;
    }

    public static void setAsPaid(String borrower){
        for (int i=0; i< loansCount; i++){
            Loan loan = loans[i];
            String loanBorrower = loan.getBorrower();
            if (loanBorrower.equals(borrower)){
                loan.setAsPaid();
            }
        }
    }

    public static void listLoans(){
        for (int i=0; i< loansCount; i++){
            Loan loan = loans[i];
            if (!loan.isPaid()){
                System.out.println(loan.getBorrower() + ": " + loan.getAmount());
            }
        }
    }

    public static double calculateProfitEarned(){
        double profit = 0;
        for (int i=0; i< loansCount; i++){
            // if the loan was repaid, add the interest to profit
            Loan loan = loans[i];
            if (loan.isPaid()){
                profit = profit + (loan.getAmount() * loan.getInterestRate());
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        addLoan("Alice Betsy", 10, 0.1);
        addLoan("Ben Chee", 20, 0.2);
        addLoan("Chris Davis", 30, 0.3);
        setAsPaid("Ben Chee");
        listLoans();
        System.out.println("profit: " + calculateProfitEarned());
    }
}
