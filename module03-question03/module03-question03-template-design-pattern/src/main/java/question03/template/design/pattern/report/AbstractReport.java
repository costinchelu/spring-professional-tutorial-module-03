package question03.template.design.pattern.report;

import java.nio.file.Path;

abstract class AbstractReport {

    public void generateReport(Path file, String text) {
        openFile(file);

        appendHeader();
        appendText(text);
        appendFooter();

        closeFile(file);
    }

    private void openFile(Path file) {
        System.out.println("Opening File " + file.toFile().getName());
    }

    private void closeFile(Path file) {
        System.out.println("Closing File" + file.toFile().getName());
    }

    abstract void appendHeader();

    abstract void appendText(String text);

    abstract void appendFooter();
}
