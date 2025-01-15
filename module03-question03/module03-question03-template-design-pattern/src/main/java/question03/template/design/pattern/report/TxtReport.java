package question03.template.design.pattern.report;

public class TxtReport extends AbstractReport {
    @Override
    void appendHeader() {
        System.out.println("Appending Txt Header");
    }

    @Override
    void appendText(String text) {
        System.out.println("Appending Txt Text");
    }

    @Override
    void appendFooter() {
        System.out.println("Appending Txt Text");
    }
}
