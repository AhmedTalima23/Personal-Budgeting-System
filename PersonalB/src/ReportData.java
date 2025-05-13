/**
 * Represents structured data used in financial reports.
 */


import java.util.Map;

public class ReportData {
    private final String period;
    private final Map<String,Double> rawData;

    public ReportData(String period, Map<String,Double> rawData) {
        this.period = period;
        this.rawData = rawData;
    }

    public String getPeriod(){ return period; }
    public Map<String,Double> getRawData(){ return rawData; }
}
