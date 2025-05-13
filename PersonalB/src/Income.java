/**
 * Represents an income entry with source, amount, and date.
 */

import java.util.Date;

public class Income extends Transaction{
    private final String source;

    public Income(double amount, String source, Date date, String category) {
        super(amount, date, category);
        this.source = source;
    }

    public Income(double incomeAmount, Date date, String incomeCat, String source) {
        super(incomeAmount, date, incomeCat);
        this.source = source;
    }

    public String getSource() {return source;}
}
