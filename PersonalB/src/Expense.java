/**
 * Represents an expense entry with category, amount, and date.
 */

import java.util.Date;

public class Expense extends Transaction{
    private final String type;

    public Expense(double amount, Date date, String category, String type){
        super(amount, date, category);
        this.type = type;
    }
    public String getType() {return type;}
}