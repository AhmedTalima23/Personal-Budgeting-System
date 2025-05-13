/**
 * Represents a financial transaction with relevant metadata.
 */

import java.util.Date;

public class Transaction {
    private double amount;
    private final Date date;
    private final String category;

    public Transaction(double amount, Date date, String category) {
        this.amount = amount;
        this.date = date;
        this.category = category;
    }
    public void getAmount(double amount) { this.amount = amount;}
    public double getAmount() { return amount;}
    public Date getDate() { return date;}
    public String getCategory() { return category;}
}
