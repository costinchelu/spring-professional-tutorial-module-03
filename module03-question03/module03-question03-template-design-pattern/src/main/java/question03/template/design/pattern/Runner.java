package question03.template.design.pattern;

import question03.template.design.pattern.report.PdfReport;
import question03.template.design.pattern.report.TxtReport;
import question03.template.design.pattern.report.XlsReport;

import java.nio.file.Paths;

public class Runner {

    public static void main(String[] args) {
        new PdfReport()
                .generateReport(Paths.get("report.pdf"), "report content");

        new XlsReport()
                .generateReport(Paths.get("report.xls"), "report content");

        new TxtReport()
                .generateReport(Paths.get("report.txt"), "report content");
    }
}
