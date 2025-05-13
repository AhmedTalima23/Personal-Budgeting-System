/**
 * Represents a user's budget including income, expenses, and limits.
 */

public class Budget {
    private final String[] categories;
    private final String period;
    double balance;

    public Budget(String[] categories, String period, double balance) {
        this.categories = categories;
        this.period = period;
        this.balance = balance;
    }
    public String[] getCategories() {return categories;}
    public String getPeriod() {return period;}

    public void update(double expenseAmount) {
        balance -= expenseAmount;
    }
}
