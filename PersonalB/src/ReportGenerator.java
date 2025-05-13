
/**
 * Generates user financial reports based on income, expenses, and budget data.
 */

import java.util.Map;

public class ReportGenerator {
    public String generate(ReportData data){
        StringBuilder report = new StringBuilder("Report for: " + data.getPeriod() + "\n");
        for (Map.Entry<String, Double> entry : data.getRawData().entrySet()) {
            report.append(entry.getKey()).append(": $").append(entry.getValue()).append("\n");
        }
        return report.toString();
    }
}

